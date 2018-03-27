package com.lessionThree.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;

public class UserDao {

        //创建jdbcTemplate对象，设置数据
        private JdbcTemplate jdbcTemplate;

        public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

        //创建sql语句
        public void add(Serializable id) {
            String sql = "INSERT INTO STUDENT (NAME,AGE)VALUES(?,?,?)";

            jdbcTemplate.update(sql, "monk", "29");
        }

        public void delete(Serializable id) {
            String sql = "DELETE FROM STUDENT WHRER ID = ?";
            jdbcTemplate.update(sql, id);
        }

        public void update(Student entity) {
            String sql = "UPDATE STUDENT SET NAME=?, AGE=?, WHERE ID=?";
            jdbcTemplate.update(sql, entity.getName(), entity.getAge(), entity.getId());
        }

        public Student getById(Serializable id) {
            String sql = "SELECT ID,NAME,AGE FROM STUDENT WHERE ID = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
        }

        public List<Student> getAll() {
            String sql = "SELECT ID,NAME,AGE FROM STUDENT ";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        }


}
