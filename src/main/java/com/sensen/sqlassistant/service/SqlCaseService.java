package com.sensen.sqlassistant.service;

import com.sensen.sqlassistant.dao.SqlCaseDao;
import com.sensen.sqlassistant.model.SqlCase;
import com.sensen.sqlassistant.model.SqlCaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SqlCaseService {
    @Autowired
    SqlCaseDao sqlCaseDao;
    @Transactional(rollbackFor = Exception.class)
    public String saveSqlDataBatch(List<SqlCase> data){
        sqlCaseDao.saveBatch(data);
        return "ok";
    }

    public List<SqlCaseDto> getSqlData(String userId){
        return  sqlCaseDao.selectSqlCase(userId);
    }

    public List<SqlCase> getSqlDataDetail(String userId, String service, String name){
        return  sqlCaseDao.selectSqlCaseDetail(userId, service, name);
    }

    public void updateFileStorageId(int id, int fileStorageId){
          sqlCaseDao.updateFileStorageId(id, fileStorageId);
    }
}
