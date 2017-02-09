package com.theironyard.controllers.api;

public class PatchInstruction {
	private String op;
	private String path;
	private String value;
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "{op: " + op + ", path: " + path + ", value: " + value + "}";
	}
}