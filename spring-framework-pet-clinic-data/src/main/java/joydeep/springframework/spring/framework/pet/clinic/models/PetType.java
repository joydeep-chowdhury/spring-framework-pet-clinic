package joydeep.springframework.spring.framework.pet.clinic.models;

import com.fasterxml.jackson.databind.ser.Serializers.Base;

public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
