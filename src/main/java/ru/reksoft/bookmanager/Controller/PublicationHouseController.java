package ru.reksoft.bookmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.reksoft.bookmanager.service.IPublicationHouseService;

/**
 * Created by agubanov on 13.06.2017.
 */
@Controller
public class PublicationHouseController {

    @Autowired
    private IPublicationHouseService publicationHouseService;

    @RequestMapping(value = "publicationHouse/{id}")
    public String publicationHouse(@PathVariable("id") int id, Model model){
        model.addAttribute("publicationHouse", this.publicationHouseService.getPublicationHouseById(id));
        return "publicationHouse";
    }
}
