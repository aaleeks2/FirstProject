package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.springbootapp.entity.Exhibition;

import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

    List<Exhibition> findAll();

    @Query("select e from Exhibition e where e.name=?1")
    Exhibition findByName(String exhibitionName);
}