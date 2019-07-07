package com.jbonu;

import com.jbonu.servlet.StrutsActionServlet;
import org.apache.struts.action.ActionServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }

    @Bean
    public ServletRegistrationBean<ActionServlet> servletServletRegistrationBea(@Value("$[idEnv]") final String idEnv){
        final StrutsActionServlet strutsActionServlet = new StrutsActionServlet();
        strutsActionServlet.addServletMapping("*.do");

        final ServletRegistrationBean<ActionServlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(strutsActionServlet);

        servletServletRegistrationBean.addUrlMappings("*.do");
        servletServletRegistrationBean.setLoadOnStartup(2);
        servletServletRegistrationBean.addInitParameter("config","/WEB-INF/struts-config.xml");
        servletServletRegistrationBean.addInitParameter("debug","2");
        servletServletRegistrationBean.addInitParameter("detail","2");
        servletServletRegistrationBean.addInitParameter("mapping","org.apache.struts.action.ActionMapping");
        servletServletRegistrationBean.addInitParameter("nocache","true");
        servletServletRegistrationBean.addInitParameter("appli","demo");

        return  servletServletRegistrationBean;

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();//default prefix=/WEB-INF/", suffix=".jsp"
    }

    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/");
        vr.setSuffix(".jsp");
        return vr;
    }
}
