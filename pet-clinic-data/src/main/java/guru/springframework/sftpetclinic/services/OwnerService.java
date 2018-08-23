package guru.springframework.sftpetclinic.services;

import guru.springframework.sftpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    void save(Owner owner);

    Set<Owner> findAll();
}
