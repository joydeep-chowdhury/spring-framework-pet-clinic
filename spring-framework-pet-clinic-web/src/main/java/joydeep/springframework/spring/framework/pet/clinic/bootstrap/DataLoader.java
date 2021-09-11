package joydeep.springframework.spring.framework.pet.clinic.bootstrap;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
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

        Owner owner2 = new Owner();
        owner2.setFirstName("Indraneel");
        owner2.setLastName("Mukherjee");

        ownerService.save(owner1);
        ownerService.save(owner2);
        logger.info("Loaded owners");


        Vet vet1 = new Vet();
        vet1.setFirstName("Indraprasta");
        vet1.setLastName("Mukherjee");

        Vet vet2 = new Vet();
        vet2.setFirstName("Rohan");
        vet2.setLastName("Bhadury");

        vetService.save(vet1);
        vetService.save(vet2);
        logger.info("Loaded vets");


    }
}
