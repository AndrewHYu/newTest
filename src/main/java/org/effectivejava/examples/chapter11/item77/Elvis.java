// Broken singleton - has nontransient object reference field! - Page 309
package org.effectivejava.examples.chapter11.item77;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

// Broken singleton - has nontransient object reference field!
public class Elvis implements Serializable {
	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {
		System.out.println("Elvis");
	}

	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("Elvis readResolve");
		return INSTANCE;
	}
}
