package pl.borntocode.tasker.web.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.borntocode.tasker.Task;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;
import pl.borntocode.tasker.web.NewTaskForm;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/alltasks")
    public Iterable<Task> retrieveAllTasks() {
        return taskRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Optional<Task> getTask = taskRepo.findById(id);
        return getTask
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/newtask")
    public String newTaskForm() {
        return "newtask";
    }

    @PostMapping
    public String newTaskForm(NewTaskForm taskForm, Errors errors, SessionStatus status, Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        if (errors.hasErrors()) {
            return "newtask";
        }
        taskRepo.save(taskForm.toTask());

        status.setComplete();

        return "alltasks";
    }

}
