package sg.edu.nus.iss.day16_workshop.repo;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import sg.edu.nus.iss.day16_workshop.model.*;

@Repository
public class BoardgameRepo {

    @Autowired
    private RedisTemplate<Integer, Boardgame> redisTemplate;

    public Boardgame save(Boardgame boardgame) {
        ValueOperations<Integer, Boardgame> vo = redisTemplate.opsForValue();
        vo.set(boardgame.getId(), boardgame);

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
}
