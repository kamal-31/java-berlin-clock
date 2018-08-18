package com.ubs.opsit.clock.part;

import java.util.List;
import java.util.stream.Collectors;

import com.ubs.opsit.model.Lamp;

public abstract class Hand {
	public abstract void update(final String time);

	protected List<Lamp> parts;

	public List<Lamp> getParts() {
		return parts;
	}

	public abstract void setParts(final List<Lamp> parts);

	public List<Character> display() {
		final List<Character> charList = parts.stream().map((final Lamp lamp) -> {
			return lamp.display();
		}).collect(Collectors.toList());
		return charList;
	}
}
