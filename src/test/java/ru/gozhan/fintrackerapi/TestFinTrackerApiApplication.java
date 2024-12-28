package ru.gozhan.fintrackerapi;

import org.springframework.boot.SpringApplication;

public class TestFinTrackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(FinTrackerApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
