package com.ubs.opsit.factory.berlin;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.clock.part.Hours;
import com.ubs.opsit.model.Lamp;
import com.ubs.opsit.model.RedLamp;

public class BerlinHourFactory {
	public static Hours build() {
		final List<Lamp> hourLights =  new ArrayList<>();
		for (int i = 1; i <=8; i++) {
			hourLights.add(new RedLamp());
		}
		final Hours hours = new Hours();
		hours.setParts(hourLights);
		return hours;
	}
}
