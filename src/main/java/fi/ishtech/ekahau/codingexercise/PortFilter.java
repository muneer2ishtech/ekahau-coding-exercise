package fi.ishtech.ekahau.codingexercise;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Muneer Ahmed Syed
 */
@Slf4j
@Component
@Order(1)
public class PortFilter implements Filter {

	@Value("${fi.istech.ekahau.additional-ports:false}")
	private boolean additionalPorts;

	@Value("${fi.istech.ekahau.user-port:}")
	private Integer userPort;

	@Value("${fi.istech.ekahau.book-port:}")
	private Integer bookPort;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		log.debug("PORT:{}, URI:{}", req.getLocalPort(), req.getRequestURI());

		if (this.additionalPorts) {
			if (this.userPort == req.getLocalPort() && StringUtils.containsIgnoreCase(req.getRequestURI(), "/books")) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Port");
			}
			if (this.bookPort == req.getLocalPort() && StringUtils.containsIgnoreCase(req.getRequestURI(), "/users")) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Port");
			}
		}

		fc.doFilter(request, response);
	}

}
