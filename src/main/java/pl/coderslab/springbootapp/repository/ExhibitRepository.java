package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.entity.Exhibition;

import java.util.List;

public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {

    @Query("select e from Exhibit e where e.exhibition.name=:name ")
    List<Exhibit> findAllByExhibitionName(@Param("name") String exhibitionName);
}
