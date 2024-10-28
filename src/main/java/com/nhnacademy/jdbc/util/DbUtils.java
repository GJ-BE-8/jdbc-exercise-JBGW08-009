package com.nhnacademy.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

public class DbUtils {
    public DbUtils(){
        throw new IllegalStateException("Utility class");
    }

//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            //todo connection.
//            connection = DriverManager.getConnection("jdbc:mysql://133.186.241.167:3306/nhn_academy_0","nhn_academy_0","1j0OTaJgkS1@$dWl");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return connection;
//    }

    private static final DataSource DATASOURCE;

    static {
        BasicDataSource basicDataSource = new BasicDataSource();

        final String url = "jdbc:mysql://133.186.241.167:3306/nhn_academy_9";;
        final String name = "nhn_academy_9";
        final String password = "iRz&E!F&XxG4d?kP";

        //todo#0 {ip},{database},{username},{password}
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(name);
        basicDataSource.setPassword(password);

        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(5);
        basicDataSource.setMaxIdle(5);
        basicDataSource.setMinIdle(5);

        basicDataSource.setMaxWait(Duration.ofSeconds(2));
        basicDataSource.setValidationQuery("select 1");
        basicDataSource.setTestOnBorrow(true);
        DATASOURCE = basicDataSource;
    }

    public static DataSource getDataSource(){
        return DATASOURCE;
    }

}