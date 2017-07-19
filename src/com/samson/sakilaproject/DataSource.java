package com.samson.sakilaproject;

	import java.beans.PropertyVetoException;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.apache.commons.dbcp.BasicDataSource;

	// This class will have code for creating Database Connection, 
	// Closing Connections and all database related code
	public class DataSource {
		
		private static DataSource datasource;
	    private BasicDataSource ds;

	    private DataSource() throws IOException, SQLException, PropertyVetoException {
	        ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUsername("root");
	        ds.setPassword("password123");
	        ds.setUrl("jdbc:mysql://localhost/sakila");
		    
	        // setting the properties for DataSource
	        ds.setInitialSize(5);
	        ds.setMinIdle(5);
	        ds.setMaxIdle(20);
	        ds.setMaxOpenPreparedStatements(180);
	}

	    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
	        if (datasource == null) {
	            datasource = new DataSource();
	            return datasource;
	        } else {
	            return datasource;
	        }
	    }
	    
	    public Connection getConnection() throws SQLException {
	        return this.ds.getConnection();
	    }
	    
	    
	    public void closeConnection(Statement statement, Connection connection, ResultSet resultSet) throws SQLException {
	    	
	    	 if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {e.printStackTrace(); throw e;}
	         if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace(); throw e;}
	         if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace(); throw e;}
	    	
	    	
	    }
	    
	    public void closeConnection(PreparedStatement statement, Connection connection, ResultSet resultSet) throws SQLException {
	    	
	   	 if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {e.printStackTrace(); throw e;}
	     if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace(); throw e;}
	     if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace(); throw e;}
	   	
	   	
	   }
	  
	    
	}


