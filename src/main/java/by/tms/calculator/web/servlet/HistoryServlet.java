package by.tms.calculator.web.servlet;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Simon Pirko on 2.08.23
 */

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

  private final OperationService operationService = new OperationService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User currentUser = (User) req.getSession().getAttribute("currentUser");
    List<Operation> history = operationService.getHistory(currentUser);
    req.setAttribute("items", history);
    getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
  }
}
