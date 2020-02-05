package pl.borntocode.tasker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;

@Slf4j
@Controller
@RequestMapping("/tasks")
public class UserTaskController {

    private TaskRepository taskRepository;

    @Autowired
    public UserTaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/alltasks")
    public String getAllTasks(Model model, @AuthenticationPrincipal User user) {

        model
                .addAttribute("UserTasks", taskRepository.getTasksByUserUsername(user.getUsername()))
                .addAttribute("Username", user.getUsername());

        return "alltasks";
    }

    @GetMapping("/newtask")
    public String displayNewTaskForm() {
        return "newtask";
    }

    @PostMapping("/newtask")
    public String processNewTask(TaskForm taskForm, Errors errors, @AuthenticationPrincipal User user) {
        log.info("processNewTaskForm() started");

        if (errors.hasErrors()) {
            log.error(errors.toString());
            return "newtask";
        }
        taskRepository.save(taskForm.toTask(user));
        log.info("saved E Task to Repo");

        return "redirect:/tasks/alltasks";
    }

    @GetMapping("/alltasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks/alltasks";
    }
}
