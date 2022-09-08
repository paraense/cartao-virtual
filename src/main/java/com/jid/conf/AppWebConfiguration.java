package com.jid.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jid")
@EnableJpaRepositories(basePackages = "com.jid.daos")
public class AppWebConfiguration extends WebMvcConfigurerAdapter
{

   @Override
   public void addResourceHandlers(final ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/styles/**")
              .addResourceLocations("/WEB-INF/views/assets/").setCachePeriod(120000);
   }

   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
   {
      configurer.enable();
   }

   @Bean
   public InternalResourceViewResolver internalResourceViewResolver()
   {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
}
