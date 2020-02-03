package pl.borntocode.tasker.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.borntocode.tasker.Task;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("FROM Task T WHERE T.user.username=?1")
    Iterable<Task> getByUserUsername(@Param("user") String user);

}
