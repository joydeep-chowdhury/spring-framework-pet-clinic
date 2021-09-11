package joydeep.springframework.spring.framework.pet.clinic.models.configuration;

import joydeep.springframework.spring.framework.pet.clinic.models.bootstrap.DataLoader;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import joydeep.springframework.spring.framework.pet.clinic.services.map.OwnerMapService;
import joydeep.springframework.spring.framework.pet.clinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetClinicConfiguration {

    @Bean
    public OwnerService ownerService(){
        return new OwnerMapService();
    }

    @Bean
    public VetService vetService(){
        return new VetMapService();
    }

    @Bean
    public CommandLineRunner dataLoader(OwnerService ownerService, VetService vetService){
        return new DataLoader(ownerService,vetService);
    }


}
