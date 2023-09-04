package fi.ishtech.ekahau.codingexercise;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class CodingExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingExerciseApplication.class, args);
	}

	@Value("${server.additionalPorts:}")
	String additionalPorts;

	@Bean
	ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

		Connector[] additionalConnectors = additionalConnectors();
		if (additionalConnectors != null && additionalConnectors.length != 0) {
			tomcat.addAdditionalTomcatConnectors(additionalConnectors);
		}

		return tomcat;
	}

	private Connector[] additionalConnectors() {
		if (!StringUtils.hasLength(this.additionalPorts)) {
			return null;
		}

		String[] ports = this.additionalPorts.split(",");

		List<Connector> result = new ArrayList<>();

		for (String port : ports) {
			Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
			connector.setScheme("http");
			connector.setPort(Integer.valueOf(port));
			result.add(connector);
		}

		return result.toArray(new Connector[] {});
	}

}
