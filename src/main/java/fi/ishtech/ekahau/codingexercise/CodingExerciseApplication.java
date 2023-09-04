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
import org.springframework.util.Assert;

@SpringBootApplication
public class CodingExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingExerciseApplication.class, args);
	}

	@Value("${server.additional-ports:false}")
	private boolean additionalPorts;

	@Value("${server.user-port:}")
	private Integer userPort;

	@Value("${server.book-port:}")
	private Integer bookPort;

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
		if (this.additionalPorts) {
			Assert.state(this.userPort != null, "Port for '**/users/**' canot be null");
			Assert.state(this.bookPort != null, "Port for '**/books/**' canot be null");
		} else {
			return null;
		}

		List<Connector> connectors = new ArrayList<>();

		Connector connector1 = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector1.setScheme("http");
		connector1.setPort(this.userPort);
		connectors.add(connector1);

		Connector connector2 = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector2.setScheme("http");
		connector2.setPort(this.bookPort);
		connectors.add(connector2);

		return connectors.toArray(new Connector[] {});
	}

}
