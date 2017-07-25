package login.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@PropertySource(value = { "classpath:application.properties" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${user.name}")
    private String userName;
    @Value("${user.password}")
    private String userPassword;
    @Value("${admin.name}")
    private String adminName;
    @Value("${admin.password}")
    private String adminPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/", "/home").permitAll()
                        .antMatchers("/greeting").permitAll()
                        .antMatchers("/admin*").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        .and()
                        .formLogin().loginPage("/login").permitAll()
                        .and()
                        .logout().permitAll()
                        .and()
                        .csrf().disable()
                        .headers().frameOptions().disable();
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            auth.inMemoryAuthentication()
//                    .withUser(userName).password(userPassword).authorities("ROLE_USER")
//                    .and()
//                    .withUser(adminName).password(adminPassword).authorities("ROLE_USER","ROLE_ADMIN");
//    }

}