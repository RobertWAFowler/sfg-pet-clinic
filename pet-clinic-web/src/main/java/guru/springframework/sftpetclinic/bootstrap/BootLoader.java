package guru.springframework.sftpetclinic.bootstrap;

import guru.springframework.sftpetclinic.model.Owner;
import guru.springframework.sftpetclinic.model.Vet;
import guru.springframework.sftpetclinic.services.OwnerService;
import guru.springframework.sftpetclinic.services.VetService;
import guru.springframework.sftpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sftpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    public final VetService vetService;

    public BootLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}