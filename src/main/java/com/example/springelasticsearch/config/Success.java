package com.example.springelasticsearch.config;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Success<T> {

    private String result ;
    private String msg;
    private T data;

    public Success(final String msg,final T data) {
        this.result = "success";
        this.msg = msg;
        this.data = data;
    }
}