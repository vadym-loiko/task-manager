package org.loikov.taskmanager.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getListOfAvailableTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping
    public void addNewTask(@RequestBody Task task) {
        LOG.info("New Task creation requested " + task);
        taskService.addTask(task);
    }

}
