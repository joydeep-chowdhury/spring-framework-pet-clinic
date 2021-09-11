package joydeep.springframework.spring.framework.pet.clinic.services.map;

import joydeep.springframework.spring.framework.pet.clinic.models.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<R extends BaseEntity, ID extends Long> {

    protected Map<Long, R> map = new HashMap<>();

    Set<R> findAll() {
        return new HashSet<>(map.values());
    }

    R findByIdentity(ID id) {
        return map.get(id);
    }

    R save(R object) {
        if(object != null ){
            Long generatedId = generateId();
            object.setId(generatedId);
            map.put(generatedId, object);
            return object;
        }
        else{
            throw new RuntimeException("Object cannot be null");
        }
    }

    void deleteByIdentity(ID id) {
        map.remove(id);
    }

    void delete(R object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long generateId(){
        if(map.isEmpty()){
            return 356746L;
        }
        else{
            return Collections.max(map.keySet()) + 1;
        }

    }
}
