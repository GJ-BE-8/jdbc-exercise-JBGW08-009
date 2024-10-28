package com.nhnacademy.jdbc.student.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionTest {

    private final String url = "jdbc:mysql://133.186.241.167:3306/nhn_academy_9";
    private final String user = "nhn_academy_9";
    private final String password = "iRz&E!F&XxG4d?kP";

    @Test
    void driverManager() throws SQLException {

        Connection connection = DriverManager.getConnection (url, user, password);
        Connection connection1 = DriverManager.getConnection (url, user, password);
        Connection connection2 = DriverManager.getConnection (url, user, password);

        log.info("connection : {}, class : {}", connection, connection.getClass());
        log.info("connection : {}, class : {}", connection2, connection2.getClass());

    }

    @Test
    void dataSourceConnectionPool() {
        //커넥션 풀링
//        new
    }

    @Test
    void datasourceDriverManager() throws SQLException{
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);

        Connection con1 = basicDataSource.getConnection();
        Connection con2 = basicDataSource.getConnection();

        log.info("connection : {}, class : {}", con1, con1.getClass());
        log.info("connection : {}, class : {}", con2, con2.getClass());

    }

}
