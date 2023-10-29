package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator;
    @BeforeEach
    void setUp(){
        validator = new Validator();
    }
    @Test
    void 정해진_형식대로_입력하면_에러없이_동작한다(){
        String correctInput = "poby,crong,winter";
        Assertions.assertDoesNotThrow(()->validator.validateUserInputIsCorrectFormat(correctInput));
    }
    @Test
    void 형식이_맞지_않으면_에러가_발생한다(){
        String wrongInput = "ppobby<crongwinter>.hani";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectFormat(wrongInput));
        Assertions.assertEquals("입력된 값이 형식에 맞지 않습니다!",exception.getMessage());
    }
}
