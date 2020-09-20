package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.springbootapp.entity.Exhibition;

import java.util.List;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

    List<Exhibition> findAll();
    Exhibition findByName(String exhibitionName);
}
