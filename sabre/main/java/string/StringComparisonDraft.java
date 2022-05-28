/* Copyright Sabre Corporation */
package string;

public class StringComparisonDraft implements StringComparison{
    @Override
    public boolean stringEqualsCheck(String abc) {
        if(abc == null){
            throw new NullPointerException("Parameter Should Not Be Null.");
        }
        return abc.equals("Sabre");
    }

    @Override
    public boolean stringNotBlankCheck(String abc) {
        if(abc == null){
            throw new NullPointerException("Parameter Should Not Be Null.");
        }
        return !abc.isBlank();
    }
}
