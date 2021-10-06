package joydeep.springframework.spring.framework.pet.clinic.bootstrap;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.models.Pet;
import joydeep.springframework.spring.framework.pet.clinic.models.PetType;
import joydeep.springframework.spring.framework.pet.clinic.models.Speciality;
import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.models.Visit;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.PetTypeService;
import joydeep.springframework.spring.framework.pet.clinic.services.SpecialitiesService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import joydeep.springframework.spring.framework.pet.clinic.services.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;

@Service
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().isEmpty()){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Owner owner1 = Owner.builder().firstname("Joydeep").lastName("Chowdhury").address("House No 14 781018")
                            .city("Guwahati").telephone("8099618378").pets(new HashSet<>()).build();

        Pet owner1Dog = new Pet();
        owner1Dog.setOwner(owner1);
        owner1Dog.setPetType(savedDogPetType);
        owner1Dog.setName("Rocky");
        owner1Dog.setBirthDate(LocalDate.now());
        owner1.getPets().add(owner1Dog);

        Owner owner2 = Owner.builder().firstname("Dr Indraneel").lastName("Mukherjee").address("Ganesh Patthar")
                .city("Guwahati").telephone("7002439575").pets(new HashSet<>()).build();

        Pet owner2Cat = new Pet();
        owner2Cat.setOwner(owner2);
        owner2Cat.setPetType(savedCatPetType);
        owner2Cat.setName("Kitty");
        owner2Cat.setBirthDate(LocalDate.now());
        owner2.getPets().add(owner2Cat);

        Visit owner2CatVisit = new Visit();
        owner2CatVisit.setPet(owner2Cat);
        owner2CatVisit.setDate(LocalDate.now());
        owner2CatVisit.setDescription("Owner 2 cat visit");


        ownerService.save(owner1);
        ownerService.save(owner2);
        logger.info("Loaded owners");

        visitService.save(owner2CatVisit);
        logger.info("Saved visit");


        Vet vet1 = Vet.builder().firstName("Indraprasta Kumar").lastName("Mukherjee").build();
        vet1.getSpecialities().add(savedDentistry);

        Vet vet2 = Vet.builder().firstName("Rohan Kumar").lastName("Bhadury").build();
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet1);
        vetService.save(vet2);
        logger.info("Loaded vets");
    }
}
