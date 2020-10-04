package org.loikov.taskmanager.task.local;

import org.loikov.taskmanager.task.Task;
import org.loikov.taskmanager.task.TaskService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Profile("local")
public class TaskServiceLocalImpl implements TaskService {

    private final List<Task> tasks;

    public TaskServiceLocalImpl(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        if (!StringUtils.isEmpty(task.getKey()) && !StringUtils.isEmpty(task.getTaskName())) {
            tasks.add(task);
        } else {
            throw new IllegalArgumentException("Name and/or key is missing");
        }
    }

}
