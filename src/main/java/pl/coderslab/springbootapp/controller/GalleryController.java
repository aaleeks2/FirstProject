package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.entity.Exhibition;
import pl.coderslab.springbootapp.repository.ExhibitRepository;
import pl.coderslab.springbootapp.repository.ExhibitionRepository;

import java.util.List;

@Controller
public class GalleryController {

    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @Autowired
    private ExhibitRepository exhibitRepository;

    @GetMapping(path = "/exhibitions", produces = "text/plain; charset=UTF-8")
    public String viewExhibitionsAnimator(){
        return "exhibitions/list";
    }

    @GetMapping(path = "/exhibitions/exhibits", produces = "text/plain; charset = UTF-8")
    public String viewExhibitionsExhibitsAnimator(Model model, @RequestParam("exhibitionName") String exhibitionName){
        Exhibition exhibition = exhibitionRepository.findByName(exhibitionName);
        List<Exhibit> exhibits = exhibitRepository.findAllByExhibitionName(exhibitionName);
        model.addAttribute("exhibition", exhibition);
        model.addAttribute("exhibitsOfExhibition", exhibits);
        return "exhibits/list";
    }


    @ModelAttribute("exhibitions")
    public List<Exhibition> exhibitions(){
        return exhibitionRepository.findAll();
    }
}
