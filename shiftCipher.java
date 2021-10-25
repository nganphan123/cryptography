package A1;

import java.util.HashMap;
import java.util.Map;

class shiftCipher{
    public static void main(String[] args) {
        String s = "kprrxcthhpktaxkth";
        //a)
        decrypt(s);
        //Correct answer: vaccinessavelives

        //b)
        System.out.println(findRelFreq("vaccinessavelives").toString());


    }

    public static Map<Character,Double> findRelFreq(String s){
        Map<Character,Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!freq.containsKey(c)){
                freq.put(c, 0);
            }
            freq.put(c, freq.get(c)+1);
        }

        Map<Character,Double> relFreq = new HashMap<>();
        for(char k : freq.keySet()){
            relFreq.put(k, (double)freq.get(k)/s.length());
        }
        return relFreq;
    }

    public static void decrypt(String ciphertext){
        String possibleText = "";
        for(int k = 0; k<=25; k++){
            for(char c : ciphertext.toCharArray()){
                possibleText+=(char)('a'+findModulo(c-k, 26));
            }
            System.out.println(possibleText);
            possibleText="";
        }
    }

    public static int findModulo(int a, int n){
        return ((a%n)+n)%n;
    }

}