package com.devs4j.metrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.logging.Log4j2Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		
		MeterRegistry registry= new SimpleMeterRegistry();
		
		List<String> list = new ArrayList<>(4);

		Gauge gauge = Gauge.builder("list.size", list, List::size).register(registry);

		System.out.println(gauge.value());

		list.addAll( Arrays.asList("Devs4j","Raidentrance","HolaMundo"));

		System.out.println(gauge.value());
	}
}
