package com.hxw.demo.service.impl;

import com.hxw.demo.bean.Record;
import com.hxw.demo.bean.User;
import com.hxw.demo.dao.RecordDao;
import com.hxw.demo.dao.UserDao;
import com.hxw.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RecordServiceImp implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private UserDao userDao;

    @Override
    public int insertRecord(Record record) {
        return recordDao.insertRecord(record);
    }

    @Override
    public int deleteRecord(String id) {
        return recordDao.deleteRecord(id);
    }

    @Override
    public List<Record> getRecords() {
        return recordDao.getRecords();
    }

    @Override
    public int updateRecord(Record record) {
        return recordDao.updateRecord(record);
    }

    @Override
    public boolean transferMoney(String myPhoneNume, String otherPhoneNum, String otherName, int money) {
        User myUser = userDao.getByPhoneNum(myPhoneNume);
        User otherUser = userDao.getByPhoneNum(otherPhoneNum);
        if (otherUser.getName().equals(otherName) && otherUser.getPhoneNum().equals(otherPhoneNum)) {
            if (myUser.getMoney() >= money) {
                myUser.setMoney(myUser.getMoney() - money);
                otherUser.setMoney(otherUser.getMoney() + money);
                Date date = new Date();
                Record myRecord = new Record(myUser.getName(), myUser.getPhoneNum(), date, "-" + money);
                Record otherRecord = new Record(otherUser.getName(), otherUser.getPhoneNum(), date, "+" + money);
                recordDao.insertRecord(myRecord);
                recordDao.insertRecord(otherRecord);
                userDao.updateUser(myUser);
                userDao.updateUser(otherUser);
                return true;
            } else {
                System.out.println("余额不足");
                return false;
            }
        } else {
            System.out.println("账号密码不正确");
            return false;
        }
    }
}
