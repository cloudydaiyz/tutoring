import java.util.Set;
import java.util.List;

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
    public class Position {
        public int row, col;
        public Position(int r, int c){
            row = r;
            col = c;
        }
    }
    private static final int[][] KNIGHT_DIRECTIONS = {{2, 1}, {2, -1},
            {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    /*
        Base cases
        - Knight col = Target col, Knight row = Target row => RETURN TRUE
        - numMoves == 0, RETURN FALSE
        - Bound check, RETURN FALSE if out of bounds

        Recursion
        - Boolean canReach = false
        - Call method again with each of the knight directions
        - Return canReach
     */
    public boolean knightCanReach(int rows, Position knight, Position target, int numMoves){
        // Base cases
        // Knight col = Target col, Knight row = Target row => RETURN TRUE
        if(knight.row == target.row && knight.col == target.col){
            return true;
        }
        // numMoves == 0, RETURN FALSE
        else if(numMoves == 0){
            return false;
        }
        // Bound check, RETURN FALSE if out of bounds
        else if(knight.row < 0 || knight.row >= rows || knight.col < 0 || knight.col >= rows){
            return false;
        }

        // Recursion
        for(int i = 0; i < KNIGHT_DIRECTIONS.length; i++){
            // make a new position with knight going in this direction
            Position nextKnightPos = new Position(
                    knight.row + KNIGHT_DIRECTIONS[i][0],
                    knight.col + KNIGHT_DIRECTIONS[i][1]);
            if(knightCanReach(rows, nextKnightPos, target, numMoves - 1)){
                return true;
            }

            // OR we can use recursive backtracking
            // add the knight direction
            knight.row += KNIGHT_DIRECTIONS[i][0];
            knight.col += KNIGHT_DIRECTIONS[i][1];

            if(knightCanReach(rows, knight, target, numMoves - 1)){
                return true;
            }
            // undo what we just did
            knight.row -= KNIGHT_DIRECTIONS[i][0];
            knight.col -= KNIGHT_DIRECTIONS[i][1];
        }
        return false;
    }

    // Generally, recursive algorithms tend to be O(2^N) OR O(N!)
    // In this case, the recursive algorithm is O(N!)

    // camp => amp, cmp, cap, cam (4 POSSIBILITIES)
    // amp => mp, ap, am (3 POSSIBILITIES)
    // mp => m, p (2 POSSIBILITIES)
    // m => "" (1 POSSIBILITY)
    // 4 * 3 * 2 * 1 = 4! TIMES

    // computer => omputer, cmputer, ... (8 POSSIBILITIES)
    // omputer => mputer, oputer, ... (7 POSSIBILITIES)
    // ...
    // 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 = 8! TIMES
    public static void findWords(String word, Set<String> d,
                                 List<String> results) {
        // Check if the word is empty
        if(word.length() == 0){
            return;
        }

        // Check if word itself is a valid word (if it's in d AND not already in results)
        if(d.contains(word) && !results.contains(word)) {
            // If it is, then add it to results
            results.add(word);
        }

        // computer => muter
        // computer -> omputer -> mputer -> muter
        // computer -> cmputer -> mputer -> muter
        // computer -> comuter -> cmuter -> muter

        // Go through each letter in word
        for(int i = 0; i < word.length(); i++){
            // Remove the letter from the word (KEEPING THE SAME ORDER)
            String resultingWord = word.substring(0, i) // everything BEFORE the current index
                    + word.substring(i + 1); // everything AFTER the current index

            /* VISUALIZATION for removing each word */
            // Let's say we wanted to find the resulting word from removing m
            // [c, o, m, p, u, t, e, r]
            //        ^
            //        i

            // We want to take everything before i (which would be m) and after i
            // and then MASH 'em together!
            // [c, o] + [p, u, t, e, r]
            //  ^  ^     ^
            //  0  i-1   i+1

            // Do the same test with the resulting word
            findWords(resultingWord, d, results);
        }
    }

    public int waysToRoll(int numToRoll, int numDice){
        if(numToRoll == 0 && numDice == 0){
            return 1;
        }

        // Let's think of each case, where our target numToRoll is 3.
        // target: 3, first dice roll is 6
            // waysToRoll(numToRoll = -3, numDice = 1)
            // We OVERSHOT our target numToRoll
        // target: 3, first dice roll is 1, and the second dice roll is 1
            // waysToRoll(numToRoll = 1, numDice = -1)
            // We UNDERSHOT our target numToRoll!
        // target: 3, first dice roll is 3
            // waysToRoll(numToRoll = 0, numDice = 1)
            // We HIT our target, but we still have another dice left :( So close!

        if(numToRoll > 0 && numDice > 0){
            int sum = 0;
            for(int i = 1; i <= 6; i++){
                sum += waysToRoll(numToRoll - i, numDice - 1);
            }
            return sum;
        }

        return 0;
    }

    public int sizeOfPlantArea(int[][] mat, int row, int col){
        // Make a new visited boolean matrix with same dimensions as mat
        // # of rows = mat.length
        // # of cols = mat[0].length
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        return sizeOfPlantArea(visited, mat, row, col);
    }

    public int sizeOfPlantArea(boolean[][] visited, int[][] mat, int row, int col){
        int currentNum = mat[row][col];
        int sum = 1;

        // Mark that you visited this spot
        visited[row][col] = true;

        // Check if we can go in each direction by checking for 3 things:
        // 1.) If that direction is in bounds
        // 2.) If the number in that direction is the same as currentNum
        // 3.) If we've already visited that spot

        // Check if we can go up
        if( row - 1 >= 0 || mat[row - 1][col] == currentNum || !visited[row - 1][col]){
            // Go up in that direction!
            sum += sizeOfPlantArea(visited, mat, row - 1, col);
        }

        // Check if we can go right
        if( col + 1 < mat[0].length || mat[row][col + 1] == currentNum || !visited[row][col + 1]){
            // Go right in that direction!
            sum += sizeOfPlantArea(visited, mat, row, col + 1);
        }

        // Check if we can go down
        if( row + 1 < mat.length || mat[row + 1][col] == currentNum || !visited[row + 1][col]){
            // Go up in that direction!
            sum += sizeOfPlantArea(visited, mat, row + 1, col);
        }

        // Check if we can go left
        if( col - 1 >= 0 || mat[row][col - 1] == currentNum || !visited[row][col - 1]){
            // Go right in that direction!
            sum += sizeOfPlantArea(visited, mat, row, col - 1);
        }

        return sum;
    }

    public static void main(String[] args){
        recC1(5);
        System.out.println(count1);

        int count2 = recC2(5, 0);
        System.out.println(count2);
    }
}
