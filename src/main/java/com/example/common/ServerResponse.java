package com.example.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Data
public class ServerResponse<T> implements Serializable {
    private Integer code;

    private String message;

    private T data;

    private ServerResponse(Integer code) {
        this.code = code;
    }

    private ServerResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private ServerResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    // 正确的响应码
    public static <T> ServerResponse<T> createSuccess() {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMessage(String message) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T> ServerResponse<T> createSuccessData(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse<T> createSuccessData(String message, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),message,data);
    }

    // 错误的响应吗
    public static <T> ServerResponse<T> createError() {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createError(String message) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),message);
    }

    public static <T> ServerResponse<T> createError(int code,String message) {
        return new ServerResponse<>(code,message);
    }
}
