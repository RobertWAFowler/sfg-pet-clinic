package guru.springframework.sftpetclinic.Repositories;

import guru.springframework.sftpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertf on 2018/09/04
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
