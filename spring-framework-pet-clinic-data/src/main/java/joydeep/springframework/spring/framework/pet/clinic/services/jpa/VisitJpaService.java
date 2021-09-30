package joydeep.springframework.spring.framework.pet.clinic.services.jpa;

import joydeep.springframework.spring.framework.pet.clinic.models.Visit;
import joydeep.springframework.spring.framework.pet.clinic.repositories.VisitRepository;
import joydeep.springframework.spring.framework.pet.clinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("jpa")
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit entity) {
        return visitRepository.save(entity);
    }

    @Override
    public Visit findByIdentity(Long identity) {
        Optional<Visit> optionalVisit = visitRepository.findById(identity);

        return optionalVisit.orElseThrow(() -> {
            throw new RuntimeException("Visits cannot be retrieved by identity");
        });
    }

    @Override
    public Set<Visit> findAll() {
        return StreamSupport
                .stream(visitRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(Visit entity) {
        visitRepository.delete(entity);
    }

    @Override
    public void deleteByIdentity(Long identity) {
        visitRepository.deleteById(identity);
    }
}
