package org.loikov.taskmanager.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ConsumerGroupListing;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminClient adminClient;

    public AdminServiceImpl(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    @Override
    public Set<String> getTopics() throws ExecutionException, InterruptedException {
        return adminClient.listTopics().names().get();
    }

    @Override
    public List<String> getConsumerGroups() throws ExecutionException, InterruptedException {
        return adminClient.listConsumerGroups().all().get().stream().map(ConsumerGroupListing::groupId).collect(Collectors.toList());
    }

}
