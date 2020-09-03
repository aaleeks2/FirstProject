package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springbootapp.entity.Exhibit;

import java.util.List;

public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {

    List<Exhibit> findAllByExhibition(String exhibition);
}
