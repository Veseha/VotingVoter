package votingvoter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VotingVoter {
    public static final Logger log = LoggerFactory.getLogger(VotingVoter.class);
    public static void main(String[] args) {
        SpringApplication.run(VotingVoter.class, args);
    }

}
