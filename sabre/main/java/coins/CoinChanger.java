package coins;

import java.util.Map;

/**
 * Please create an implementation of a Coin Changer
 * - use as little coins as possible to change a single banknote
 * - banknote can have any integer value
 * - available coins are 5, 2, 1 PLN
 * - assume you have unlimited coins of every value
 */
public interface CoinChanger
{
    Map<Integer, Integer> changeBanknote(Integer banknote);
}
