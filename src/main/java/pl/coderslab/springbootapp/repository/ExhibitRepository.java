package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.springbootapp.entity.Exhibit;

import java.util.List;

@Repository
public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {

    @Query("select e from Exhibit e where e.exhibition.name=:name ")
    List<Exhibit> findAllByExhibitionName(@Param("name") String exhibitionName);

    Exhibit findByName(String exhibitName);

    @Query("select e from Exhibit e order by e.notifications.size desc")
    List<Exhibit> findAllCount();

}
