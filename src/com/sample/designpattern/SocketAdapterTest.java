package com.sample.designpattern;

public class SocketAdapterTest {

	public static void main(String[] args) {
		SocketAdapter socketAdapter = new SocketAdapterImpl();
		System.out.println(getVolts(socketAdapter, 3).getVolts());
		System.out.println(getVolts(socketAdapter, 12).getVolts());
		System.out.println(getVolts(socketAdapter, 120).getVolts());
		System.out.println(getVolts(socketAdapter, 34).getVolts());
	}
	
	public static Volt getVolts(SocketAdapter socketAdapter, int i)
	{
		switch(i)
		{
			case 3: return socketAdapter.get3Volt();
			case 12: return socketAdapter.get12Volt();
			case 120: return socketAdapter.get120Volt();
			default:  return socketAdapter.get120Volt();
		}
	}
}
