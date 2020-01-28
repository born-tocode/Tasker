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
public class UserTasksController {

    private TaskRepository taskRepository;

    @Autowired
    public UserTasksController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/alltasks")
    public String getAllTasks(Model model, @AuthenticationPrincipal User user) {

        model
                .addAttribute("TasksRows", taskRepository
                .getByUserUsername(user.getUsername()));

        return "alltasks";
    }
}
