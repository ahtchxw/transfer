package com.hxw.demo.dao;

import com.hxw.demo.bean.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordDao {
    /**
     * 插入
     * @param record
     * @return
     */
    int insertRecord(Record record);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteRecord(String id);

    /**
     * 查询
     * @return
     */
    List<Record> getRecords();

    /**
     * 更新
     * @param record
     * @return
     */
    int updateRecord(Record record);
}

