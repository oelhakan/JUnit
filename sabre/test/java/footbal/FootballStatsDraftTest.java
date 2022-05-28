package footbal;

import footbal.player.PitchPosition;
import footbal.player.Player;
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

class FootballStatsDraftTest {

    private static FootballStats footballStats;

    @BeforeAll
    static void initialize(){
        footballStats = new FootballStatsDraft();
    }

    public static Stream<Arguments> calculateDistanceTestConditions() {
        return Stream.of(
                Arguments.of(55.0, new ArrayList<>(Arrays.asList(
                        new Player("Lionel Messi", PitchPosition.FORWARD, 55),
                        new Player("Gianluigi Donnaruma", PitchPosition.GOALKEEPER, 4),
                        new Player("Sergio Ramos", PitchPosition.DEFENDER, 17),
                        new Player("Erling Haaland", PitchPosition.STRIKER, 43)))),
                Arguments.of(156.0, new ArrayList<>(Arrays.asList(
                        new Player("Cristiano Ronaldo", PitchPosition.FORWARD, 31),
                        new Player("Kylian Mbappe", PitchPosition.FORWARD, 49),
                        new Player("Robert Lewandowski", PitchPosition.FORWARD, 33),
                        new Player("Mohammed Salah", PitchPosition.FORWARD, 43)
                )))
        );
    }

    @ParameterizedTest(name = "Run {index}: expectedResult={0}, input={1}")
    @MethodSource("calculateDistanceTestConditions")
    void calculateDistanceValidTests(Double expectedResult, List<Player> input) {
        assertEquals(expectedResult, footballStats.calculateDistanceCovered(input));
    }

    @ParameterizedTest
    @NullSource
    void calculateDistanceNullTest(List<Player> input){
        Exception expectedEx = assertThrows(NullPointerException.class, () ->
                footballStats.calculateDistanceCovered(input)
                );
        assertEquals(expectedEx.getMessage(), "The Input List Can Not Contain Nulls Or Be Null.");
    }

    @Test
    void calculateDistanceContainsNullTest(){
        Exception expectedEx1 = assertThrows(NullPointerException.class, () ->
                footballStats.calculateDistanceCovered(Arrays.asList(
                        new Player("Kevin De Bruyne", PitchPosition.FORWARD, 27),
                        null
                ))
        );
        assertEquals(expectedEx1.getMessage(), "The Input List Can Not Contain Nulls Or Be Null.");

        Exception expectedEx2 = assertThrows(NullPointerException.class, () ->
                footballStats.calculateDistanceCovered(Arrays.asList(null, null, null))
        );
        assertEquals(expectedEx2.getMessage(), "The Input List Can Not Contain Nulls Or Be Null.");
    }

}