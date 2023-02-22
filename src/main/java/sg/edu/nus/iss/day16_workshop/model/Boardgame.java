package sg.edu.nus.iss.day16_workshop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("boardgame")
public class Boardgame implements Serializable {
    @Id
    private Integer id;

    private Integer count;    
}
