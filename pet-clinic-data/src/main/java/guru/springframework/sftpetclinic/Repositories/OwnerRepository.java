package guru.springframework.sftpetclinic.Repositories;

import guru.springframework.sftpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by robertf on 2018/09/04
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String anyString);
}
