package joydeep.springframework.spring.framework.pet.clinic.services.jpa;

import joydeep.springframework.spring.framework.pet.clinic.models.Pet;
import joydeep.springframework.spring.framework.pet.clinic.repositories.PetRepository;
import joydeep.springframework.spring.framework.pet.clinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("jpa")
public class PetJpaService implements PetService {

    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet save(Pet entity) {
        return petRepository.save(entity);
    }

    @Override
    public Pet findByIdentity(Long identity) {
        return petRepository.findById(identity).orElseThrow(()->{
            throw new RuntimeException("Pet with identity not found");
        });
    }

    @Override
    public Set<Pet> findAll() {
        return StreamSupport
                .stream(petRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(Pet entity) {
        petRepository.delete(entity);
    }

    @Override
    public void deleteByIdentity(Long identity) {
       petRepository.deleteById(identity);
    }
}
