package totals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TotalCalculatorDraftTest {

    private static TotalCalculatorDraft total;

    @BeforeAll
    static void initialize(){
        total = new TotalCalculatorDraft();
    }

    public static Stream<Arguments> totalTestConditions() {
        return Stream.of(
                Arguments.of(0, new ArrayList<>(Arrays.asList(1,2,3,4,5))),
                Arguments.of(24, new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                Arguments.of(0, new ArrayList<>(Arrays.asList(-2, -1, -3, -5))),
                Arguments.of(100, new ArrayList<>(Arrays.asList(10,20,30,40))),
                Arguments.of(0, new ArrayList<Integer>())
        );
    }

    @ParameterizedTest(name = "Run {index}: expectedResult={0}, input={1}")
    @MethodSource("totalTestConditions")
    void totalValidTests(Integer expectedResult, List<Integer> input) {
        assertEquals(expectedResult, total.sum(input));
    }

    @ParameterizedTest
    @NullSource
    void totalNullTest(List<Integer> input){
        Exception expectedEx = assertThrows(NullPointerException.class, () ->
                total.sum(input)
                );
        assertEquals("The Input List Can Not Be Null.", expectedEx.getMessage());

    }



}