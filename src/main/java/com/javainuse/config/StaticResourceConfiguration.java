package com.javainuse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
public class StaticResourceConfiguration implements WebMvcConfigurer {

   /* private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };
*/
	
	/*private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/static/"};*/
	 @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/view/");
	        resolver.setSuffix(".jsp");
	        resolver.setViewClass(JstlView.class);
	        registry.viewResolver(resolver);
	    }
	@Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
 }
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}