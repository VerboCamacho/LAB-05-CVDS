package edu.eci.cvds.servlet.model;

import java.util.Set;


public class Todo {
	int userId;
	int id;
	String title;
	Boolean completed;
	
	
	private void setUserId(int userId) {
		// TODO Auto-generated method stub
		this.userId=userId;
	}
	
	private void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	private void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
	private void setCompleted(boolean completed) {
		// TODO Auto-generated method stub
		this.completed = completed;
	}

	public int getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public boolean getCompleted() {
		// TODO Auto-generated method stub
		return completed;
	}
	
}
