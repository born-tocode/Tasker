package pl.borntocode.tasker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final TaskRepository taskRepository;

    public Controller(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/")
    public String indexPage() {
        return "";
    }

    @GetMapping(value = "/alltasks", produces = "application/json")
    public List<Task> retrieveAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping(value = "/task/{id}", produces = "application/json")
    public Optional<Task> getOneById(@PathVariable long id) {
        return taskRepository.findById(id);
    }

}
