package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.models.Pet;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeMapService petTypeMapService;
    private final PetService petService;

    public OwnerMapService(PetTypeMapService petTypeMapService, PetService petService) {
        this.petTypeMapService = petTypeMapService;
        this.petService = petService;
    }


    @Override
    public Owner save(Owner entity) {
        if (entity != null) {
            if (entity.getPets() != null) {
                Set<Pet> pets = entity.getPets();
                pets.forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeMapService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(entity);
        } else {
            throw new RuntimeException("Owner cannot be null");
        }
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

    @Override
    public Owner findByLastName(String lastName) {
        return map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().get();
    }
}
