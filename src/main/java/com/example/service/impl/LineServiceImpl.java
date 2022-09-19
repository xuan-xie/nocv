package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.LineMapper;
import com.example.entity.LineTrend;
import com.example.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl extends ServiceImpl<LineMapper, LineTrend> implements LineService {

    @Autowired
    private LineMapper lineMapper;

    @Override
    public List<LineTrend> findSevenDay() {
        return lineMapper.findSevenDay();
    }
}
