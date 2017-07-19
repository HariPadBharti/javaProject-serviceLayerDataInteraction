package com.samson.sakilaproject.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.samson.sakilaproject.DataSource;
import com.samson.sakilaproject.dbo.ActorDbo;

public class ActorDao implements IActorDao{

	@Override
	public List<ActorDbo> findAll() {
		List<ActorDbo> actorList = new ArrayList<ActorDbo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			StringBuilder sbr = new StringBuilder();
			sbr.append("select actor_id,first_name,last_name from sakila.actor");
			pstmt = con.prepareStatement(sbr.toString());
			System.out.println("Executing query .. "+ sbr.toString());
			rs = pstmt.executeQuery();
			ActorDbo actorDbo = null;
			while(rs.next()){
				actorDbo = new ActorDbo();
				actorDbo.setActorId(rs.getInt("actor_id"));
				actorDbo.setFirstName(rs.getString("first_name"));
				actorDbo.setLastName(rs.getString("last_name"));
				actorList.add(actorDbo);
				//System.out.println("coming here"+actorDbo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				DataSource.getInstance().closeConnection(pstmt, con, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
		System.out.println(actorList);
		return actorList;
	}

	@Override
	public ActorDbo findById(int id) {
		ActorDbo aDbo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			StringBuilder sbr = new StringBuilder();
			sbr.append("select actor_id,first_name,last_name from sakila.actor where actor_id = " + id);
			pstmt = con.prepareStatement(sbr.toString());
			System.out.println("I am executing query here : " + sbr.toString());
			rs = pstmt.executeQuery();
			System.out.println("result"+rs);
			
			if (rs.next()) {
				aDbo = new ActorDbo();
				aDbo.setActorId(rs.getInt("actor_id"));
				aDbo.setFirstName(rs.getString("first_name"));
				aDbo.setLastName(rs.getString("last_name"));

			}
			//System.out.println("Resulttttt" +aDbo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				try {
					DataSource.getInstance().closeConnection(pstmt, con, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException | PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return aDbo;
	}

	@Override
	public int insert(ActorDbo actorDbo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			con = DataSource.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into sakila.actor (actor_id,first_name,last_name)  values (?,?,?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, actorDbo.getActorId());
			pstmt.setString(2, actorDbo.getFirstName());
			pstmt.setString(3, actorDbo.getLastName());
			System.out.println("I am executing query here : " + sql);
			i = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				try {
					DataSource.getInstance().closeConnection(pstmt, con, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException | PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return i;		
	}
	
	public static void main(String[] args) {
		ActorDao ac = new ActorDao();
		ac.findAll();
		ActorDbo actorDbo = new ActorDbo();
		actorDbo.setActorId(999);
		actorDbo.setFirstName("Suhas");
		actorDbo.setLastName("AV");
		ac.insert(actorDbo);
		//ac.findById(int id);
		
	}

}
