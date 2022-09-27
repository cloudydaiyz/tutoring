public class ArrayMap {

    private Object[][] kvPairs;
    private int size;

    public ArrayMap(Object[][] pairs, int sz){
        kvPairs = pairs;
        size = sz;
    }

    // go through the list of keys given
        // grab the current key to remove
        // go through the list keys in our ArrayMap (kvPairs[0])
            // compare the current key to remove to the current key in the map, if they’re equal:
            // store the index and END LOOP

        // start at position AFTER where we saw the keys were equal and go through list
            // shift each element in kvPairs[0] and kvPairs[1] 1 unit to the left

        // decrement the size

    public void removeAll(Object[] keys){
        // go through the list of keys given
        for(int i = 0; i < keys.length; i++){
            // grab the current key to remove
            Object keyToRemove = keys[i];
            boolean endLoop = false;
            int startIndex = -1;

            // go through the list keys in our ArrayMap (kvPairs[0])
            for(int j = 0; j < size && !endLoop; j++){
                // compare the current key to remove to the current key in the map, if they’re equal:
                if(kvPairs[0][j].equals(keyToRemove)){
                    // store the index and END LOOP
                    startIndex = j;
                    endLoop = true;
                }
            }

            // IF we have something to remove
            if(endLoop){
                // start at position AFTER where we saw the keys were equal and go through list
                for(int j = startIndex + 1; j < size; j++) {
                    // shift each element in kvPairs[0] and kvPairs[1] 1 unit to the left
                    kvPairs[0][j - 1] = kvPairs[0][j]; // shifting keys
                    kvPairs[1][j - 1] = kvPairs[1][j]; // shifting values

                    // set previous values equal to NULL
                    kvPairs[0][j] = null;
                    kvPairs[1][j] = null;
                }
                // decrement the size
                size--;
            }
        }
    }

    // go through the list of keys given
        // grab the current key to remove
        // go through the list keys in our ArrayMap (kvPairs[0])
            // compare the current key to remove to the current key in the map, if they’re equal:
                // set the key and value equal to null
                // decrement the size
                // END LOOPS

    // make a variable indicating the # of items to shift ( = to the new size)
    // make a variable indicating the # of units for shifting, starting at 0
    // make a variable indicating the current index in the list, starting at 0
    // while the # of items to shift is greater than 0
        // if the current element is null
            // increment the # of units for shifting
        // otherwise
            // shift the current index to the left by the # of units for shifting
            // decrement the # of items to shift

    public void removeAll_AltSolution(Object[] keys){
        // go through the list of keys given
        for(int i = 0; i < keys.length; i++){
            // grab the current key to remove
            Object keyToRemove = keys[i];
            boolean endLoop = false;
            // go through the list keys in our ArrayMap (kvPairs[0])
            for(int j = 0; j < kvPairs[0].length && !endLoop; j++){
                // compare the current key to remove to the current key in the map, if they’re equal:
                if(kvPairs[0][j].equals(keyToRemove)){
                    kvPairs[0][j] = null; // set the key and value equal to null
                    kvPairs[1][j] = null; // set the key and value equal to null
                    size--; // decrement the size
                    endLoop = true; // END LOOPS
                }
            }
        }

        int itemsToShift = size; // make a variable indicating the # of items to shift ( = to the new size)
        int shiftUnit = 0; // make a variable indicating the # of units for shifting, starting at 0
        int index = 0; // make a variable indicating the current index in the list, starting at 0

        // while the # of items to shift is greater than 0
        while(itemsToShift > 0){
            // if the current element is null
            if(kvPairs[0][index] == null){
                // increment the # of units for shifting
                shiftUnit++;
            }
            // otherwise
            else {
                // shift the current index to the left by the # of units for shifting
                kvPairs[0][index - shiftUnit] = kvPairs[0][index];
                kvPairs[1][index - shiftUnit] = kvPairs[1][index];
                // decrement the # of items to shift
                itemsToShift--;
            }
            index++;
        }
    }

    /* Print the contents of the ArrayMap visible to the user */
    public void printList(){
        System.out.print("{");
        for(int i = 0; i < size; i++){
            if(kvPairs[0][i] == null){
                System.out.print("{null, null}");
            } else {
                System.out.print("{" + kvPairs[0][i].toString()
                        + ", " + kvPairs[1][i].toString() + "}");
            }

            if(i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    /* Print ALL the contents of the ArrayMap */
    public void printRawList(){
        System.out.print("{");
        for(int i = 0; i < kvPairs[0].length; i++){
            if(kvPairs[0][i] == null){
                System.out.print("{null, null}");
            } else {
                System.out.print("{" + kvPairs[0][i].toString()
                + ", " + kvPairs[1][i].toString() + "}");
            }

            if(i < kvPairs[0].length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args){
        Object[][] testArr = { {"blah", "bonk", "BAM", null, null, null},
                {3, 2, 4, null, null, null}};

        // Testing the first solution
        ArrayMap testMap = new ArrayMap(testArr, 3);

        System.out.println("FIRST SOLUTION:");
        testMap.printList();
        testMap.printRawList();

        Object[] keys = {"blah"};
        testMap.removeAll(keys);
        testMap.printList();
        testMap.printRawList();

        // Testing the second solution
        testMap = new ArrayMap(testArr, 3);

        System.out.println("SECOND SOLUTION:");
        testMap.printList();
        testMap.printRawList();

        testMap.removeAll_AltSolution(keys);
        testMap.printList();
        testMap.printRawList();
    }
}
