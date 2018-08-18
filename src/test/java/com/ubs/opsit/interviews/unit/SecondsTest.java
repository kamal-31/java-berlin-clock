package com.ubs.opsit.interviews.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ubs.opsit.clock.part.Seconds;
import com.ubs.opsit.exception.ClockPartExcecption;
import com.ubs.opsit.exception.TimeException;
import com.ubs.opsit.model.Lamp;
import com.ubs.opsit.model.YellowLamp;

public class SecondsTest {
	final Seconds seconds = new Seconds();

	@Test
	public void updateSecondsTest() {
		final List<Lamp> parts = new ArrayList<>();
		parts.add(new YellowLamp());

		seconds.setParts(parts);
		seconds.update("04");

		String secondLampState = "";
		for (final Lamp lamp : parts) {
			secondLampState += lamp.display();
		}
		Assert.assertEquals("Update second method is computing incorrectly", "Y", secondLampState);
	}

	@Test(expected = ClockPartExcecption.class)
	public void inCorrectNumberOfLampsTest() {
		final ArrayList<Lamp> lamps = Mockito.mock(ArrayList.class);
		Mockito.when(lamps.size()).thenReturn(5);

		seconds.setParts(lamps);
	}

	@Test(expected = TimeException.class)
	public void incorrectSecondsTest() {
		seconds.update("abc");
	}
}
