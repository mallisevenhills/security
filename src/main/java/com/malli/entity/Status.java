package com.malli.entity;

public enum Status {

ACTIVE, PENDING, DEAD;
    
    public String getValue() {
        return this.toString();
    }
}
