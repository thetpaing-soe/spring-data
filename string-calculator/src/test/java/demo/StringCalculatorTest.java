package demo;

import com.example.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void should_return_zero_when_empty_string_is_given() {
        assertThat(stringCalculator.add(""), equalTo(0));
    }

    @Test
    public void should_return_num_when_single_string_num_is_given() {
        assertThat(stringCalculator.add("7"), equalTo(7));
    }

    @Test
    public void should_return_sum_when_two_string_nums_are_given() {
        assertThat(stringCalculator.add("5,7"), equalTo(12));
    }

    @Test
    public void should_return_sum_when_multiple_string_nums_are_given() {
        assertThat(stringCalculator.add("1,2,3,4"), equalTo(10));
    }
}
