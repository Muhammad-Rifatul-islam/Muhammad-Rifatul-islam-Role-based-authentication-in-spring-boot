package bd.edu.rifat.group.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bd.edu.rifat.group.model.User;


public interface UserRepository  extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String username);
	


}
