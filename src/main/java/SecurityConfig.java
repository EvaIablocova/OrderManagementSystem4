//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.web.SecurityFilterChain;
//
////Spring сам делает бины Singleton, так что @Configuration уже Singleton.
//@Configuration
////@EnableWebSecurity
//public class SecurityConfig {
//
//    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
//
//
//    public SecurityConfig() {
//        logger.info("⚡ SecurityConfig Singleton created");
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // Разрешить доступ ко всем запросам
//                )
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .anonymous(anonymous -> anonymous.disable()) // Отключить анонимный доступ
//                .formLogin(form -> form.disable()) // Отключить форму логина
//                .httpBasic(basic -> basic.disable()) // Отключить базовую аутентификацию
//                .csrf(csrf -> csrf.disable()); // Отключить CSRF
//
//
//        return http.build();
//    }
//}
