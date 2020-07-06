/*

package www.wevvv.smart_control.initcontrol.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()                //对请求进行授权
                .antMatchers("/login")            //针对、login路径进行授权
                .permitAll()                      //可以无条件访问
                .antMatchers("/common/**")
                .permitAll()
                .and().authorizeRequests()         //对请求进行授权
                .anyRequest()                      //任意的请求
                .authenticated()                    //需要登录以后才可以访问


      */
/*  /login GET - the login form   去登录页面
                           /login POST - process the credentials and if valid authenticate the user    提交表单
                           /login?error GET - redirect here for failed authentication attempts         登录失败
                           /login?logout GET - redirect here after successfully logging out            退出登陆
                *

*//*

                //指定登录页的同时会影响到：提交登录表单的地址，退出登录地址，登录失败地址
                .and()
                .formLogin()                        //使用表单进行登录
                .loginPage("/login")
                .loginProcessingUrl("/auth/login")
                //.permitAll()
                //.usernameParameter()             //定制登录账号的请求参数名
                //.passwordParameter()             //定制登录密码的请求参数名
                // .defaultSuccessUrl("/auth/index")     //登录成功后返回的页面
                ;
        security.csrf().disable();

    }




    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        //在内存中完成账号，密码的检查
        builder
                  */
/*.inMemoryAuthentication()
                                .withUser("tom")
                                .password("123123")
                                .roles("ADMIN")
                                .authorities("UPDATE")       //指定当前用户的权限
                                ;*//*


        .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("tom")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("ADMIN")
        ;
    }
}

*/
