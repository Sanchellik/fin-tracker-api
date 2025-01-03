package ru.gozhan.fintrackerapi.test.e2e;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ru.gozhan.fintrackerapi.test.e2e.config.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class FinTrackerApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
