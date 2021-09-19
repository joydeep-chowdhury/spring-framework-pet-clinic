package joydeep.springframework.spring.framework.pet.clinic.services.jpa;

import joydeep.springframework.spring.framework.pet.clinic.models.PetType;
import joydeep.springframework.spring.framework.pet.clinic.repositories.PetTypeRepository;
import joydeep.springframework.spring.framework.pet.clinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(final PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public PetType save(PetType entity) {
        return petTypeRepository.save(entity);
    }

    @Override
    public PetType findByIdentity(Long identity) {
        return Optional.ofNullable(petTypeRepository.findByIdentity(identity)).orElseThrow(()->{
            throw new RuntimeException("Pet type couldnot be resolved with the identity");
        });
    }

    @Override
    public Set<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    @Override
    public void delete(PetType entity) {
        petTypeRepository.delete(entity);
    }

    @Override
    public void deleteByIdentity(Long identity) {
       petTypeRepository.deleteByIdentity(identity);
    }
}
