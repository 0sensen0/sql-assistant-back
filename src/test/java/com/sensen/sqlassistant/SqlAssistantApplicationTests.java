package com.sensen.sqlassistant;

import com.sensen.sqlassistant.dao.SqlCaseDao;
import com.sensen.sqlassistant.model.SqlCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SqlAssistantApplicationTests {

    @Autowired
    private SqlCaseDao sqlCaseDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        for (Map<String,Object> map : maps){
            System.out.println(map);
        }
    }



    @Test
    public void saveCheckInfoTest() {
        SqlCase data = new SqlCase();
        data.setName("pbs新增接口");
        data.setBaseType("oracle");
        data.setFileName("test.sql");
        data.setFilePath("C:\\Users\\55236\\Documents\\WeChat Files\\wxid_rn97c5uauqud22\\FileStorage\\File\\2023-06\\test.sql");
        data.setService("pbs");
        data.setUserId("yangsen40900");
        int result = sqlCaseDao.save(data);
        System.out.println("添加结果:" + (result > 0 ? "成功" : "失败"));
    }

    @Test
    public void updatCheckInfoTest() {
        SqlCase data = new SqlCase();
        data.setName("omc新增接口");
        data.setBaseType("oracle");
        data.setFileName("test.sql");
        data.setFilePath("C:\\Users\\55236\\Documents\\WeChat Files\\wxid_rn97c5uauqud22\\FileStorage\\File\\2023-06\\test.sql");
        data.setService("pbs");
        data.setUserId("yangsen40900");
        data.setId(1);
        int result = sqlCaseDao.update(data);
        System.out.println("修改结果:" + (result > 0 ? "成功" : "失败"));
    }

    @Test
    public void deleteCheckInfoTest() {

        int result = sqlCaseDao.delete(1);

        System.out.println("删除结果:" + (result > 0 ? "成功" : "失败"));
    }

}
