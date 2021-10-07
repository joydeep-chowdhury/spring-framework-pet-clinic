package joydeep.springframework.spring.framework.pet.clinic.controllers;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.repositories.OwnerRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OwnerRepositoryIT {

    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setUp() {
        Owner owner1 = Owner.builder().firstname("Joydeep").lastName("Chowdhury").address("House No 14 781018")
                .city("Guwahati").telephone("8099618378").pets(new HashSet<>()).build();
        ownerRepository.save(owner1);
    }

    @Test
    void findByLastName() {
        Optional<Owner> optionalOwner=ownerRepository.findByLastName("Chowdhury");
        assertEquals("Joydeep",optionalOwner.get().getFirstName());
    }
}