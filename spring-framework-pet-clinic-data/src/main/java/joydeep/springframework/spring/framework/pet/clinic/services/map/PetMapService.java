package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Pet;
import joydeep.springframework.spring.framework.pet.clinic.services.CrudRepository;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements CrudRepository<Pet, Long> {


    @Override
    public Pet save(Pet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Pet findByIdentity(Long id) {
        return super.findByIdentity(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByIdentity(Long id) {
        super.deleteByIdentity(id);
    }

    @Override
    public void delete(Pet entity) {
        super.delete(entity);
    }
}
