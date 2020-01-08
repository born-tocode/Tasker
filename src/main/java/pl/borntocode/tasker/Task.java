package pl.borntocode.tasker;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Task {

    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, message = "Task must contain at least 3 characters")
    private String task;

    @Pattern(regexp = "[\\d{8}]", message = "Must contain 8 digits in format YYYYMMDD")
    private Date fromDate;

    @Pattern(regexp = "[\\d{8}]", message = "Must contain 8 digits in format YYYYMMDD")
    private Date dueDate;

    private Timestamp timestamp;

    public Task(String task, Date fromDate, Date dueDate) {
        this.task = task;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.timestamp = getTimestamp();
    }
}
