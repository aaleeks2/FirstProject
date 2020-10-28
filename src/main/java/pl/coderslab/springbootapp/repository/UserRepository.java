package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springbootapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from users u where u.department<>'User'")
    List<User> findAllItAndWorkshopEmployees();

//    @Query("select u from users u where u.username=?1")
    Optional<User> findByUsername(String username);
}
