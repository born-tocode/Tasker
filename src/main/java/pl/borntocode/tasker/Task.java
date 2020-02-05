package pl.borntocode.tasker;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

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
    private final String priority;
    @NotNull
    private final Date fromDate;
    @NotNull
    private final Date dueDate;
    @CreationTimestamp
    private Timestamp addTime;

    public Task(String task, String priority, Date fromDate, Date dueDate, User user) {
        this.task = task;
        this.priority = priority;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.user = user;
    }
}
