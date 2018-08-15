package com.ubs.opsit.clock.part;

public class Minutes extends Hand {

	@Override
	public void update(final String time) {
		final int minuteTime = Integer.parseInt(time);
		final int quotient = minuteTime / 5;
		final int remainder = minuteTime % 5;

		for (int i = 0; i < 11; i++) {
			if (i < quotient) {
				parts.get(i).on();
			} else {
				parts.get(i).off();
			}
		}

		for (int i = 11; i < 15; i++) {
			if (i < remainder + 11) {
				parts.get(i).on();
			} else {
				parts.get(i).off();
			}
		}
	}

}
