package joydeep.springframework.spring.framework.pet.clinic.services;

import joydeep.springframework.spring.framework.pet.clinic.models.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
