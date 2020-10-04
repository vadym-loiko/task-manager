package org.loikov.taskmanager.admin;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface AdminService {

    Set<String> getTopics() throws ExecutionException, InterruptedException;

    List<String> getConsumerGroups() throws ExecutionException, InterruptedException;
}
