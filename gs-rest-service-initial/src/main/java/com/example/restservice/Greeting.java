package com.example.restservice;

public class Greeting {
	private final long id;
	private final String content;
	
	public Greeting(long i, String c) {
		this.id=i;
		this.content=c;
	}
	
	public long getId() {
		return this.id;
	}
	public String getContent() {
		return this.content;
	}
}
