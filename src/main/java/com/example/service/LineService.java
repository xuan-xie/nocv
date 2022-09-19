package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.LineTrend;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface LineService extends IService<LineTrend> {

    List<LineTrend> findSevenDay();
}
