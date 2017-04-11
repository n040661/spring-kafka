package development.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {

    public static Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> template;

    @Override
    public void run(String... args) throws Exception {
        int number = 0;
        while (true) {
            Thread.sleep(1000 * 2);
            template.send("myTopic", "message-" + number++);
        }
    }

}
