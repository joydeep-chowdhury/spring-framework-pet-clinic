package joydeep.springframework.spring.framework.pet.clinic.bootstrap;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.models.Pet;
import joydeep.springframework.spring.framework.pet.clinic.models.PetType;
import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.PetTypeService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataLoader implements CommandLineRunner {

    private final Logger logger= LoggerFactory.getLogger(DataLoader.class);

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Joydeep");
        owner1.setLastName("Chowdhury");
        owner1.setAddress("House No 14 781018");
        owner1.setCity("Guwahati");
        owner1.setTelephone("8099618378");

        Pet owner1Dog= new Pet();
        owner1Dog.setOwner(owner1);
        owner1Dog.setPetType(savedDogPetType);
        owner1Dog.setName("Rocky");
        owner1Dog.setBirthDate(LocalDate.now());
        owner1.getPets().add(owner1Dog);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dr Indraneel");
        owner2.setLastName("Mukherjee");
        owner2.setAddress("Ganesh Patthar");
        owner2.setCity("Guwahati");
        owner2.setTelephone("7002439575");

        Pet owner2Cat= new Pet();
        owner2Cat.setOwner(owner2);
        owner2Cat.setPetType(savedCatPetType);
        owner2Cat.setName("Kitty");
        owner2Cat.setBirthDate(LocalDate.now());
        owner2.getPets().add(owner2Cat);

        ownerService.save(owner1);
        ownerService.save(owner2);
        logger.info("Loaded owners");


        Vet vet1 = new Vet();
        vet1.setFirstName("Indraprasta Kumar");
        vet1.setLastName("Mukherjee");

        Vet vet2 = new Vet();
        vet2.setFirstName("Rohan Kumar");
        vet2.setLastName("Bhadury");

        vetService.save(vet1);
        vetService.save(vet2);
        logger.info("Loaded vets");


    }
}
