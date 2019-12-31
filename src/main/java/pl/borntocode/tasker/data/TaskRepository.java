package pl.borntocode.tasker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.borntocode.tasker.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByTaskContains(String string);
}
