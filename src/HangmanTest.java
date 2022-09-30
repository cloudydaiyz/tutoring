public class HangmanTest {
    // precondition: letterList.length == 26
    public static void printLetterList(boolean[] letterList){
        String totalString = "[";
        int numLetters = 0;
        for(int i = 0; i < letterList.length; i++){
            if(letterList[i]){
                if(numLetters > 0){
                    totalString += ", ";
                }
                totalString += (char)('a' + i);
                numLetters++;
            }
        }
        totalString += "]";
        System.out.println(totalString);
    }

    public static void main(String[] args){
        boolean[] letterList = {false, true, false, true, true, false, true, false};
        printLetterList(letterList);
    }
}
