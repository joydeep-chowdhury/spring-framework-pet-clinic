package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Speciality;
import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.services.SpecialitiesService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {


    private final SpecialitiesService specialitiesService;

    public VetMapService(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Vet save(Vet entity) {
        if(!entity.getSpecialities().isEmpty()){
            Set<Speciality> specialities = entity.getSpecialities();
            specialities.forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialitiesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(entity);
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
