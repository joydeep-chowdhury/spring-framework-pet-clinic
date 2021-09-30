package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Visit;
import joydeep.springframework.spring.framework.pet.clinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit entity) {
        if (entity.getPet() == null || entity.getPet().getOwner() == null || entity.getPet().getId() == null || entity.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        } else {
            return super.save(entity);
        }
    }

    @Override
    public Visit findByIdentity(Long id) {
        return super.findByIdentity(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByIdentity(Long identity) {
        super.deleteByIdentity(identity);
    }

    @Override
    public void delete(Visit entity) {
        super.delete(entity);
    }
}
