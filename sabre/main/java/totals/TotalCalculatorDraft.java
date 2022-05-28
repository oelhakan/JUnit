/* Copyright Sabre Corporation */
package totals;

import java.util.List;

/*
 * - Create a implementation of TotalCalculator interface - find the total of double of even numbers bigger than 5
 *  from the provided list
 */
public class TotalCalculatorDraft implements TotalCalculator{

    @Override
    public Integer sum(List<Integer> list) {
        if(list == null){
            throw new NullPointerException("The Input List Can Not Be Null.");
        }
        return list.stream().filter(i -> i>5 && i%2==0).reduce(0, Integer::sum);
    }
}
