package don.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ScoreTest {

    Score score;
    
    @Test
    void nullConstructor(){
        assertThrows(IllegalArgumentException.class, ()-> {
            this.score = new Score(null);
        });
    }
}
