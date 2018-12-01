package guru.springframework.sftpetclinic.services.map;

import guru.springframework.sftpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    public static final Long OWNER_ID = 1L;
    public static final String LASTNAME = "Wonker";

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LASTNAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);


        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner wonker = ownerMapService.findByLastName(LASTNAME);

        assertNotNull(wonker);

        assertEquals(OWNER_ID, wonker.getId());
    }
}
