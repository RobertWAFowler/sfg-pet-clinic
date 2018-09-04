package guru.springframework.sftpetclinic.Repositories;

import guru.springframework.sftpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertf on 2018/09/04
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
