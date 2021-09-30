package joydeep.springframework.spring.framework.pet.clinic.repositories;

import joydeep.springframework.spring.framework.pet.clinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
