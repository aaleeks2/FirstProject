package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springbootapp.entity.Exhibition;

import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

    List<Exhibition> findAll();
}
