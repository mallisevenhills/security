package com.malli.entity;

public enum Role {

	ADMIN, USER, VISITOR;

    public String getValue() {
        return this.toString();
    }
}
