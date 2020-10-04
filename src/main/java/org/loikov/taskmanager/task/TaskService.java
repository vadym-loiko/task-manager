package org.loikov.taskmanager.task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    void addTask(Task task);
}
