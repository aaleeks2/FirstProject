package pl.coderslab.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.repository.ExhibitRepository;

import java.util.List;

@Service
public class ExhibitService {

    @Autowired
    private final ExhibitRepository exhibitRepository;

    public ExhibitService(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    public List<Exhibit> findAllByExhibitionName(String exhibitionName) {
        return exhibitRepository.findAllByExhibitionName(exhibitionName);
    }

    public Exhibit findByName(String exhibitName) {
        return exhibitRepository.findByName(exhibitName);
    }

    public List<Exhibit> findAll() {
        return exhibitRepository.findAll();
    }

    public List<Exhibit> findAllCount(){
        return exhibitRepository.findAllCount();
    }
}
