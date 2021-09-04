package joydeep.springframework.spring.framework.pet.clinic.services;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
