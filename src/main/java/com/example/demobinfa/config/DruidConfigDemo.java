package com.example.demobinfa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import javax.sql.DataSource;

/**
 * Druid 配置类
 *
 * http://localhost:8080/gby/druid/datasource.html
 *
 * 参考网页地址
 * https://blog.csdn.net/bing_gege/article/details/82390629
 *
 * @author gby
 * 2018-09-04
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Configuration
public class DruidConfigDemo {

    /**
     * 配置监控服务器
     *
     * @return 返回监控注册的servlet对象
     */
    @Bean
    public ServletRegistrationBean statViewServletDemo() {
        ServletRegistrationBean srb = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        ServletRegistrationBean srb = new ServletRegistrationBean(new StatViewServlet(), "/gby/druid/*");
        // 添加IP白名单
        srb.addInitParameter("allow", "127.0.0.1");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        srb.addInitParameter("deny", "192.168.25.123");
        // 添加控制台管理用户
        srb.addInitParameter("loginUsername", "user");
        srb.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }

    /**
     * 配置服务过滤器
     *
     * @return 返回过滤器配置对象
     */
    @Bean
    public FilterRegistrationBean statFilterDemo() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        frb.addUrlPatterns("/*");
        // 忽略过滤格式
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
        return frb;
    }


    @Bean
    // 将所有前缀为spring.datasource下的配置项都加载DataSource中
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

//    @Bean
//    public ServletRegistrationBean<Servlet> druidServlet() {
//        // 进行 druid 监控的配置处理
//        ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/**");
//        // 白名单
//        srb.addInitParameter("allow", "127.0.0.1");
//        // 黑名单
//        srb.addInitParameter("deny", "192.168.31.253");
//        // 用户名
//        srb.addInitParameter("loginUsername", "root");
//        // 密码
//        srb.addInitParameter("loginPassword", "root");
//        // 是否可以重置数据源
//        srb.addInitParameter("resetEnable", "false");
//        return srb;
//    }

//    @Bean
//    public FilterRegistrationBean<Filter> filterRegistrationBean() {
//        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
//        frb.setFilter(new WebStatFilter());
//        // 所有请求进行监控处理
//        frb.addUrlPatterns("/*");
//        // 排除名单
//        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
//        return frb;
//    }



}