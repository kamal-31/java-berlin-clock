package com.ubs.opsit.factory.berlin;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.clock.part.Seconds;
import com.ubs.opsit.model.Lamp;
import com.ubs.opsit.model.YellowLamp;

public class BerlinSecondFactory {

	public static Seconds build() {
		final List<Lamp> secondLights =  new ArrayList<>();
		secondLights.add(new YellowLamp());
		final Seconds seconds = new Seconds();
		seconds.setParts(secondLights);
		return seconds;
	}
}
