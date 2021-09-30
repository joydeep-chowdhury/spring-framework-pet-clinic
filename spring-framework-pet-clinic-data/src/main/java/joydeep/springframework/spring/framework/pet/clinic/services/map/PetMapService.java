package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Pet;
import joydeep.springframework.spring.framework.pet.clinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {


    @Override
    public Pet save(Pet entity) {
        return super.save( entity);
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
