package lk.ijse.rj.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("lk.ijse.rj")
@Import(HibernateConfig.class)
public class AppConfig {
}
