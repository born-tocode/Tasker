package pl.borntocode.tasker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.borntocode.tasker.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User readByUsername(String username);
}
