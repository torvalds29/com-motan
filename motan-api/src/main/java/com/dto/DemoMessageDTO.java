package com.dto;

import java.io.Serializable;

public class DemoMessageDTO implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DemoMessageDTO(String id) {
        this.id = id;
    }

    public DemoMessageDTO() {
    }
}
