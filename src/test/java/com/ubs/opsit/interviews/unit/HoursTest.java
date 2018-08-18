package com.ubs.opsit.interviews.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ubs.opsit.clock.part.Hours;
import com.ubs.opsit.exception.ClockPartExcecption;
import com.ubs.opsit.exception.TimeException;
import com.ubs.opsit.model.Lamp;
import com.ubs.opsit.model.RedLamp;

public class HoursTest {
	final Hours hours = new Hours();

	@Test
	public void updateHoursTest() {
		final List<Lamp> parts = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			final Lamp lampMock = new RedLamp();
			parts.add(lampMock);
		}

		hours.setParts(parts);
		hours.update("10");

		String hourLampState = "";
		for (final Lamp lamp : parts) {
			hourLampState += lamp.display();
		}
		Assert.assertEquals("Update hour method is computing incorrectly", "RROOOOOO", hourLampState);
	}

	@Test(expected = ClockPartExcecption.class)
	public void inCorrectNumberOfLampsTest() {
		final ArrayList<Lamp> lamps = Mockito.mock(ArrayList.class);
		Mockito.when(lamps.size()).thenReturn(5);

		hours.setParts(lamps);
	}

	@Test(expected = TimeException.class)
	public void incorrectHoursTest() {
		hours.update("abc");
	}
}
