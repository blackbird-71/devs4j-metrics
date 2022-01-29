package com.devs4j.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		
		CompositeMeterRegistry compositeMeter = new CompositeMeterRegistry();
		
		Counter counter = compositeMeter.counter("numero.empleados","oficina","Benito Juarez");
		
		MeterRegistry registry= new SimpleMeterRegistry();
		MeterRegistry registry2= new SimpleMeterRegistry();
		
		compositeMeter.add(registry);
		compositeMeter.add(registry2);
		
		counter.increment();
		counter.increment(200);
		
		System.out.printf("Numero de empleados %f", counter.count());
	}
}
