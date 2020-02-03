package pl.borntocode.tasker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.borntocode.tasker.Task;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;

import javax.validation.Valid;

@Slf4j
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

    @GetMapping("/alltasks/edit/**")
    public String editTask() {
        return "edittask";
    }

    @PostMapping("/alltasks/edit/{id}")
    public String processEditTask(@PathVariable @SessionAttribute Long id) {
        taskRepository.findById(id);
        return "redirect:/tasks/alltasks";
    }


    @GetMapping("/newtask")
    public String displayNewTaskForm() {
        return "newtask";
    }

    @PostMapping("/newtask")
    public String processNewTask(@Valid NewTaskForm taskForm, Errors errors, @AuthenticationPrincipal User user) {
        log.info("processNewTaskForm() started");

        if (errors.hasErrors()) {
            log.error(errors.toString());
            return "newtask";
        }

        taskForm.setUser(user);
        log.info("user->form ok");

        Task task = new Task(taskForm);
        log.info("form->Task ok");

        taskRepository.save(task);
        log.info("saved E Task to Repo");

        return "redirect:/tasks/alltasks";
    }

    @GetMapping("/alltasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks/alltasks";
    }
}
