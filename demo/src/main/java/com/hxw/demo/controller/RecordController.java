package com.hxw.demo.controller;

import com.hxw.demo.bean.Record;
import com.hxw.demo.bean.RequestService;
import com.hxw.demo.bean.User;
import com.hxw.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController
{

    @Autowired
    private RecordService recordService;

    @PostMapping
    public int insertRecord(@RequestBody Record record) {
        return recordService.insertRecord(record);
    }

    @DeleteMapping("/{id}")
    public int deleteRecord(@PathVariable String id) {
        return recordService.deleteRecord(id);
    }

    @PutMapping
    public int updateRecord(@RequestBody Record record) {
        return recordService.updateRecord(record);
    }

    @GetMapping
    @CrossOrigin
    public List<Record> getRecords() {
        return recordService.getRecords();
    }

    @PostMapping("/transfer")
    @CrossOrigin
    public String transferMoney(@RequestBody RequestService requestService) {
        if (recordService.transferMoney(requestService.getMyPhoneNum(), requestService.getOtherPhoneNum(), requestService.getOtherName(), requestService.getMoney())) {
            return "转账成功";
        } else {
            return "转账失败";
        }
    }

}
