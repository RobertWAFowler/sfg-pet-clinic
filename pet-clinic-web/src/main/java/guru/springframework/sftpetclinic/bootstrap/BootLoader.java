package guru.springframework.sftpetclinic.bootstrap;

import guru.springframework.sftpetclinic.model.Owner;
import guru.springframework.sftpetclinic.model.Pet;
import guru.springframework.sftpetclinic.model.PetType;
import guru.springframework.sftpetclinic.model.Speciality;
import guru.springframework.sftpetclinic.model.Vet;
import guru.springframework.sftpetclinic.services.OwnerService;
import guru.springframework.sftpetclinic.services.PetTypeService;
import guru.springframework.sftpetclinic.services.SpecialityService;
import guru.springframework.sftpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BootLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public BootLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiologySpeciality = new Speciality();
        radiologySpeciality.setDescription("Radiology");
        Speciality savedRadiologySpeciality = specialityService.save(radiologySpeciality);

        Speciality dentistrySpeciality = new Speciality();
        dentistrySpeciality.setDescription("Dentistry");
        Speciality savedDentistrySpeciality = specialityService.save(dentistrySpeciality);

        Speciality surgerySpeciality = new Speciality();
        surgerySpeciality.setDescription("Surgery");
        Speciality savedSurgerySpeciality = specialityService.save(surgerySpeciality);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 A Road");
        owner1.setCity("Johannesberg");
        owner1.setTelephone("423245245245");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 A Road");
        owner2.setCity("Johannesberg");
        owner2.setTelephone("423245245245");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Mika");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiologySpeciality);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgerySpeciality);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
