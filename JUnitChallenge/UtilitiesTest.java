package JUnitChallenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities util;

    @BeforeEach
    void init() {
        util = new Utilities();
    }

    @Test
    void everyNthChar() {
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    public static Stream<Arguments> removePairsTestConditions() {
        return Stream.of(
                Arguments.of("AABCDDEFF", "ABCDEF"),
                Arguments.of("ABCCABDEEF", "ABCABDEF"),
                Arguments.of(null, null),
                Arguments.of("A", "A"),
                Arguments.of("", ""),
                Arguments.of("ABCDEFF", "ABCDEF"),
                Arguments.of("AB88EFFG", "AB8EFG"),
                Arguments.of("112233445566", "123456"),
                Arguments.of("ZYZQQB", "ZYZQB")
                );
    }

    @ParameterizedTest(name = "Run {index}: actual={0}, expected={2}")
    @MethodSource("removePairsTestConditions")
    void removePairs(String expected, String actual) {
        assertEquals(actual, util.removePairs(expected));
    }

    @Test
    void converter() {
        assertEquals(300, util.converter(10, 5));
        Exception exception = assertThrows(ArithmeticException.class, () ->
                util.converter(10, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void nullIfOddLength() {
        assertNotNull(util.nullIfOddLength("AAAA"));
        assertNull(util.nullIfOddLength("AAA"));
    }
}