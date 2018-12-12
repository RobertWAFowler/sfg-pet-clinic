package guru.springframework.sftpetclinic.services;

import guru.springframework.sftpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String anyString);
}
