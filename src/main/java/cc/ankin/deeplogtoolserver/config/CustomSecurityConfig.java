package cc.ankin.deeplogtoolserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 开启表单登录
                .and().authorizeRequests() // 开启请求认证
                //.antMatchers("/backend/*").permitAll()
                .anyRequest().authenticated()
                .and().logout(); // 任何请求都开启认证

    }
}