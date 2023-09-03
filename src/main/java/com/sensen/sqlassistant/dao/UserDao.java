package com.sensen.sqlassistant.dao;

import com.sensen.sqlassistant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加
     *
     * @param data
     * @return
     */
    public int save(User data) {
        String sql = "insert into user(id) values(?);";
        int result = jdbcTemplate.update(sql,
                data.getUserId());
        return result;
    }


    /**
     *是否存在
     *
     * @param
     * @return
     */
    public int exist(String userId) {
        String sql = "select count(*) from user where id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        return count;
    }


}
