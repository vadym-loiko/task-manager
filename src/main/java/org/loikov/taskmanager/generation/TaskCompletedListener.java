package org.loikov.taskmanager.generation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TaskCompletedListener {

    private final static Logger LOG = LoggerFactory.getLogger(TaskCompletedListener.class);

    @KafkaListener(topics = "task-generation-completed", containerFactory = "kafkaListenerContainerFactory")
    public void listen(TaskGenerationResponse message) {
        LOG.info("Task Generation Completed " + message);
    }

}
