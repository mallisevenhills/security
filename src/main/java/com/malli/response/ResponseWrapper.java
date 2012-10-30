package com.malli.response;

public class ResponseWrapper<E> {
	
	private final E response;
	private final Status status;
	
	public ResponseWrapper(E response, Status status) {
		this.response = response;
		this.status = status;
	}

	public E getResponse() {
		return response;
	}

	public Status getStatus() {
		return status;
	}
	
	public static <T> ResponseWrapper<T> success(T model) {
		return new ResponseWrapper<T>(model, Status.SUCCESS);
	}

}
