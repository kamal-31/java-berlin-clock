package com.ubs.opsit.factory.berlin;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.clock.part.Minutes;
import com.ubs.opsit.model.Lamp;
import com.ubs.opsit.model.RedLamp;
import com.ubs.opsit.model.YellowLamp;

public class BerlinMinuteFactory {
	public static Minutes build() {
		final List<Lamp> minuteLights = new ArrayList<>();

		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());
		minuteLights.add(new RedLamp());

		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());
		minuteLights.add(new RedLamp());

		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());
		minuteLights.add(new RedLamp());

		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());

		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());
		minuteLights.add(new YellowLamp());

		final Minutes minutes = new Minutes();
		minutes.setParts(minuteLights);
		return minutes;
	}
}
