package joydeep.springframework.spring.framework.pet.clinic.services.jpa;

import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.repositories.SpecialityRepository;
import joydeep.springframework.spring.framework.pet.clinic.repositories.VetRepository;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("jpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;

    public VetJpaService(VetRepository vetRepository, SpecialityRepository specialityRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Vet save(Vet entity) {
        return vetRepository.save(entity);
    }

    @Override
    public Vet findByIdentity(Long identity) {
        return vetRepository.findById(identity).orElseThrow(() -> {
            throw new RuntimeException("Identity Not Found");
        });
    }

    @Override
    public Set<Vet> findAll() {
        return StreamSupport
                .stream(vetRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(Vet entity) {
        vetRepository.delete(entity);
    }

    @Override
    public void deleteByIdentity(Long identity) {
        vetRepository.deleteById(identity);
    }
}
