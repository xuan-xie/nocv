package com.example.controller;

import com.example.entity.NocvData;
import com.example.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/queryall")
    public List<NocvData> queryAll(){
        List<NocvData> list = indexService.list();
        return list;
    }

    @RequestMapping("/querybar")
    public Map<String,List> queryBar(){
        List<NocvData> nocvDataList = indexService.list();
        List<String> cityList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        for (NocvData nocvData: nocvDataList) {
            cityList.add(nocvData.getName());
            valueList.add(nocvData.getValue());
        }
        Map<String,List> map = new HashMap<>();
        map.put("cityList", cityList);
        map.put("valueList", valueList);
        return map;
    }
}
