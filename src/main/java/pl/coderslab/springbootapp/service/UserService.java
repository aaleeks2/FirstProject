package pl.coderslab.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springbootapp.entity.User;
import pl.coderslab.springbootapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllItAndWorkshopEmployees() {
        return userRepository.findAllItAndWorkshopEmployees();
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
