package joydeep.springframework.spring.framework.pet.clinic.services;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;


public interface OwnerService extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
