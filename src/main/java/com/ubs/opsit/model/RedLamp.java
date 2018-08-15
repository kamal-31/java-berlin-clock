package com.ubs.opsit.model;

public class RedLamp extends Lamp {

	@Override
	public void on() {
		this.state = 'R';
	}
}
