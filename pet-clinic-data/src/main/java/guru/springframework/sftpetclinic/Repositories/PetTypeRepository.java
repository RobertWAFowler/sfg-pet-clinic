package guru.springframework.sftpetclinic.Repositories;

import guru.springframework.sftpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertf on 2018/09/04
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
