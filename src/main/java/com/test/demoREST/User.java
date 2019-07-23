package com.test.demoREST;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private int user_id;
	private String user_name;
	private String user_occupation;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_occupation() {
		return user_occupation;
	}
	public void setUser_occupation(String user_occupation) {
		this.user_occupation = user_occupation;
	}
	
	public String Get() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_occupation=" + user_occupation + "]";
	}
	
	
	
}
