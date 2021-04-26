package com.hxw.demo.service;

import com.hxw.demo.bean.Record;

import java.util.List;

public interface RecordService {

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

    /**
     * 转账
     * @param myPhoneNume
     * @param otherPhoneNum
     * @param otherName
     * @param money
     */
    boolean transferMoney(String myPhoneNume, String otherPhoneNum, String otherName, int money);

}