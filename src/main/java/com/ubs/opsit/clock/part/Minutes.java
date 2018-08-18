package com.ubs.opsit.clock.part;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.exception.ClockPartExcecption;
import com.ubs.opsit.exception.TimeException;
import com.ubs.opsit.model.Lamp;

public class Minutes extends Hand {
	private static final Logger LOG = LoggerFactory.getLogger(Minutes.class);

	@Override
	public void setParts(final List<Lamp> parts) {
		if (parts.size() != 15) {
			LOG.error("Incorrect number of lamp for Minutes - {}", parts.size());
			throw new ClockPartExcecption("Incorrect number of lamp for Minutes - " + parts.size());
		}
		this.parts = parts;
	}

	@Override
	public void update(final String time) {
		int minutes;
		try {
			minutes = Integer.parseInt(time);
		} catch (final NumberFormatException numberFormatException) {
			LOG.error("Incorrect seconds value - {}", time);
			throw new TimeException("Incorrect seconds value - " + time, numberFormatException);
		}
		final int quotient = minutes / 5;
		final int remainder = minutes % 5;

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
