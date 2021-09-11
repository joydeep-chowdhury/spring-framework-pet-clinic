package joydeep.springframework.spring.framework.pet.clinic.models.bootstrap;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;


public class DataLoader implements CommandLineRunner {

    private final Logger logger= LoggerFactory.getLogger(DataLoader.class);

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Joydeep");
        owner1.setLastName("Chowdhury");
        owner1.setId(356746L);

        Owner owner2 = new Owner();
        owner1.setFirstName("Indraneel");
        owner1.setLastName("Mukherjee");
        owner1.setId(356747L);

        ownerService.save(owner1);
        ownerService.save(owner2);
        logger.info("Loaded owners");


        Vet vet1 = new Vet();
        vet1.setFirstName("Indraprasta");
        vet1.setLastName("Mukherjee");
        vet1.setId(343434343L);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rohan");
        vet2.setLastName("Bhadury");
        vet2.setId(664774L);

        vetService.save(vet1);
        vetService.save(vet2);
        logger.info("Loaded vets");


    }
}
