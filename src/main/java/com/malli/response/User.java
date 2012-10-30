package com.malli.response;

import java.io.Serializable;

public class User implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5008805551077674618L;
	String name;
	Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
