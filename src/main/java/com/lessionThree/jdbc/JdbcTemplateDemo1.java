package com.lessionThree.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcTemplateDemo1 {

        //设置数据库信息

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql:///spring_day03");
//        dataSource.setUsername("root");
//        dataSource.setPassword("feng0828");

        //创建jdbcTemplate对象，设置数据源
        private JdbcTemplate jdbcTemplate;
        public void setDataSource(DataSource ds) {
            this.jdbcTemplate = new JdbcTemplate(ds);
        }
}
