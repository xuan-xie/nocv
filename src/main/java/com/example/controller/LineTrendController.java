package com.example.controller;

import com.example.entity.LineTrend;
import com.example.service.LineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LineTrendController {
    @Resource
    LineService lineService;

    @RequestMapping("/queryline")
    public Map<String, List<Integer>> queryLine(){
        List<LineTrend> sevenDay = lineService.findSevenDay();
        System.out.println(sevenDay);
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> confirmList = new ArrayList<>();
        List<Integer> isolationList = new ArrayList<>();
        List<Integer> cureList = new ArrayList<>();
        List<Integer> deadList = new ArrayList<>();
        List<Integer> similarList = new ArrayList<>();
        for (LineTrend day:sevenDay) {
            confirmList.add(day.getConfirm());
            isolationList.add(day.getIsolation());
            cureList.add(day.getCure());
            deadList.add(day.getDead());
            similarList.add(day.getSimilar());
        }
        map.put("confirm",confirmList);
        map.put("isolation",isolationList);
        map.put("cure",cureList);
        map.put("dead",deadList);
        map.put("similar",similarList);
        return map;
    }
}
