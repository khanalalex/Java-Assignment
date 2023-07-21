package com.codewithalex.springmvc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codewithalex.springmvc.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsernameAndPassword(String un, String psw);


}
