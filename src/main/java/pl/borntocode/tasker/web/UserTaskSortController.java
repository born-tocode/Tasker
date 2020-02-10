package pl.borntocode.tasker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.borntocode.tasker.User;
import pl.borntocode.tasker.data.TaskRepository;

@Controller
@RequestMapping("/tasks/alltasks/sort")
public class UserTaskSortController {

    private TaskRepository taskRepository;

    @Autowired
    public UserTaskSortController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/byduedateasc")
    public ModelAndView getAllTasksByDueDateAsc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByDueDateAsc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/byduedatedesc")
    public ModelAndView getAllTasksByDueDateDesc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByDueDateDesc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/byaddtimeasc")
    public ModelAndView getAllTasksByAddTimeAsc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByAddTimeAsc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/byaddtimedesc")
    public ModelAndView getAllTasksByAddTimeDesc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByAddTimeDesc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/byfromdateasc")
    public ModelAndView getAllTasksByFromDateAsc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByFromDateAsc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/byfromdatedesc")
    public ModelAndView getAllTasksByFromDateDesc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByFromDateDesc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/bypriorityasc")
    public ModelAndView getAllTasksByPriorityAsc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByPriorityAsc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }

    @GetMapping("/byprioritydesc")
    public ModelAndView getAllTasksByPriorityDesc(ModelAndView modelAndView, @AuthenticationPrincipal User user) {

        modelAndView
                .addObject("UserTasks", taskRepository.getTasksByUserUsernameOrderByPriorityDesc(user.getUsername()))
                .addObject("Username", user.getUsername())
                .setViewName("alltasks");

        return modelAndView;
    }
}
