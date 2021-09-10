package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.services.CrudRepository;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements CrudRepository<Vet, Long> {


    @Override
    public Vet save(Vet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Vet findByIdentity(Long id) {
        return super.findByIdentity(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByIdentity(Long id) {
        super.deleteByIdentity(id);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }
}
