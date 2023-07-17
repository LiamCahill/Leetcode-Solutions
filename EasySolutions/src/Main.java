import java.util.Dictionary;
import java.util.Hashtable;

/* PROMPT
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.


 */

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("II"));//2
        System.out.println(sol.romanToInt("VI")); //6
        System.out.println(sol.romanToInt("IX")); //9


    }
}



class Solution {
    public int romanToInt(String s) {
        int total = 0;
        Dictionary<Character, Integer> letters= new Hashtable<>();
        letters.put('I', 1);
        letters.put('V', 5);
        letters.put('X', 10);
        letters.put('L', 50);
        letters.put('C', 100);
        letters.put('D', 500);
        letters.put('M', 1000);

        //System.out.println(letters.get("L"));

        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            char next;

            //Check if next is a valid value.
            if((i+1) > s.length()-1){
                next = 0;
            } else {
                next = s.charAt(i+1);
            }

            //Check for the six cases mentioned in the prompt.
            if(current == 'I' && (next == 'V' || next == 'X')){
                total += next - current;

            } else if(current == 'X' && (next == 'L' || next == 'C')){
                total += next - current;

            } else if(current == 'C' && (next == 'D' || next == 'M')){
                total += next - current;

            }

        }

        return total;

    }


}