package de.hsansbach.ecommerce.configuration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.csrf()
				.disable() // CSRF protection is not supported by Camunda Webapps
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.and()
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/app/**", "/lib/**", "/api/**").permitAll() // Required by Camunda Webapps
				.antMatchers("/img/**", "/css/**", "/js/**", "/fonts/**").permitAll() // Static resources
				.anyRequest().authenticated();
		// @formatter:on
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("ADMIN", "USER")
				.and()
				.withUser("kermit").password("kermit").roles("USER")
				.and()
				.withUser("gonzo").password("gonzo").roles("USER");
		// @formatter:on
	}

}
