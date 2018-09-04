package guru.springframework.sftpetclinic.Repositories;

import guru.springframework.sftpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertf on 2018/09/04
 */
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
