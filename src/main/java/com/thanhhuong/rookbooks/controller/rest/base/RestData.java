package com.thanhhuong.rookbooks.controller.rest.base;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RestData<T> {
    private RestStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)//@JsonInclude : This property will include Json if it different null
    private String userMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String devMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public RestData(T data) {
        this.status = RestStatus.SUCCESS;
        this.data = data;
    }

    public RestData(RestStatus status, String userMessage, T data) {
        this.status = status;
        this.userMessage = userMessage;
        this.data = data;
    }

    public RestData() {
    }

    public RestData(RestStatus status, String userMessage, String devMessage, T data) {
        this.status = status;
        this.userMessage = userMessage;
        this.devMessage = devMessage;
        this.data = data;
    }

    public static RestData<?> error(String userMessage, String devMessage) {
        return new RestData<>(RestStatus.ERROR, userMessage, devMessage, null);
    }

    public static RestData<?> error(String userMessage) {
        return new RestData<>(RestStatus.ERROR, userMessage, null);
    }

    public RestStatus getStatus() {
        return status;
    }

    public void setStatus(RestStatus status) {
        this.status = status;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
