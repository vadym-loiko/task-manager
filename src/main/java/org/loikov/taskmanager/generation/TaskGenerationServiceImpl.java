package org.loikov.taskmanager.generation;

import org.loikov.taskmanager.task.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGenerationServiceImpl implements TaskGenerationService {

    @Value("${kafka.topic.task.generation}")
    private String taskGenerationTopicName;

    private KafkaTemplate<String, TaskGenerationRequest> kafkaTemplate;
    private List<Task> tasks;

    public TaskGenerationServiceImpl(KafkaTemplate<String, TaskGenerationRequest> kafkaTemplate, List<Task> tasks) {
        this.kafkaTemplate = kafkaTemplate;
        this.tasks = tasks;
    }

    @Override
    public void requestNewTask(TaskGenerationRequest taskGenerationRequest) {
        tasks.stream()
                .filter(task -> taskGenerationRequest.getKey().equals(task.getKey()))
                .findFirst()
                .ifPresentOrElse(task -> {
                    taskGenerationRequest.getProps().putAll(task.getProps());
                    kafkaTemplate.send(taskGenerationTopicName +"-"+ taskGenerationRequest.getKey(), taskGenerationRequest);
                }, () -> {
                    throw new IllegalArgumentException("Unsupported task key");
                });
    }
}
