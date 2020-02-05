package pl.borntocode.tasker.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.borntocode.tasker.Task;
import pl.borntocode.tasker.User;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class TaskForm {

    private String task;
    private String priority;
    private Date fromDate;
    private Date dueDate;

    public Task toTask(User user) {
        return new Task(task, priority, fromDate, dueDate, user);
    }
}

