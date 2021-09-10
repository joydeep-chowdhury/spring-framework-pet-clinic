package joydeep.springframework.spring.framework.pet.clinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<R, ID> {

    protected Map<ID, R> map = new HashMap<>();

    Set<R> findAll() {
        return new HashSet<>(map.values());
    }

    R findByIdentity(ID id) {
        return map.get(id);
    }

    R save(ID id, R object) {
        map.put(id, object);
        return object;
    }

    void deleteByIdentity(ID id) {
        map.remove(id);
    }

    void delete(R object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
