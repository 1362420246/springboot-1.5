package com.qbk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * boot1.5  WebMvcConfigurerAdapter配置类相当于mvc的配置文件，可配置拦截器、试图解析器。。。
 * WebMvcConfigurerAdapter实现类WebMvcConfigurer接口
 *
 * boot2.0 自定义实现WebMvcConfigurer接口
 */
@Slf4j
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    /**
     * 重写 静态资源映射方法
     *  addResourceLocations指文件放置的目录
     *  addResourceHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 视图跳转控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //重定向
//        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
        registry.addViewController("/").setViewName("redirect:/doc.html");
        //@Order(Ordered.HIGHEST_PRECEDENCE)代表这个过滤器在众多过滤器中级别最高，也就是过滤的时候最先执行
        //而@Order(Ordered.LOWEST_PRECEDENCE)恰恰相反，表示级别最低，最后执行过滤操作。
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
