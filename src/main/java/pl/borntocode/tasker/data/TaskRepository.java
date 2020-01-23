package pl.borntocode.tasker.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.borntocode.tasker.Task;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {

    Iterable<Task> readTaskOrderByUserUsername(String user);

}
