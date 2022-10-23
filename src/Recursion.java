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

    public static void main(String[] args){
        recC1(5);
        System.out.println(count1);

        int count2 = recC2(5, 0);
        System.out.println(count2);
    }
}
