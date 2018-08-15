package com.ubs.opsit.model;

public class YellowLamp extends Lamp {

	@Override
	public void on() {
		this.state = 'Y';
	}

}
