package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Speciality;
import joydeep.springframework.spring.framework.pet.clinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
    @Override
    public Speciality save(Speciality entity) {
        return super.save(entity);
    }

    @Override
    public Speciality findByIdentity(Long id) {
        return super.findByIdentity(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByIdentity(Long id) {
        super.deleteByIdentity(id);
    }

    @Override
    public void delete(Speciality entity) {
        super.delete(entity);
    }
}
