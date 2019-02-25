package com.sample.test2;

public enum Employee {
	INSTANCE123;

	private int id;
	private String name;

	private Employee() {
	} // enum constructor must be private

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
