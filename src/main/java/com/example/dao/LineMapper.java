package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.LineTrend;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LineMapper extends BaseMapper<LineTrend> {
    @Select("select * from line_trend order by create_time limit 7")
    List<LineTrend> findSevenDay();
}
