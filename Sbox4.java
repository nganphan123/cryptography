package A2;

import java.util.Arrays;

//Special Sbox
public class Sbox4{
    public static void main(String[] args) {
        int [] row = {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15};
        // checkCase2(row);
        checkCase1(row);
        System.out.println(Arrays.toString(row));
    }

    public static void checkCase1(int [] row){
        // int [] result = new int[row.length];
        for(int i = 0; i<row.length; i++){
            int newNum = 0;
            newNum = newNum | ((row[i]&8)>>1);
            newNum = newNum | ((row[i]&4)<<1);
            newNum = newNum | ((row[i]&2)>>1);
            newNum = newNum | ((row[i]&1)<<1);
            row [i] = newNum ^ 6;
        }
       
    }

    public static void checkCase2(int[] row){
        // int[] result = new int [row.length];
        for(int i = 0; i<4; i++){
            //swap the first 8 items
            int temp = row[i];
            row[i] = row[7-i];
            row[7-i] = temp;

            //swap the last items
            temp = row[7+i+1];
            row[7+i+1] = row[row.length-i-1];
            row[row.length-i-1] = temp;
        }


        for(int i = 0; i < row.length; i++){
            int newNum = 0;
            newNum = newNum | ((row[i]&8)>>2);
            newNum = newNum | ((row[i]&4)>>2);
            newNum = newNum | ((row[i]&2)<<2);
            newNum = newNum | ((row[i]&1)<<2);
            row[i] = newNum;
        }
    }

}