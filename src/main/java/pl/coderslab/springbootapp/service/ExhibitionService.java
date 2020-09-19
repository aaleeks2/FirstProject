package pl.coderslab.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springbootapp.entity.Exhibition;
import pl.coderslab.springbootapp.repository.ExhibitionRepository;

import java.util.List;

@Service
public class ExhibitionService {

    @Autowired
    private final ExhibitionRepository exhibitionRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public Exhibition findByName(String exhibitionName) {
        return exhibitionRepository.findByName(exhibitionName);
    }

    public List<Exhibition> findAll() {
        return exhibitionRepository.findAll();
    }
}
