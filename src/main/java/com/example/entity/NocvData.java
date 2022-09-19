package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("nocv_data")
public class NocvData {
    private Integer id;
    private String name;
    private Integer value;
}
