package de.wit.bibinfo.plattenspieler.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/aufg2")
public class JaxrsApplicationConfig extends Application {
}
