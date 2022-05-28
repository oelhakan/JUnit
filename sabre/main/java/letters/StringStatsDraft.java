/* Copyright 2021 Sabre Holdings */
package letters;

/*
* Create an implementation of StringStats
* find the average number of letters in strings where string is starting with capital letter and has length bigger than 3
*/

import java.util.List;

public class StringStatsDraft implements StringStats{
    @Override
    public Double averageStringLength(List<String> strings) {
        if(strings == null || strings.contains(null)){
            throw new NullPointerException("The Input List Can Not Contain Nulls Or Be Null.");
        }
        List<String> filteredStrings = strings.stream().filter(s -> s.length() > 3 && Character.isUpperCase(s.charAt(0))).toList();
        return filteredStrings.size() == 0 ? 0.0 : (double)filteredStrings.stream().mapToInt(String::length).sum() / (double)filteredStrings.size();
    }
}
