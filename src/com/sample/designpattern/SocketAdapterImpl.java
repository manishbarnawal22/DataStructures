package com.sample.designpattern;

public class SocketAdapterImpl implements SocketAdapter {

	private Socket sock = new Socket();

	@Override
	public Volt get120Volt() {

		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() {

		Volt volt = sock.getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get3Volt() {

		Volt volt = sock.getVolt();
		return convertVolt(volt, 40);
	}

	Volt convertVolt(Volt volt, Integer val) {
		return new Volt(volt.getVolts() / val);
	}
	
}
