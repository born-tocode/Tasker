package pl.borntocode.tasker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.borntocode.tasker.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> readByUsername(String username);
}
