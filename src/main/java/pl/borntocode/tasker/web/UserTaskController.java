package pl.borntocode.tasker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/tasks")
public class UserTaskController {

    private TaskRepository taskRepository;

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

    @GetMapping("/edit/{id}")
    public ModelAndView displayTaskForm(@PathVariable Long id, ModelAndView modelAndView) {
        var task = taskRepository.findById(id).get();

        modelAndView.addObject("Id", id)
                    .addObject("Task", task)
                    .setViewName("edittask");

        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateTask(@Valid TaskForm taskForm, Errors errors) {
        if (errors.hasErrors()) {
            log.error(errors.toString());
        }
        taskRepository.getTaskByIdAndUpdate(taskForm.getTask(),taskForm.getPriority(),taskForm.getFromDate(),taskForm.getDueDate(),
                                             taskForm.getId());
        return "redirect:/tasks/alltasks";
    }

    @GetMapping("/alltasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks/alltasks";
    }
}
