package com.codegym.lastproject;

import com.codegym.lastproject.formatter.CategoryFormatter;
import com.codegym.lastproject.service.CategoryService;
import com.codegym.lastproject.service.HomeService;
import com.codegym.lastproject.service.RoleService;
import com.codegym.lastproject.service.UserService;
import com.codegym.lastproject.service.impl.CategoryServiceImpl;
import com.codegym.lastproject.service.impl.HomeServiceImpl;
import com.codegym.lastproject.service.impl.RoleServiceImpl;
import com.codegym.lastproject.service.impl.UserServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LastProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastProjectApplication.class, args);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public RoleService roleService() {
        return new RoleServiceImpl();
    }

    @Bean
    public HomeService homeService() { return new HomeServiceImpl(); }

    @Bean
    public CategoryService categoryService() { return new CategoryServiceImpl();
    }

    @Configuration
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            CategoryService categoryService = appContext.getBean(CategoryService.class);
            Formatter categoryFormatter = new CategoryFormatter(categoryService);
            registry.addFormatter(categoryFormatter);
        }

    }

}
