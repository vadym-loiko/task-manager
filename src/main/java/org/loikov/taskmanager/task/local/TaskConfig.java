package org.loikov.taskmanager.task.local;

import org.loikov.taskmanager.task.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("local")
public class TaskConfig {

    @Bean
    public List<Task> tasks() {
        Task btc = new Task("dummy-report", "Dummy Daily Report");
        btc.addProperty("client-name", "Test");
        btc.addProperty("category", "daily");

        return new ArrayList<>(List.of(btc));
    }

}
