package com.ubs.opsit.clock;

import java.util.List;

import com.ubs.opsit.clock.part.Hand;
import com.ubs.opsit.factory.berlin.BerlinHourFactory;
import com.ubs.opsit.factory.berlin.BerlinMinuteFactory;
import com.ubs.opsit.factory.berlin.BerlinSecondFactory;
import com.ubs.opsit.interviews.TimeConverter;

public class BerlinClock implements TimeConverter {
	Hand hours;
	Hand minutes;
	Hand seconds;

	public BerlinClock() {
		seconds = BerlinSecondFactory.build();
		hours = BerlinHourFactory.build();
		minutes = BerlinMinuteFactory.build();
	}

	@Override
	public String convertTime(final String aTime) {
		changeDisplay(aTime);
		final String timeRepresentation = formatTime();
		return timeRepresentation;
	}

	private void changeDisplay(final String aTime) {
		if (aTime == null || aTime.isEmpty()) {
			throw new RuntimeException("No time provided");
		}

		final String[] splitTime = aTime.split(":");

		if (splitTime.length != 3) {
			throw new RuntimeException("Incorrect Time Format");
		}

		hours.update(splitTime[0]);
		minutes.update(splitTime[1]);
		seconds.update(splitTime[2]);


	}

	private String formatTime() {
		final String second = displaySecond();
		final String hours = displayHours();
		final String minutes = displayMinutes();
		return second + "\r\n" + hours + "\r\n" + minutes;
	}

	private String displaySecond() {
		final List<Character> secondDisplay = seconds.display();
		return secondDisplay.get(0).toString();
	}

	private String displayHours() {
		final List<Character> hoursDisplay = hours.display();
		String hours = "";
		for (int i = 0; i < hoursDisplay.size(); i++) {
			hours += hoursDisplay.get(i).toString();
			if (i == 3) {
				hours += "\r\n";
			}
		}
		return hours;
	}

	private String displayMinutes() {
		final List<Character> minutesDisplay = minutes.display();
		String hours = "";
		for (int i = 0; i < minutesDisplay.size(); i++) {
			hours += minutesDisplay.get(i).toString();
			if (i == 10) {
				hours += "\r\n";
			}
		}
		return hours;
	}
}
