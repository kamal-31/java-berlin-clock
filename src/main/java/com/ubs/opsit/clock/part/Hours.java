package com.ubs.opsit.clock.part;

public class Hours extends Hand {

	@Override
	public void update(final String time) {
		final int hourTime = Integer.parseInt(time);
		final int quotient = hourTime / 5;
		final int remainder = hourTime % 5;

		for (int i = 0; i < 4; i++) {
			if (i < quotient) {
				parts.get(i).on();
			} else {
				parts.get(i).off();
			}
		}

		for (int i = 4; i < 8; i++) {
			if (i < remainder+4) {
				parts.get(i).on();
			} else {
				parts.get(i).off();
			}
		}
	}

}
