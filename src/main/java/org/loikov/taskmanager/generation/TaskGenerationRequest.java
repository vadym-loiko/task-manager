package org.loikov.taskmanager.generation;

import java.util.HashMap;
import java.util.Map;

public class TaskGenerationRequest {

    private String key;
    private Map<String, String> props = new HashMap<>();

    public TaskGenerationRequest() {
    }

    public TaskGenerationRequest(String key, String requesterName) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getProps() {
        return props;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    public TaskGenerationRequest addProperty(String key, String value) {
        this.props.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "TaskGenerationRequest{" +
                "key='" + key + '\'' +
                ", props=" + props +
                '}';
    }
}
