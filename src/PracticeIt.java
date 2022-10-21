public class PracticeIt {
    void countBinary(int n){
        // call recursive helper function
        // countBinary(n, ""); // USES STRING CONCATENATION
        // countBinary(n, new StringBuilder()); // USES StringBuilder
    }

    void countBinary(int n, String result) {
        if(n == result.length()){
            // print out result
            System.out.println(result);
        }
        else {
            // add a 0 to the result
            result = result + "0";
            countBinary(n, result);
            result = result.substring(0, result.length() - 1); // cut off the end of result

            // add a 1 to the result
            result = result + "1";
            countBinary(n, result);
            // result = result.substring(0, result.length() - 1); // cut off the end of result
        }
    }

    void countBinary(int n, StringBuilder result){
        if(n == result.length()){
            // print out result
            System.out.println(result);
        }
        else {
            // add a 0 to the result
            result = result.append('0');
            countBinary(n, result);
            result.deleteCharAt(result.length()-1); // cut off the end of result

            // add a 1 to the result
            result = result.append('1');
            countBinary(n, result);
            result.deleteCharAt(result.length()-1); // cut off the end of result
        }
    }
}
