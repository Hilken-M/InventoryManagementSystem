package Spring;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){

        SpringApplication.run(Application.class);
        Logger log = Logger.getLogger(Application.class);
    }
}
