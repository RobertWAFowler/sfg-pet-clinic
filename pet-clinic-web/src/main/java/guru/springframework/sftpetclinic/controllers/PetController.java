package guru.springframework.sftpetclinic.controllers;

import guru.springframework.sftpetclinic.model.Owner;
import guru.springframework.sftpetclinic.model.PetType;
import guru.springframework.sftpetclinic.services.OwnerService;
import guru.springframework.sftpetclinic.services.PetService;
import guru.springframework.sftpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners/{ownerId}")
class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "petService/createOrUpdatePetForm";
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetService pets, PetTypeService petTypeService, OwnerService owners) {
        this.petService = pets;
        this.petTypeService = petTypeService;
        this.ownerService = owners;
    }

    @ModelAttribute("types")
    public Set<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
