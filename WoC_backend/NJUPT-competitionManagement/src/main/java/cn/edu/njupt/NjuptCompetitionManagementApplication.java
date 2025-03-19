package cn.edu.njupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class NjuptCompetitionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(NjuptCompetitionManagementApplication.class, args);
    }

}
