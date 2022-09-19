package com.example.controller;

import com.example.entity.NocvData;
import com.example.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/query")
    public List<NocvData> queryData(){
        List<NocvData> list = indexService.list();
        return list;
    }
}
