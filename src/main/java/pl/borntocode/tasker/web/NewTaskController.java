package pl.borntocode.tasker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.borntocode.tasker.Task;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
@Slf4j
public class NewTaskController {

    private TaskRepository taskRepo;

    public NewTaskController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("/newtask")
    public String displayNewTaskForm() {
        return "newtask";
    }


    @PostMapping("/newtask")
    public String processNewTaskForm(@Valid NewTaskForm taskForm, Errors errors, @AuthenticationPrincipal User user) {
        log.info("processNewTaskForm() started");

        if (errors.hasErrors()) {
            log.error(errors.toString());
            return "newtask";
        }

        taskForm.setUser(user);
        log.info("user->form ok");

        Task task = new Task(taskForm);
        log.info("form->Task ok");

        taskRepo.save(task);
        log.info("saved E Task to Repo");

        return "redirect:/tasks/alltasks";
    }
}

