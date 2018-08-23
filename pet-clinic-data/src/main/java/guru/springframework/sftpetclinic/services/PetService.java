package guru.springframework.sftpetclinic.services;

import guru.springframework.sftpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    void save(Pet pet);

    Set<Pet> findAll();
}
