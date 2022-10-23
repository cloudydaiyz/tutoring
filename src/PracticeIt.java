import java.util.Iterator;
import java.util.LinkedList;

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

    boolean searchLinkedListForDuplicates(){
        LinkedList<Object> ll = new LinkedList<>();
        for(Object currentElement : ll){
            for(Object elementToCheck : ll){
                if(currentElement.equals(elementToCheck)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean searchLinkedListForDuplicatesBestCase() {
        LinkedList<Object> ll = new LinkedList<>();
        ll.sort(null); // uses mergesort which is O(nlogn)

        Iterator<Object> it = ll.iterator();
        Object prevElement = null;
        if(it.hasNext()){
            prevElement = it.next();
        }

        while(it.hasNext()){
            Object currentElement = it.next();
            if(prevElement.equals(currentElement)){
                return true;
            }
            prevElement = currentElement;
        }

        return false;
    }
}
