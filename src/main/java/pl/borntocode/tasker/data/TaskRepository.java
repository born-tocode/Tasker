package pl.borntocode.tasker.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.borntocode.tasker.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task readByTaskContains(String string);
}
