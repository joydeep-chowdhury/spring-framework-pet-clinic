package joydeep.springframework.spring.framework.pet.clinic.controllers;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.services.OwnerService;
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

public class OwnersControllerTest {
    @Mock
    private OwnerService ownerService;
    @Mock
    private Model model;
    private OwnersController ownersController;
    private Set<Owner> owners=new HashSet<>();


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ownersController = new OwnersController(ownerService);
        owners.add(Owner.builder().firstname("XYZ").lastName("ABC").build());
    }

    @Test
    public void TestIndex() {
        ArgumentCaptor<String> captorKey = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object> captorValue = ArgumentCaptor.forClass(Object.class);
        when(ownerService.findAll()).thenReturn(owners);
        assertEquals("owners/index",ownersController.index(model));
        verify(ownerService,times(1)).findAll();
        verify(model,times(1)).addAttribute(captorKey.capture(),captorValue.capture());
        assertEquals("owners",captorKey.getValue());
        Set<Owner> derivedOwners = (Set<Owner>)captorValue.getValue();
        assertEquals(1,derivedOwners.size());
    }
}