package pl.borntocode.tasker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
                .addAttribute("UserTasks", taskRepository
                .getByUserUsername(user.getUsername()))
                .addAttribute("Username", user.getUsername());

        return "alltasks";
    }

    @GetMapping("/alltasks/edit/{id}")
    public String editTask(@PathVariable @SessionAttribute Long id, Model model) {
        return "edittask";
    }

    @PostMapping("/alltasks/edit/{id}")
    public String saveTask(@PathVariable @SessionAttribute Long id) {
        taskRepository.findById(id);
        return "redirect:/tasks/alltasks";
    }

    @GetMapping("/alltasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks/alltasks";
    }
}
