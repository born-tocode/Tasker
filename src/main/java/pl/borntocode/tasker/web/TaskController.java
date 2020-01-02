package pl.borntocode.tasker.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.borntocode.tasker.Task;
import pl.borntocode.tasker.data.TaskRepository;

@Slf4j
@Controller
@SessionAttributes("task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/alltasks")
    public Iterable<Task> retrieveAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    public String getOneById(@PathVariable long id) {
        return "task";
    }

}
