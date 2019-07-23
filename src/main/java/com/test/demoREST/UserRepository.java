package com.test.demoREST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository 
{
	Connection con=null;
	
	public UserRepository() 
	{
		String url="jdbc:mysql://localhost:3307/REST_API_DB";
		String user="root";
		String pass="root";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<User> GetUsers()
	{
		List<User> users_List =new ArrayList<User>();
		String sql="SELECT * FROM user";
		try 
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) 
			{
				User us=new User();
				us.setUser_id(rs.getInt("uid"));
				us.setUser_name(rs.getString("uname"));
				us.setUser_occupation(rs.getString("uoccup"));
				
				users_List.add(us);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return users_List;
	}
	
	public User getUser(int id) 
	{
		User u=new User();
		String sql="SELECT * FROM user WHERE uid="+id;
		try 
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) 
			{
				u.setUser_id(rs.getInt("uid"));
				u.setUser_name(rs.getString("uname"));
				u.setUser_occupation(rs.getString("uoccup"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return u;
	}
	public void CreateUser(User u) 
	{
		String sql="insert into user values(?,?,?)";
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, u.getUser_id());
			st.setString(2, u.getUser_name());
			st.setString(3, u.getUser_occupation());
			
			st.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void DeleteUser(int id) 
	{
		String sql="DELETE FROM user WHERE uid=?";
		try 
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	public void UpdateUser(User u) 
	{
		String sql="UPDATE user SET uname=?,uoccup=? WHERE uid=?";
		try 
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, u.getUser_name());
			st.setString(2, u.getUser_occupation());
			st.setInt(3, u.getUser_id());
			
			st.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
}
