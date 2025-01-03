package ru.gozhan.fintrackerapi.test;

import org.springframework.boot.SpringApplication;
import ru.gozhan.fintrackerapi.FinTrackerApiApplication;
import ru.gozhan.fintrackerapi.test.e2e.config.TestcontainersConfiguration;

public class TestFinTrackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(FinTrackerApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
