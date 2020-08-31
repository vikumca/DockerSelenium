package com.JavaSelenium.TestFactory.core.utils;

import com.JavaSelenium.TestFactory.core.logger.Logs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAccess {
    private Statement statement = null;
    /**
     * The ResultSet object.
     */
    private ResultSet rs = null;

    public Connection getConnection() throws Exception {
        String user = Config.getConfigProperty("DBUserName");
        String pwd = Config.getConfigProperty("DBPassword");
        String connectionURL = Config.getConfigProperty("DBServer");
        Logs.trace("Getting the connection object");
        Class.forName(Config.getConfigProperty("DBClassName"));
        return DriverManager.getConnection(connectionURL, user, pwd);
    }

    public String executeQuery(Connection con, String query, int rowNum, String colName) throws Exception {
        Logs.info("Executing executeQuery() with the query:" + query + ", required row number:" + rowNum + " and the required column name:" + colName);
        if (query.startsWith("s") || query.startsWith("S")) {
            Logs.trace("Creating the statement object from the connection object");
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Logs.trace("Executing the select query:" + query);
            rs = statement.executeQuery(query);
            rs.absolute(rowNum);
            return rs.getString(colName);
            //return rs.getString(colNum);
        } else {
            Logs.warn("The passed query is non select query. Use executeUpdate() to execute this query!");
            throw new Exception("This method will execute only select queries. Use executeUpdate()");
        }
    }

    public ResultSet executeQuery(Connection con, String query) throws Exception {
        Logs.info("Executing executeQuery() with the query:" + query );
        if (query.startsWith("s") || query.startsWith("S")) {
            Logs.trace("Creating the statement object from the connection object");
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Logs.trace("Executing the select query:" + query);
            rs = statement.executeQuery(query);
            return rs;
        } else {
            Logs.warn("The passed query is non select query. Use executeUpdate() to execute this query!");
            throw new Exception("This method will execute only select queries. Use executeUpdate()");
        }
    }
}
