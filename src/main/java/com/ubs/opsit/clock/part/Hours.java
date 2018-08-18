package com.ubs.opsit.clock.part;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.exception.ClockPartExcecption;
import com.ubs.opsit.exception.TimeException;
import com.ubs.opsit.model.Lamp;

public class Hours extends Hand {
	private static final Logger LOG = LoggerFactory.getLogger(Hours.class);

	@Override
	public void setParts(final List<Lamp> parts) {
		if (parts.size() != 8) {
			LOG.error("Incorrect number of lamp for Hours - {}", parts.size());
			throw new ClockPartExcecption("Incorrect number of lamp for Hours - " + parts.size());
		}
		this.parts = parts;
	}

	@Override
	public void update(final String time) {
		int hours;
		try {
			hours = Integer.parseInt(time);
		} catch (final NumberFormatException numberFormatException) {
			LOG.error("Incorrect hours value - {}", time);
			throw new TimeException("Incorrect hours value - " + time, numberFormatException);
		}

		final int quotient = hours / 5;
		final int remainder = hours % 5;

		for (int i = 0; i < 4; i++) {
			if (i < quotient) {
				parts.get(i).on();
			} else {
				parts.get(i).off();
			}
		}

		for (int i = 4; i < 8; i++) {
			if (i < remainder + 4) {
				parts.get(i).on();
			} else {
				parts.get(i).off();
			}
		}
	}

}
