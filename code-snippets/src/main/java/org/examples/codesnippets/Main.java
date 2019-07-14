package org.examples.codesnippets;

import java.util.Arrays;

import org.examples.codesnippets.ThreadMxExample.ThreadMxExample;

public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(args));
		new ThreadMxExample().currentThreadExample();
	}
}
