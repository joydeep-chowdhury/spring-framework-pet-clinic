package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.services.CrudRepository;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudRepository<Owner, Long> {


    @Override
    public Owner save(Owner entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Owner findByIdentity(Long id) {
        return super.findByIdentity(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByIdentity(Long id) {
        super.deleteByIdentity(id);
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }
}
