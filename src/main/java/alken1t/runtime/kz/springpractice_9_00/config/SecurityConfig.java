package alken1t.runtime.kz.springpractice_9_00.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
     //   httpSecurity.csrf().disable();
        httpSecurity.authorizeHttpRequests(authorization -> {
            authorization.requestMatchers("/security_controller/first_resource")
                    .authenticated();
            authorization.requestMatchers("/security_controller/current_user")
                    .authenticated();
  //          authorization.requestMatchers("/product/{id}").authenticated();
            authorization.requestMatchers("/cart").authenticated();
            authorization.requestMatchers("/orders").authenticated();
            authorization.requestMatchers("/user").authenticated();
            authorization.requestMatchers("/product/addCart").authenticated();
            authorization.requestMatchers("/shop").hasRole("moderator");
            authorization.requestMatchers("/shop/{id}").hasRole("moderator");
            authorization.requestMatchers("/shop/count").hasRole("moderator");
            authorization.requestMatchers("/admin/{id}").hasRole("admin");
            authorization.requestMatchers("/admin/comment").hasRole("admin");
            authorization.requestMatchers("/admin").hasRole("admin");
            authorization.requestMatchers("/admin/order").hasRole("admin");
//            authorization.requestMatchers("/security_controller/second_resource").permitAll();
            authorization.requestMatchers("/security_controller/third_resource").hasRole("admin");
            authorization.anyRequest().permitAll();
        });
      //  httpSecurity.formLogin();
        httpSecurity.formLogin().loginPage("/login").loginProcessingUrl("/process_login").defaultSuccessUrl("/product?page=1",true)
                .failureUrl("/login?error").and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        return httpSecurity.build();
    }
}