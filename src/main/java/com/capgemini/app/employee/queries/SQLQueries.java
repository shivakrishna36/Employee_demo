package com.capgemini.app.employee.queries;

import java.util.ResourceBundle;

public final class SQLQueries {

	
	private static SQLQueries sqlqueries = new SQLQueries();
	private SQLQueries() {}
	public static SQLQueries getInstance()
	{
		return sqlqueries;
	}
	
	public String insertQuery()
	{
		ResourceBundle bundle = ResourceBundle.getBundle("SqlQueries");
		return bundle.getString("InsertQuery");
	}
}
