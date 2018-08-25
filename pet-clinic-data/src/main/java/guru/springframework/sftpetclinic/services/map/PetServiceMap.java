package guru.springframework.sftpetclinic.services.map;

import guru.springframework.sftpetclinic.model.Pet;
import guru.springframework.sftpetclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {

@Override
public Pet findById(Long id) {
        return super.findById(id);
        }

@Override
public void save(Pet object) {
        super.save(object.getId(),object);
        }

@Override
public Set<Pet> findAll() {
        return super.findAll();
        }

@Override
public void delete(Pet object) {
        super.delete(object);
        }

@Override
public void deleteById(Long id) {
        super.deleteById(id);
        } 
}