package org.loikov.taskmanager.generation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task/generation")
public class TaskGenerationController {

    private static Logger LOG = LoggerFactory.getLogger(TaskGenerationController.class);

    private TaskGenerationService taskGenerationService;

    public TaskGenerationController(TaskGenerationService taskGenerationService) {
        this.taskGenerationService = taskGenerationService;
    }

    @PostMapping
    public void enqueueTaskGeneration(@RequestBody TaskGenerationRequest taskGenerationRequest) {
        LOG.info("New task generation was requested. " + taskGenerationRequest);
        taskGenerationService.requestNewTask(taskGenerationRequest);
    }

}
