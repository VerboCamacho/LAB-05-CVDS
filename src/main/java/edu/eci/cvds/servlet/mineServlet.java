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
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Writer responseWriter = resp.getWriter();
    	try {   
    		Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
		    int intId = Integer.parseInt(optName.get()); 
		    Todo todo= Service.getTodo(intId); 
		    ArrayList<Todo> listaTodos = new ArrayList<Todo>();    
		    listaTodos.add(todo);
		    resp.setStatus(HttpServletResponse.SC_OK);
		    responseWriter.write(Service.todosToHTMLTable(listaTodos));
		    responseWriter.flush();   
		    
	    }catch (java.lang.NumberFormatException e) {
			responseWriter.write("Requerimiento inv�lido");
		}catch (MalformedURLException e) {
			responseWriter.write("Error interno en el servidor");
		}catch(Exception e) {
			responseWriter.write("Requerimiento inv�lido");
		}
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Writer responseWriter = resp.getWriter();
    	try {   
    		Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
		    int intId = Integer.parseInt(optName.get()); 
		    Todo todo= Service.getTodo(intId); 
		    ArrayList<Todo> listaTodos = new ArrayList<Todo>();    
		    listaTodos.add(todo);
		    resp.setStatus(HttpServletResponse.SC_OK);
		    responseWriter.write(Service.todosToHTMLTable(listaTodos));
		    responseWriter.flush();  
		    
	    }catch (java.lang.NumberFormatException e) {
			responseWriter.write("Requerimiento inv�lido");
		}catch (MalformedURLException e) {
			responseWriter.write("Error interno en el servidor");
		}catch(Exception e) {
			responseWriter.write("Requerimiento inv�lido");
		}
		
	}
}
