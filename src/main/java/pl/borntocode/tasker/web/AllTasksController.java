package pl.borntocode.tasker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;

@Controller
@RequestMapping("/tasks")
public class AllTasksController {

    private TaskRepository taskRepository;

    @Autowired
    public AllTasksController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/alltasks")
    public String getAllTasks(Model model, @AuthenticationPrincipal User user) {

        var result = taskRepository.readTaskOrderByUserUsername(user.getUsername());

        model.addAttribute("TasksRows", result).asMap();

        return "alltasks";
    }
}
