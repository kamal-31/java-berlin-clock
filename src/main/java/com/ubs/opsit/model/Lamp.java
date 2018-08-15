package com.ubs.opsit.model;

public abstract class Lamp {
	protected char state = 'O';

	public void off() {
		state = 'O';
	}

	public abstract void on();

	public char display() {
		return this.state;
	}
}
