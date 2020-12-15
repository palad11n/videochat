package ru.csu.videochat.model.entries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageCategories {
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "message")
    private String message;
    @JsonProperty(value = "error")
    private String error;
    @JsonProperty(value = "themes")
    private Category[] categories;

    public MessageCategories(String status, String message, String error, Category[] categories) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }
}
