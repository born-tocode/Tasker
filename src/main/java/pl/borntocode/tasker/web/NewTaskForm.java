package pl.borntocode.tasker.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.borntocode.tasker.User;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class NewTaskForm {

    private String task;
    private String priority;
    private Date fromDate;
    private Date dueDate;
    private User user;
}

