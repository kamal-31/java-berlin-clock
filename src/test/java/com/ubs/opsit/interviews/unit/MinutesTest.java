package com.ubs.opsit.interviews.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ubs.opsit.clock.part.Minutes;
import com.ubs.opsit.exception.ClockPartExcecption;
import com.ubs.opsit.exception.TimeException;
import com.ubs.opsit.model.Lamp;
import com.ubs.opsit.model.RedLamp;
import com.ubs.opsit.model.YellowLamp;

public class MinutesTest {
	final Minutes minutes = new Minutes();

	@Test
	public void updateMinutesTest() {
		final List<Lamp> parts = new ArrayList<>();
		parts.add(new YellowLamp());
		parts.add(new YellowLamp());
		parts.add(new RedLamp());

		parts.add(new YellowLamp());
		parts.add(new YellowLamp());
		parts.add(new RedLamp());

		parts.add(new YellowLamp());
		parts.add(new YellowLamp());
		parts.add(new RedLamp());

		parts.add(new YellowLamp());
		parts.add(new YellowLamp());

		parts.add(new YellowLamp());
		parts.add(new YellowLamp());
		parts.add(new YellowLamp());
		parts.add(new YellowLamp());

		minutes.setParts(parts);
		minutes.update("22");

		String minuteLampState = "";
		for (final Lamp lamp : parts) {
			minuteLampState += lamp.display();
		}
		Assert.assertEquals("Update minute method is computing incorrectly", "YYRYOOOOOOOYYOO", minuteLampState);
	}

	@Test(expected = ClockPartExcecption.class)
	public void inCorrectNumberOfLampsTest() {
		final ArrayList<Lamp> lamps = Mockito.mock(ArrayList.class);
		Mockito.when(lamps.size()).thenReturn(5);

		minutes.setParts(lamps);
	}

	@Test(expected = TimeException.class)
	public void incorrectMinutesTest() {
		minutes.update("abc");
	}
}
