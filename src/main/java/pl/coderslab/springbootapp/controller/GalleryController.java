package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.springbootapp.entity.Exhibition;
import pl.coderslab.springbootapp.repository.ExhibitionRepository;

import java.util.List;

@Controller
public class GalleryController {

    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @GetMapping(path = "/exhibitions")
    public String viewExhibitionsAnimator(){
        return "exhibitions/list";
    }


    @ModelAttribute("exhibitions")
    public List<Exhibition> exhibitions(){
        return exhibitionRepository.findAll();
    }
}
