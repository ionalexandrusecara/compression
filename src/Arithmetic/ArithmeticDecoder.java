package Arithmetic;

import java.util.ArrayList;

public class ArithmeticDecoder {
    public static String arithmeticDecode(String test, ArrayList<Integer> frequencies, ArrayList<String> chars){
        int n = chars.size(), x;
        //String test = "001011";
        System.out.println("test: " + test);
        double decimalCode = convertBinaryFractiontoDecimal(Long.parseLong(test), test.length());
        String word = "";

        ArrayList<Double> probabilities = new ArrayList<>();

        int total = 0;
        for(int i = 0; i < frequencies.size(); i++){
            total = frequencies.get(i) + total;
        }

        for(int i = 0; i < frequencies.size(); i++){
            probabilities.add((double)(frequencies.get(i)/total));
        }

        int j;

        double base = 0, top = 1, lInterval, hInterval;
        j =0;

        for(int i = 0; i<n;i++){
            lInterval = base;

            x = 0;
            while(lInterval<decimalCode && x < n){
                lInterval = top * probabilities.get(x);
                x++;
            }

            hInterval = lInterval;

            word = word + chars.get(j);
            base = lInterval;
            top = hInterval;

            j++;

        }

        return word;


    }

    private static double convertBinaryFractiontoDecimal(long binaryCode, int length){
        double x = 0;
        while(binaryCode > 0){
            x = x + (binaryCode%10)/Math.pow(2,length);
            length --;
            binaryCode = binaryCode/10;
        }
        return x;
    }
}
