package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/mineServlet"
		)


public class mineServlet extends HttpServlet  {
	
	static final long serialVersionUID = 35L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Writer responseWriter = resp.getWriter();
    	try {   
    		Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
    		System.out.println("1");
		    String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
		    System.out.println(id);
		    int intId = Integer.parseInt(id); 
		    System.out.println("3");
		    Todo todo= Service.getTodo(intId);
		    System.out.println("4");
		    ArrayList<Todo> listaTodos = new ArrayList<Todo>();
		    System.out.println("5");
		    listaTodos.add(todo);
		    System.out.println("6");
		    responseWriter.write(Service.todosToHTMLTable(listaTodos));
		    System.out.println("7");
		    
	    }catch (java.lang.NumberFormatException e) {
			responseWriter.write("requerimiento inválido");
		}catch (MalformedURLException e) {
			responseWriter.write("error interno en el servidor");
		}catch(Exception e) {
			responseWriter.write("requerimiento inválido");
		}
    }
}
