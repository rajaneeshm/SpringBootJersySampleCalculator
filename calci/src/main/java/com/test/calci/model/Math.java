package com.test.calci.model;

import java.io.Serializable;

public class Math implements Serializable {

	private static final long serialVersionUID = 1L;

	Double a;

	Double b;

	Double c;

	Double result;

	String operation;

	public Math(Double a, Double b, Double c, String operation) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.operation = operation;
	}

	public Math(double a, double b, String operation) {
		super();
		this.a = a;
		this.b = b;
		this.operation = operation;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

}
