package A1;

import java.util.HashMap;

//Chosen plaintext attack
public class HillCipher {
    public static void main(String[] args) {
        int[][] k1 = {{1,5},{4,3}};
        int[][] k2 = {{7,11},{3,8}};
        String p = "ciphertext";
        System.out.println(encrypt(k1, k2, p));
    }

    public static String encrypt(int[][] k1, int[][] k2, String p){
        String result = "";
        
        HashMap<Character,Integer> alphaMap = new HashMap<>();
        for(int i = 0; i <= 25; i++){
            alphaMap.put((char)('a' + i), i);
        }

        if(p.length() % 2 != 0){
            p += 'x';
        }

        int keyNum = 0;
        for(int i = 0; i<p.length()-1; i+=2){
            int[][] key;
            if(keyNum % 2 == 0){
                key = k1;
            }
            else{
                key = k2;
            }
            //encrypt
            //first letter
            // result += findModulo(alphaMap.get(p.charAt(i))*key[0][0] + alphaMap.get(p.charAt(i+1))*key[1][0],26);
            result += (char)('a' + findModulo(alphaMap.get(p.charAt(i))*key[0][0] + alphaMap.get(p.charAt(i+1))*key[1][0],26));
          
           
            //second letter
            result += (char)('a' + findModulo(alphaMap.get(p.charAt(i))*key[0][1] + alphaMap.get(p.charAt(i+1))*key[1][1],26));
           
            keyNum++;
        }

        return result;
    }

    public static int findModulo(int a, int n){
        return ((a%n)+n)%n;
    }
}
