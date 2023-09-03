package com.sensen.sqlassistant.dao;

import com.sensen.sqlassistant.model.SqlCase;
import com.sensen.sqlassistant.model.SqlCaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Repository
public class SqlCaseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加
     *
     * @param data
     * @return
     */
    public int save(SqlCase data) {
        String sql = "insert into sql_case(name,base_type,file_name,file_path,user_id,service) values(?,?,?,?,?,?);";
        int result = jdbcTemplate.update(sql,
                data.getName(),
                data.getBaseType(),
                data.getFileName(),
                data.getFilePath(),
                data.getUserId(),
                data.getService());
        return result;
    }

    /**
     * 添加
     *
     * @param data
     * @return
     */
    public void saveBatch(List<SqlCase> data) {

        String sql = "insert into sql_case(name,base_type,file_name,file_path,user_id,service) values(?,?,?,?,?,?);";
        int[] ints = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                SqlCase sqlCase = data.get(i);
                preparedStatement.setString(1, sqlCase.getName());
                preparedStatement.setString(2, sqlCase.getBaseType());
                preparedStatement.setString(3, sqlCase.getFileName());
                preparedStatement.setString(4, sqlCase.getFilePath());
                preparedStatement.setString(5, sqlCase.getUserId());
                preparedStatement.setString(6, sqlCase.getService());
            }

            @Override
            public int getBatchSize() {
                return data.size();
            }
        });
    }

    /**
     * 根据id修改
     *
     * @param
     * @return
     */
    public int update(SqlCase data) {
        String sql = "update sql_case set name=?,base_type=?,file_name=?,file_path=?,service=?,user_id=? where " +
                "id=?;";
        int result = jdbcTemplate.update(sql, data.getName(),
                data.getBaseType(),
                data.getFileName(), data.getFilePath(),
                data.getService(), data.getUserId(), data.getId());
        return result;
    }

    /**
     * 根据id删除
     *
     * @param
     * @return
     */
    public int delete(int id) {
        String sql = "delete from sql_case where id=? ;";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }

    /**
     * 查询
     *
     * @param
     * @return
     */
    public List<SqlCaseDto> selectSqlCase(String userId) {
        String sql = "select distinct name, service, user_id from sql_case where user_id= ?";
        List<SqlCaseDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SqlCaseDto.class),  userId);
        return list;

    }

    /**
     * 查询
     *
     * @param
     * @return
     */
    public List<SqlCase> selectSqlCaseDetail(String userId, String service, String name) {
        String sql = "select * from sql_case where user_id= ? and service=? and name = ?";
        List<SqlCase> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SqlCase.class),  userId, service, name);
        return list;

    }

    /**
     * 根据id修改
     *
     * @param
     * @return
     */
    public void updateFileStorageId(int id, int fileStorageId) {
        String sql = "update sql_case set file_storage_id=? where id=?;";
        int result = jdbcTemplate.update(sql, fileStorageId, id);

    }
}
