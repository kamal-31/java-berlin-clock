package com.ubs.opsit.clock.part;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.exception.ClockPartExcecption;
import com.ubs.opsit.exception.TimeException;
import com.ubs.opsit.model.Lamp;

public class Seconds extends Hand {
	private static final Logger LOG = LoggerFactory.getLogger(Seconds.class);

	@Override
	public void setParts(final List<Lamp> parts) {
		if (parts.size() != 1) {
			LOG.error("Incorrect number of lamp for Seconds - {}", parts.size());
			throw new ClockPartExcecption("Incorrect number of lamp for Seconds - " + parts.size());
		}
		this.parts = parts;
	}

	@Override
	public void update(final String time) {
		final int seconds;
		try {
			seconds = Integer.parseInt(time);
		} catch (final NumberFormatException numberFormatException) {
			LOG.error("Incorrect seconds value - {}", time);
			throw new TimeException("Incorrect seconds value - " + time, numberFormatException);
		}
		if (seconds % 2 == 0) {
			parts.get(0).on();
		} else {
			parts.get(0).off();
		}
	}

}
