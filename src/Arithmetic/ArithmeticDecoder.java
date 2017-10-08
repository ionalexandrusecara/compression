package Arithmetic;

import java.util.ArrayList;

public class ArithmeticDecoder {
    public static void main(String[] args){
        int n = 4, x;
        String test = "001011";
        double decimalCode = convertBinaryFractiontoDecimal(Integer.parseInt(test), test.length());
        String word = "";

        ArrayList<Double> probabilities = new ArrayList<Double>();
        ArrayList<String> letters = new ArrayList<String>();
        probabilities.add(0.5);
        probabilities.add(0.5);
        probabilities.add(0.75);
        probabilities.add(1.0);

        letters.add("a");
        letters.add("a");
        letters.add("b");
        letters.add("e");



        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(0,0.5));
        intervals.add(new Interval(0.5, 0.75));
        intervals.add(new Interval(0.75, 1));
        ArrayList<Interval> binaryIntervals = new ArrayList<Interval>();
        binaryIntervals.add(new Interval(convertProbabilitytoBinary(0), convertProbabilitytoBinary(0.5)));
        binaryIntervals.add(new Interval(convertProbabilitytoBinary(0.5), convertProbabilitytoBinary(0.75)));
        binaryIntervals.add(new Interval(convertProbabilitytoBinary(0.75), convertProbabilitytoBinary(1)));


        int j;

        double base = 0, top = 1, baseCopy, topCopy, lInterval, hInterval;
        j =0;

        for(int i = 0; i<n;i++){
            lInterval = base;
            //hInterval = top;

            x = 0;
            while(lInterval<decimalCode && x < n){
                lInterval = top * probabilities.get(x);
                x++;
            }

            hInterval = lInterval;

            word = word + letters.get(j);
            base = lInterval;
            top = hInterval;

            j++;

        }

        System.out.println(word);


    }

    private static double convertProbabilitytoBinary(double probability){
        StringBuffer binary = new StringBuffer();
        binary.append("0.");
        while(probability!=1){
            probability = probability * 2;
            if(probability == 0){
                return 0;
            } else if(probability<1){
                binary.append(0);
            } else if(probability > 1){
                binary.append(1);
                probability = probability - 1;
            } else {
                binary.append("1");
            }
        }
        return Double.parseDouble(binary.toString());
    }

    private static double convertBinaryFractiontoDecimal(int binaryCode, int length){
        double x = 0;
        while(binaryCode > 0){
            x = x + (binaryCode%10)/Math.pow(2,length);
            length --;
            binaryCode = binaryCode/10;
        }
        return x;
    }
}
