package pl.borntocode.tasker;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, message = "Task must contain at least 3 characters")
    private String task;

    @NotNull
    @Pattern(regexp = "[\\d{8}]")
    private Date fromDate;

    @NotNull
    @Pattern(regexp = "[\\d{8}]")
    private Date dueDate;

    private Timestamp timestamp;
}
