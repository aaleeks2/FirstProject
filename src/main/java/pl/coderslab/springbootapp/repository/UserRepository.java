package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springbootapp.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from users u where u.department<>'User'")
    List<User> findAllItAndWorkshopEmployees();

}
