package pl.borntocode.tasker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/alltasks")
    public List<Task> retrieveAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    public String getOneById(@PathVariable long id) {
        return "task";
    }

}
