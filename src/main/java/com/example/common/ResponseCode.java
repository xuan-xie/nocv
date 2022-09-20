package com.example.common;

import lombok.Getter;

@Getter
public enum ResponseCode {
    /*
        1.枚举的构造函数只能是私有的
        2.每一个枚举值都是枚举对象的实例并且访问修饰符为public static final
        3.枚举对象不能继承其他的类，因为枚举已经默认继承了java.lang.Enum类
     */
    SUCCESS(20000,"SUCCESS"),
    ERROR(50000,"SUCCESS");
    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
