package coins;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CoinCalcTest {

    private static CoinCalc coinCalc;

    @BeforeAll
    static void initialize(){
        coinCalc = new CoinCalc();
    }


    @Test
    void positiveIntegerTest(){
        assertEquals(4, coinCalc.changeBanknote(20).values().stream().reduce(0, Integer::sum));
        assertEquals(4, coinCalc.changeBanknote(20).values().stream().reduce(0, Integer::sum));
    }

    @ParameterizedTest
    @ValueSource(ints = {-25, -99, -1})
    void negativeIntegerTest(Integer i){
        Exception expectedEx = assertThrows(IllegalArgumentException.class, () ->
                coinCalc.changeBanknote(i)
        );
        assertTrue(expectedEx.getMessage().startsWith("Banknote value can not be smaller than 0."));
    }

    @ParameterizedTest
    @NullSource
    void nullTest(Integer i){
        Exception expectedEx = assertThrows(NullPointerException.class, () ->
                coinCalc.changeBanknote(i)
        );
        assertEquals("Banknote can not be null.", expectedEx.getMessage());
    }


}