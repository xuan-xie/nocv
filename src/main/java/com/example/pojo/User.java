package com.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String role;

    private String name;

    private String password;

    private String idCard;

    private String phone;

    private String gender;

    private Date entryTime;

    private String status;

}
