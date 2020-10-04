package org.loikov.taskmanager.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/topic")
    public Set<String> getAllTopics() throws Exception {
        return adminService.getTopics();
    }

    @GetMapping("/groups")
    public List<String> getAllGroups() throws Exception {
        return adminService.getConsumerGroups();
    }
}
