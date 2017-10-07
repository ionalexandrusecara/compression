package Arithmetic;

import java.util.ArrayList;

public class ArithmeticDecoder {
    public static void main(String[] args){
        ArrayList<Element> elements = new ArrayList();
        String test = "001011";
        ArrayList<Double> probabilities = new ArrayList<Double>();
        probabilities.add(0.5);
        probabilities.add(0.25);
        probabilities.add(0.25);

        double base = 0, top = 1;

        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(0,0.5));
        intervals.add(new Interval(0.5, 0.75));
        intervals.add(new Interval(0.75, 1));
        ArrayList<Interval> binaryIntervals = new ArrayList<Interval>();
        binaryIntervals.add(new Interval(convertProbabilitytoBinary(0), convertProbabilitytoBinary(0.5)));
        binaryIntervals.add(new Interval(convertProbabilitytoBinary(0.5), convertProbabilitytoBinary(0.75)));
        binaryIntervals.add(new Interval(convertProbabilitytoBinary(0.75), convertProbabilitytoBinary(1)));


    }

    public static double convertProbabilitytoBinary(double probability){
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
}
