package pl.borntocode.tasker.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.borntocode.tasker.Task;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Long> {

    Iterable<Task> getTasksByUserUsername(@Param("user") String user);
    Iterable<Task> getTasksByUserUsernameOrderByDueDateAsc(@Param("user") String user);
    Iterable<Task> getTasksByUserUsernameOrderByDueDateDesc(@Param("user") String user);
    Iterable<Task> getTasksByUserUsernameOrderByAddTimeAsc(@Param("user") String user);
    Iterable<Task> getTasksByUserUsernameOrderByAddTimeDesc(@Param("user") String user);
    Iterable<Task> getTasksByUserUsernameOrderByFromDateAsc(@Param("user") String user);
    Iterable<Task> getTasksByUserUsernameOrderByFromDateDesc(@Param("user") String user);
    @Query("from Task T order by case when T.priority='L' then 0 when T.priority='M' then 1 when T.priority='H' then 3 else 4 end asc")
    Iterable<Task> getTasksByUserUsernameOrderByPriorityAsc(@Param("user") String user);
    @Query("from Task T order by case when T.priority='L' then 0 when T.priority='M' then 1 when T.priority='H' then 3 else 4 end desc")
    Iterable<Task> getTasksByUserUsernameOrderByPriorityDesc(@Param("user") String user);

}
