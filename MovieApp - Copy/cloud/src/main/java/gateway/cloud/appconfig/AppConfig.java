package gateway.cloud.appconfig;

import gateway.cloud.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@CrossOrigin(origins = "*")
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes().route(p->p.path("/samar-api/**").uri("http://localhost:9093/"))
                .route(p->p.path("/tmdb/**").uri("http://localhost:6161/"))
                .route(p->p.path("/api/v2/**").uri("http://localhost:8880/")).build();

    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/v2/fav/*");
        return filterRegistrationBean;

    }

}
