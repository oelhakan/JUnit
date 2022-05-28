package letters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringStatsDraftTest {

    private static StringStats strStats;

    @BeforeAll
    static void initialize(){
        strStats = new StringStatsDraft();
    }

    public static Stream<Arguments> averageStringLengthTestConditions() {
        return Stream.of(
                Arguments.of(0.0, new ArrayList<>(Arrays.asList("00", "01", "10"))),
                Arguments.of(7.0, new ArrayList<>(Arrays.asList("Sabre", "Summer", "Internship"))),
                Arguments.of(6.5, new ArrayList<>(Arrays.asList("Abcdef", "aafljaslfasf", "Testing")))
        );
    }

    @ParameterizedTest(name = "Run {index}: expectedResult={0}, input={1}")
    @MethodSource("averageStringLengthTestConditions")
    void averageStringLengthValidTests(Double expectedResult, List<String> input) {
        assertEquals(expectedResult, strStats.averageStringLength(input));
    }

    @ParameterizedTest
    @NullSource
    void averageStringLengthNullTest(List<String> input){
        Exception expectedEx = assertThrows(NullPointerException.class, () ->
                strStats.averageStringLength(input)
                );
        assertEquals("The Input List Can Not Contain Nulls Or Be Null.", expectedEx.getMessage());
    }

    @Test
    void averageStringLengthContainsNullTest(){
        Exception expectedEx1 = assertThrows(NullPointerException.class, () ->
                strStats.averageStringLength(Arrays.asList(null, "Abcdef", "GEASFGAS"))
        );
        Exception expectedEx2 = assertThrows(NullPointerException.class, () ->
                strStats.averageStringLength(Arrays.asList(null,null,null,null))
        );
        assertEquals("The Input List Can Not Contain Nulls Or Be Null.", expectedEx1.getMessage());
        assertEquals("The Input List Can Not Contain Nulls Or Be Null.", expectedEx2.getMessage());
    }

}