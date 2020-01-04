package pl.borntocode.tasker;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
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
}
