package com.kvn.axonpoc.config;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.serialization.Serializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.axoniq.axondb.client.AxonDBConfiguration;
import io.axoniq.axondb.client.axon.AxonDBEventStore;

@Configuration
public class AxonBeanConfigurations {

	@Bean(name = "eventBus")
	public EventStore eventStore(AxonDBConfiguration axonDBConfiguration, Serializer serializer) {
		
		return new AxonDBEventStore(axonDBConfiguration, serializer);
	}

	@Bean
	public AxonDBConfiguration axonDBConfiguration() {
		return new AxonDBConfiguration();
	}
}
