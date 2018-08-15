package com.ubs.opsit.clock.part;

public class Seconds extends Hand {

	@Override
	public void update(final String time) {
		final int secondTime = Integer.parseInt(time);
		if (secondTime % 2 == 0) {
			parts.get(0).on();
		} else {
			parts.get(0).off();
		}
	}

}
