package guru.springframework.sftpetclinic.services;

import guru.springframework.sftpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
