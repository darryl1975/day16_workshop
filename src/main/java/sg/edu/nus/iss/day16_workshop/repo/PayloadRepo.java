package sg.edu.nus.iss.day16_workshop.repo;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import sg.edu.nus.iss.day16_workshop.model.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PayloadRepo {

    public static final String HASH_KEY_NAME = "Payload_Item";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Payload save(Payload payload) {
        redisTemplate.opsForHash().put(HASH_KEY_NAME, payload.getId(), payload);
        return payload;
    }

    public List<Payload> findAll() {
        // List<Payload> payloads = new
        // ArrayList<Payload>(redisTemplate.opsForHash().values(HASH_KEY_NAME));

        List<Payload> payloads = redisTemplate
                .opsForHash()
                .values(HASH_KEY_NAME)
                .stream()
                .map(Payload.class::cast)
                .collect(Collectors.toList());
        return payloads;
    }

    public Payload findPayloadById(Integer id) {
        return (Payload) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);
    }

    public String deletePayloadById(Integer id) {
        Long lResult = redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);

        if (lResult >= 0) {
            return "Deleted";
        } else {
            return "Failed";
        }
    }

}
