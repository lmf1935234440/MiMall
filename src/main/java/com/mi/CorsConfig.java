package com.mi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	private CorsConfiguration config;
	private UrlBasedCorsConfigurationSource source;

	private CorsConfiguration build() { // 构建配置对象
		config = new CorsConfiguration();
		config.addAllowedOrigin("*"); // 允许来自所有域的请求进入
		config.addAllowedHeader("*"); // 允许请求携带所有头信息
		config.addAllowedMethod("*"); // 允许所有请求方法进入
		config.addExposedHeader("token"); // 允许向客户端响应token头信息
		return config;
	}

	@Bean
	public CorsFilter corsFilter() { // 配置跨域过滤器
		source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", build());
		return new CorsFilter(source);
	}
}
