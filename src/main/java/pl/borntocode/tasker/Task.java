package pl.borntocode.tasker;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pl.borntocode.tasker.web.NewTaskForm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Entity
@Table(name = "Tasks")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Task {

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER_USERNAME", referencedColumnName = "USERNAME")
    private final User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 300, message = "Task must contain at least 3 and max 300 characters")
    private final String task;
    @NotNull
    private final Date fromDate;
    @NotNull
    private final Date dueDate;
    @CreationTimestamp
    private java.util.Date createTime;

    public Task(NewTaskForm taskForm) {
        this.task = taskForm.getTask();
        this.fromDate = taskForm.getFromDate();
        this.dueDate = taskForm.getDueDate();
        this.user = taskForm.getUser();
    }
}
