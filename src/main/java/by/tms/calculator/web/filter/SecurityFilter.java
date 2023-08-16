package by.tms.calculator.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Simon Pirko on 2.08.23
 */

@WebFilter(servletNames = {"OperationServlet", "LogoutServlet"})
public class SecurityFilter extends HttpFilter {

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    if (req.getSession().getAttribute("currentUser") != null) {
      chain.doFilter(req, res);
    } else {
      res.sendRedirect("/");
    }
  }
}