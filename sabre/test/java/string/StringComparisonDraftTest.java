package string;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringComparisonDraftTest {

    private static StringComparisonDraft strComp;

    @BeforeAll
    static void initialize(){
        strComp = new StringComparisonDraft();
    }

    @Test
    void isSabreValidStringTest(){
        assertTrue(strComp.stringEqualsCheck("Sabre"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Not Sabre", "Onur", "Elhakan"})
    void isSabreInvalidStringTest(String s){
        assertFalse(strComp.stringEqualsCheck(s));
    }

    @ParameterizedTest
    @NullSource
    void isSabreNullTest(String s){
        Exception expectedEx = assertThrows(NullPointerException.class, () ->
                strComp.stringNotBlankCheck(s)
        );
        assertEquals("Parameter Should Not Be Null.", expectedEx.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sabre", "Junit", "Testing"})
    void isBlankValidStringTest(String s){
        assertTrue(strComp.stringNotBlankCheck(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "     "})
    void isBlankBlankStringTest(String s){
        assertFalse(strComp.stringNotBlankCheck(s));
    }

    @ParameterizedTest
    @NullSource
    void isBlankNullTest(String s){
        Exception expectedEx = assertThrows(NullPointerException.class, () ->
                strComp.stringNotBlankCheck(s)
        );
        assertEquals("Parameter Should Not Be Null.", expectedEx.getMessage());
    }

}