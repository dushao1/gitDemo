package com.avicsafety.webapp.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	private static final String RESOURCE_ID = "my_rest_api";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
		
	}
	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		 .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
		 .antMatchers("/api/login").permitAll()
		 .antMatchers("/api/public/**").permitAll()
//		 .antMatchers("/**").authenticated().and()
		 .antMatchers("/**").permitAll().and()
//		 .and().csrf().disable();
         .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
		 
		 //http.addFilterBefore(new MyCorsFilter(), ChannelProcessingFilter.class);
	}
	
}
