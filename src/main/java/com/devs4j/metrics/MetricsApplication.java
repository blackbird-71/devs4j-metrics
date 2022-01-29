package com.devs4j.metrics;

import java.util.concurrent.TimeUnit;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		
		MeterRegistry registry= new SimpleMeterRegistry();
		
		Timer timer = registry.timer("execution.time");
		
		timer.record(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
		});
		
		System.out.println(timer.totalTime(TimeUnit.SECONDS));
	}
}
