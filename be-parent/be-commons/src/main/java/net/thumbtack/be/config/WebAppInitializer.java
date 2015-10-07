package net.thumbtack.be.config;

import net.thumbtack.be.util.PropertiesLoader;
import net.thumbtack.be.util.ResourceProperties;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.util.Properties;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final PropertiesLoader propertiesLoader = new PropertiesLoader();

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new OpenEntityManagerInViewFilter()};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext context = super.createRootApplicationContext();
        Properties properties = propertiesLoader.load(ResourceProperties.SPRING_PROPERTIES_FILE);
        ((ConfigurableEnvironment) context.getEnvironment()).setActiveProfiles(
                properties.getProperty("spring.profiles.active"));
        return context;
    }
}
