package io.jobintree.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class JobInTreeApplication /*extends SpringBootServletInitializer*/ {
	
	/*@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(JobInTreeApplication.class);
	  }
*/
	public static void main(String[] args) {
		SpringApplication.run(JobInTreeApplication.class, args);
	}
}
