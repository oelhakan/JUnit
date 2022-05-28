package coins;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinCalc implements CoinChanger {

    @Override
    public Map<Integer, Integer> changeBanknote(Integer banknote) {

        if(banknote == null){
            throw new NullPointerException("Banknote can not be null.");
        }

        if(banknote<0){
            throw new IllegalArgumentException("Banknote value can not be smaller than 0.");
        }

        Map<Integer, Integer> out = new HashMap<>();
        List<Integer> coins = Arrays.asList(5,2,1);

        for(Integer i : coins){
            out.put(i, banknote/i);
            banknote %= i;
        }

        return out;
    }
}
