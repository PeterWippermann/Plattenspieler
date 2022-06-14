package de.wit.bibinfo.plattenspieler.controller.ui;

import de.wit.bibinfo.plattenspieler.domain.ReleasesDto;
import de.wit.bibinfo.plattenspieler.services.ReleasesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/Releases")
public class ReleasesUiController {

    private final ReleasesService releasesService;

    public ReleasesUiController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }

    private static final String LIST_RELEASES = "Releases/listReleases";
    private static final String CREATE_EDIT_RELEASES = "Releases/createReleases";

    @GetMapping("")
    public ModelAndView listReleases() {
        ModelAndView modelAndView = new ModelAndView(LIST_RELEASES);
        modelAndView.addObject("releasesList", this.releasesService.getReleases());

        return modelAndView;
    }

    @GetMapping ({"/createReleases"})
    public ModelAndView createReleases() {
        ModelAndView modelAndView = new ModelAndView(CREATE_EDIT_RELEASES);
        modelAndView.addObject("newReleaseDto", new ReleasesDto());
        modelAndView.addObject("pageTitle", "Neuen Release erstellen");

        return modelAndView;
    }


    @PostMapping({"/saveReleases"})
    public ModelAndView saveReleases(ReleasesDto releasesDto, RedirectAttributes redirectAttributes) {
        releasesService.saveRelease(releasesDto);

        // TODO Hier fehlt das Setzen des message Attributs für die Alert Message
        
        return listReleases();

    }

    @GetMapping({"/editReleases/{catalog}"})
    public ModelAndView editReleases(@PathVariable("catalog") String catalog, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView(CREATE_EDIT_RELEASES);
        ReleasesDto releasesDto = releasesService.getRelease(catalog);
        modelAndView.addObject("newReleaseDto", releasesDto);
        modelAndView.addObject("pageTitle", "Release bearbeiten");

        return modelAndView;
    }


    @GetMapping({"/deleteReleases/{catalog}"})
    public String deleteReleases(@PathVariable("catalog") String catalog, RedirectAttributes redirectAttributes) {
        releasesService.deleteRelease(catalog);
        redirectAttributes.addFlashAttribute("message","Release wurde gelöscht");

        return "redirect:/Releases";

    }
}
