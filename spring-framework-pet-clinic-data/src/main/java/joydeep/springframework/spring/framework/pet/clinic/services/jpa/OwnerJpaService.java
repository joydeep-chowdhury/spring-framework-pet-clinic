package joydeep.springframework.spring.framework.pet.clinic.services.jpa;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.repositories.OwnerRepository;
import joydeep.springframework.spring.framework.pet.clinic.repositories.PetRepository;
import joydeep.springframework.spring.framework.pet.clinic.repositories.PetTypeRepository;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("jpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(final OwnerRepository ownerRepository,
                           final PetRepository petRepository,
                           final PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Owner save(Owner entity) {
        return ownerRepository.save(entity);
    }

    @Override
    public Owner findByIdentity(Long identity) {
        return ownerRepository.findById(identity).orElseThrow(() -> {
            throw new RuntimeException("Identity Not Found");
        });
    }

    @Override
    public Set<Owner> findAll() {
        return StreamSupport
                .stream(ownerRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(Owner entity) {
       ownerRepository.delete(entity);
    }

    @Override
    public void deleteByIdentity(Long identity) {
       ownerRepository.deleteById(identity);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> optionalOwner = ownerRepository.findByLastName(lastName);
        return optionalOwner.orElseThrow(() -> {
            throw new RuntimeException("LastName not found");
        });
    }
}
