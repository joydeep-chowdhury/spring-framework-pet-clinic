package joydeep.springframework.spring.framework.pet.clinic.controllers;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IndexControllerTest {

    private IndexController indexController;

    @Before
    public void setUp() {
        indexController= new IndexController();
    }

    @Test
    public void verifyIndexPage(){
        assertEquals("index",indexController.index());
    }


}