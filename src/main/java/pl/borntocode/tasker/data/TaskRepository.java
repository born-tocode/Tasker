package pl.borntocode.tasker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.borntocode.tasker.Task;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Long> {

    Iterable<Task> getTasksByUserUsername(@Param("user") String user);

}
