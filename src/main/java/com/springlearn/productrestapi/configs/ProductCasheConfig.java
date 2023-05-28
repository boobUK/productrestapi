package com.springlearn.productrestapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class ProductCasheConfig {

	@Bean
	Config cashConfig() {
		return new Config().setInstanceName("product-config")
				.addMapConfig(new MapConfig().setName("product-cashe").setTimeToLiveSeconds(3000));
	}

}
