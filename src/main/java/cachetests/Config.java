package cachetests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
@EnableWebMvc
public class Config implements WebMvcConfigurer {

//    @Bean
//    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
//        return new ShallowEtagHeaderFilter();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600)
                .resourceChain(true)
//                .addResolver(new VersionResourceResolver().addFixedVersionStrategy("123", "/**/*.js"));
                .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**/*.js"));
    }
}
