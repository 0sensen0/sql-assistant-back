package com.sensen.sqlassistant.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sensen.sqlassistant.model.SqlCase;
import com.sensen.sqlassistant.model.SqlCaseDto;
import com.sensen.sqlassistant.service.SqlCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class SqlDataController {

    @Autowired
    private SqlCaseService sqlCaseService;

    @PostMapping(value = "/saveSqlData")
    public String saveSqlData(String data, String userId, String service, String name) {
        JSONArray objects = JSONObject.parseArray(data);
        ArrayList<SqlCase> sqlCases = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            JSONObject jsonObject = objects.getJSONObject(i);
            SqlCase sqlCase = new SqlCase();
            sqlCase.setBaseType(jsonObject.getString("baseType"));
            sqlCase.setFileName(jsonObject.getString("fileName"));
            sqlCase.setFilePath(jsonObject.getString("filePath"));
            sqlCase.setUserId(userId);
            sqlCase.setService(service);
            sqlCase.setName(name);
            sqlCases.add(sqlCase);
        }
        sqlCaseService.saveSqlDataBatch(sqlCases);

        return "ok";
    }

    @GetMapping(value = "/getSqlData")
    public List<SqlCaseDto> getSqlData(@RequestParam("user_id") String userId) {
        List<SqlCaseDto> sqlData = sqlCaseService.getSqlData(userId);
        return sqlData;
    }

    @GetMapping(value = "/getSqlDataDetail")
    public List<SqlCase> getSqlDataDetail(@RequestParam("user_id") String userId,
                                          @RequestParam("service") String serivce,
                                          @RequestParam("name") String name) {
        List<SqlCase> sqlData = sqlCaseService.getSqlDataDetail(userId, serivce, name);
        return sqlData;
    }

    @GetMapping(value = "/updateFileStorageId")
    public String updateFileStorageId(@RequestParam("id") int id,
                                      @RequestParam("fileStorageId") int fileStorageId) {
        String msg = "success";
        try {
            sqlCaseService.updateFileStorageId(id, fileStorageId);
        } catch (Exception e) {
            log.error(e.getMessage());
            msg = "fail";
        }
        return msg;
    }

    /**
     * 执行sql脚本
     *
     * @param userId
     * @param serivce
     * @param name
     * @param baseType
     * @return
     */
    @GetMapping(value = "/run")
    public String runSqlCase(@RequestParam("user_id") String userId,
                             @RequestParam("service") String serivce,
                             @RequestParam("name") String name,
                             @RequestParam("baseType") String baseType
    ) {
        // 1.判断数据库类型

        // 2.查询数据库脚本


        // 3.下载脚本文件到指定位置

        // 4.执行oracle


        // 5.执行mysql


        // 6.执行oceanbase

        // 7.执行tidb

        String msg = "success";

        return msg;
    }


}
