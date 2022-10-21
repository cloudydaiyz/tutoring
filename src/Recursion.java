public class Recursion {
    static int count1 = 0;

    public static int recC1(int x) {
        count1++;
        if(x <= 1) {
            return count1;
        }
        return 1 + recC1(x-1) + recC1(x - 2);
    }

    public static int recC2(int x, int count) {
        count++;
        if(x <= 1) {
            return count;
        }
        return 1 + recC2(x-1, count) + recC2(x - 2, count);
    }

    // public ArrayList<String> listMnemonics(String number)
    // private void recursiveMnemonics(ArrayList<String> result, String mnemonicSoFar, String digitsLeft)
    // public String digitLetters(char ch)

    /*
        23 = [ad, ae, af, bd, be, bf, cd, ce, cf]
        2 = [a, b, c] = “abc”
        3 = [d, e, f] = “def”
        4 = [g, h, i] = "ghi"

        3

        recursiveMnemonics(result, "", "23")
        recursiveMnemonics(result, "a", "3")
        recursiveMnemonics(result, "ad", "")

        recursiveMnemonics(result, "", "234")
        recursiveMnemonics(result, "a", "34")
        recursiveMnemonics(result, "ad", "4")
        recursiveMnemonics(result, "adg", "") -> ADD TO THE LIST
        recursiveMnemonics(result, "adh", "") -> ADD TO THE LIST
        recursiveMnemonics(result, "adi", "") -> ADD TO THE LIST

        public static void recursiveMnemonics(result, mnemonicSoFar, digitsLeft){
            4. If digitsLeft is empty, add it to the list of results and end the method
            if(digitsLeft is empty) {
                add it to the list
            }
            else {
                1. Get the letters of the number in front of digitsLeft
                String letters = digitLetters()
                loop through each letter {
                    2. Add it to our current mnemonic
                    3. Continue recursing to the next number
                    recursiveMnemonics(result, mnemonicSoFar + letter, digitsLeft with the beginning cut off)
                }
            }
        }

        1. Get the letters of the number in front of digitsLeft
            For each of the letters,
            2. Add it to our current mnemonic
                3. Continue recursing to the next number
                4. If digitsLeft is empty, add it to the list of results and end the method
     */

    public static void main(String[] args){
        recC1(5);
        System.out.println(count1);

        int count2 = recC2(5, 0);
        System.out.println(count2);
    }
}
