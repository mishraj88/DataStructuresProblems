import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jmishra on 03-07-2017.
 */
public class AnagramStrings {

    private static final int NUMBER_CHARACTERS =26;

    public static void main(String args[]) throws Exception{
        System.out.println("Enter two strings to be compared for anagrams");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        /**
         * For anagrams we might need to find the number of characters to be deleted from the two strings
         * so that finally both these strings are left with the same characters and are finally of same
         * length. They might still have different orders of characters
         */
        int charCountToDelete = countToDelete(first, second);

        System.out.println("charCount to delete from two string: \""+first+"\" and \""+second+"\" is: "
                +charCountToDelete);

    }

    private static int countToDelete(String first, String second) {
        int[] charCount1 = countChars(first);
        int[] charCount2 = countChars(second);
        int delta = countCharDiffs(charCount1, charCount2);
        return delta;
    }

    private static int[] countChars(String string) {
        int[] charCount = new int[NUMBER_CHARACTERS];
        for(int i=0; i<string.length(); i++){
            int code = (int) string.charAt(i);
            int offset = (int) 'a';
            int charCodePositionInArray = code - offset;
            charCount[charCodePositionInArray]++;
        }
        return charCount;

    }

    /**
     * We have to calculate the absolute character count difference for each of the
     * characters present in the two input arrays. Now each character counts in the English alphabet
     * (small letters only) are present at their respective indices with offset being set at 'a'

     */

    private static int countCharDiffs(int[] array1, int[] array2){
        int delta=0;
        if(array1.length != array2.length){
            return -1;
        }

        for(int i=0; i< array1.length; i++){
            int diff = Math.abs(array1[i]-array2[i]);
            delta = delta + diff;
            array1[i]=array2[i]=diff;
        }
        getCharPrinted(array1);

        return delta;

    }

    private static void getCharPrinted(int[] array1) {

        for(int i=0; i< array1.length; i++){
            //int charCode = array1[i] -
             System.out.print(array1[i]);

        }
        System.out.println();
    }
}
