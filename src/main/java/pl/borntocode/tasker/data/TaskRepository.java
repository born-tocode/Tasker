package pl.borntocode.tasker.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.borntocode.tasker.Task;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query(value = "select * from Tasks where USER_USERNAME =? limit 100", nativeQuery = true)
    List<Task> getByUserUsername(@Param("user") String user);
}
