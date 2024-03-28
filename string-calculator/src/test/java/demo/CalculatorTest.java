package demo;

import com.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void should_return_sum_when_two_integers_are_given() {

        assertThat(calculator.add(5, 7), equalTo(12));
    }
}
