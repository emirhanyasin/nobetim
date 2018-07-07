package nobetim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class NöbetimApplication extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/nobetim/");
		resolver.setSuffix(".html");
		return resolver;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry){
		registry.addResourceHandler("/nobetim/**").addResourceLocations("classpath:/webapp/views/");
		registry.addResourceHandler("/angular/**").addResourceLocations("classpath:/angular/");
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
		registry.addResourceHandler("/js/controllers/**").addResourceLocations("classpath:/js/controllers/");
		registry.addResourceHandler("/js/services/**").addResourceLocations("classpath:/js/services/");

	}

	public static void main(String[] args) {
		SpringApplication.run(NöbetimApplication.class, args);
	}
}
