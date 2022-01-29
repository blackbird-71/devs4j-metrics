package com.devs4j.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		
		MeterRegistry registry= new SimpleMeterRegistry();
		
		//Se crea el contador utilizando el MeterRegistry
		Counter counter2 = registry.counter("devs4j.students", "course","Metricas con micrometer");
		
		//Se crea el contador utilizando el builder del Counter
		Counter counter = Counter.builder("devs4j.students")
		.description("Numero de estudiantes de devs4j")
		.tag("course", "Metricas con micrometer")
		.register(registry);
		counter.increment();
		counter.increment(200);
		
		System.out.println(counter.count());
	}
}
