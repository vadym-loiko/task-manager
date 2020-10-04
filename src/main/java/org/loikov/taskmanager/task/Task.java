package org.loikov.taskmanager.task;

import java.util.HashMap;
import java.util.Map;

public class Task {

    private String taskName;
    private String key;
    private Map<String, String> props;

    public Task() {
    }

    public Task(String key, String taskName) {
        this.key = key;
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getProps() {
        if (props == null) {
            this.props = new HashMap<>();
        }
        return props;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    public Task addProperty(String key, String value) {
        getProps().put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", key='" + key + '\'' +
                ", props=" + props +
                '}';
    }
}
