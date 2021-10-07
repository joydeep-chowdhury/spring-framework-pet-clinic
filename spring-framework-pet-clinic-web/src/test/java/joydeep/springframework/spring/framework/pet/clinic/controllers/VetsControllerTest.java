package joydeep.springframework.spring.framework.pet.clinic.controllers;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.models.Vet;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
import joydeep.springframework.spring.framework.pet.clinic.services.VetService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VetsControllerTest {
    @Mock
    private VetService vetService;
    @Mock
    private Model model;
    private VetsController vetsController;
    private Set<Vet> vets=new HashSet<>();


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        vetsController = new VetsController(vetService);
        vets.add(Vet.builder().firstName("XYZ").lastName("ABC").build());
    }

    @Test
    public void TestIndex() {
        ArgumentCaptor<String> captorKey = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object> captorValue = ArgumentCaptor.forClass(Object.class);
        when(vetService.findAll()).thenReturn(vets);
        assertEquals("vets/index",vetsController.index(model));
        verify(vetService,times(1)).findAll();
        verify(model,times(1)).addAttribute(captorKey.capture(),captorValue.capture());
        assertEquals("vets",captorKey.getValue());
        Set<Vet> derivedVets = (Set<Vet>)captorValue.getValue();
        assertEquals(1,derivedVets.size());
    }
}