package joydeep.springframework.spring.framework.pet.clinic.services.jpa;

import joydeep.springframework.spring.framework.pet.clinic.models.Speciality;
import joydeep.springframework.spring.framework.pet.clinic.repositories.SpecialityRepository;
import joydeep.springframework.spring.framework.pet.clinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialityJpaService implements SpecialitiesService {

    private final SpecialityRepository specialityRepository;

    public SpecialityJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Speciality save(Speciality entity) {
        return specialityRepository.save(entity);
    }

    @Override
    public Speciality findByIdentity(Long identity) {
        return Optional.ofNullable(specialityRepository.findByIdentity(identity)).orElseThrow(()->{
            throw new RuntimeException("Speciality with provided id not found");
        });
    }

    @Override
    public Set<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public void delete(Speciality entity) {
        specialityRepository.delete(entity);
    }

    @Override
    public void deleteByIdentity(Long identity) {
       specialityRepository.deleteByIdentity(identity);
    }
}
