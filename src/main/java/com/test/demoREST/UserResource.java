package com.test.demoREST;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("UserResources")
public class UserResource {
	
	UserRepository UR=new UserRepository();
	
	@GET
	@Path("user/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<User> GetUserList() 
	{
		List<User> users=UR.GetUsers();
		return users;
	} 
	
	@POST
	@Path("user/create")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User CreateUser(User u) 
	{
		UR.CreateUser(u);
		System.out.println(u.Get());
		return u;
	}
	
	@GET
	@Path("user/find/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User GetUser(@PathParam("id") int id) 
	{
		User u=UR.getUser(id);
		return u;
	}
	
	@DELETE
	@Path("user/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User DeleteUser(@PathParam("id") int id) 
	{	
		User u=UR.getUser(id);
		UR.DeleteUser(id);
		return u;
	}
	
	@PUT
	@Path("user/update")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User UpdateUser(User u) 
	{
		UR.UpdateUser(u);
		System.out.println(u.Get());
		return u;
	}
}
