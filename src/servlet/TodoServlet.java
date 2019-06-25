package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/todoservlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Todo> todos = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        Todo t1 = new Todo();
        t1.setAuthor("Jack");
        t1.setName("Prepare requirements docs");
        t1.setId(1);
        Todo t2 = new Todo();
        t2.setAuthor("Henry");
        t2.setName("Develop new UI");
        t2.setId(2);
        Todo t3 = new Todo();
        t3.setAuthor("Kevin");
        t3.setName("Test new release");
        t3.setId(3);
        todos.add(t1);
        todos.add(t2);
        todos.add(t3);        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsp = "/jsp/todos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		request.setAttribute("todos", this.todos);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String author = request.getParameter("author").toString();
		String task = request.getParameter("task").toString();
		Todo t = new Todo();
		t.setAuthor(author);
		t.setName(task);
		Integer id = this.todos.size() + 1;
		t.setId(id);
		this.todos.add(t);
		String jsp = "/jsp/todos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		request.setAttribute("todos", this.todos);
		dispatcher.forward(request, response);
	}

}
