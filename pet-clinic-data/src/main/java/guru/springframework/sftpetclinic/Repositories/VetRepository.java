package guru.springframework.sftpetclinic.Repositories;

import guru.springframework.sftpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertf on 2018/09/04
 */
public interface VetRepository extends CrudRepository<Vet,Long> {
}
