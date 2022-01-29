package com.devs4j.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		
		CompositeMeterRegistry compositeMeter = Metrics.globalRegistry;
		//System.out.println(compositeMeter==null);
		
		Counter counter = compositeMeter.counter("numero.empleados","oficina","Benito Juarez");
		
		MeterRegistry registry= new SimpleMeterRegistry();
		
		compositeMeter.add(registry);
		
		counter.increment();
		counter.increment(200);
		
		System.out.printf("Numero de empleados %f\n", counter.count());
		
		foo();
		
	}

	private static void foo() {
		CompositeMeterRegistry globalregistry = Metrics.globalRegistry;
		Counter counter = globalregistry.counter("numero.empleados","oficina","Benito Juarez");
		counter.increment(150);
		System.out.printf("Numero de empleados %f", counter.count());
	}
}
