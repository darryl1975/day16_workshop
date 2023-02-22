package sg.edu.nus.iss.day16_workshop.repo;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import sg.edu.nus.iss.day16_workshop.model.*;
import java.util.*;
import java.util.stream.*;

@Repository
public class BoardgameRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    public Boardgame save(Boardgame boardgame) {
        redisTemplate.opsForValue().set(boardgame.getId(), boardgame);

        return boardgame;
    }

    public Boardgame findBoardgameById(Integer id) {
        Boardgame bg = (Boardgame) redisTemplate.opsForValue().get(id);
        return bg;
    }

    public Boardgame update(Boardgame boardgame) {
        Boolean result = redisTemplate.opsForValue().setIfPresent(boardgame.getId(), boardgame);
        return boardgame;
    }

    public List<Boardgame> findAll() {
        return redisTemplate.opsForList().leftPop("boardgame", 0);
    }
}
