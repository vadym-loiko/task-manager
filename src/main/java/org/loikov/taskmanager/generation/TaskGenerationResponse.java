package org.loikov.taskmanager.generation;

public class TaskGenerationResponse {

    private String key;

    public TaskGenerationResponse() {
    }

    public TaskGenerationResponse(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
