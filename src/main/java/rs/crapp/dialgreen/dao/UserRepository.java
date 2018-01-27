package rs.crapp.dialgreen.dao;

import org.springframework.data.repository.CrudRepository;
import rs.crapp.dialgreen.domain.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
