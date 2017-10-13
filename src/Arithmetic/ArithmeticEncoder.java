package Arithmetic;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ArithmeticEncoder {

    static double tag;

    public static String arithmeticEncode(String text){
        ArrayList<Element> elements = new ArrayList();
        int[] charFrequencies = new int[256];
        String code = "";


        for (char c : text.toCharArray()){
            charFrequencies[c]++;
        }
        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i]>0){
                elements.add(new Element((char) i, (double) charFrequencies[i] / text.length()));
            }
        }



        elements.get(0).setLow(0);
        elements.get(0).setHigh(elements.get(0).getProbability());
        for (int i = 1; i < elements.size(); i++) {
            elements.get(i).setHigh(elements.get(i-1).getHigh() + elements.get(i).getProbability());
            elements.get(i).setLow(elements.get(i - 1).getHigh());
        }


        double base = 0, top = 1, baseCopy, range, p1, p2;


        for(int i = 0; i<text.length(); i++){
            p1 = findCharLow(text.charAt(i), elements);
            p2 = findCharHigh(text.charAt(i), elements);

            baseCopy = base;

            range = top - base;

            base = range * p1 + baseCopy;
            top = range * p2 + baseCopy;
        }

        tag = base;

        double binaryBase = convertProbabilitytoBinary(base);

        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(16);


        if(elements.size() == 1){
            for(int i = 0; i<text.length(); i++){
                code = code + "0";
            }
        } else {
            code = df.format(binaryBase) + "";
            code = code.substring(1);
        }


        return code;
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

    public static double findCharLow(char c, ArrayList<Element> elements){
        for (int i = 0; i<elements.size(); i++){
            if(c==elements.get(i).getValue()){
                return elements.get(i).getLow();
            }
        }
        return 0;
    }

    public static double findCharHigh(char c, ArrayList<Element> elements){
        for (int i = 0; i<elements.size(); i++){
            if(c==elements.get(i).getValue()){
                return elements.get(i).getHigh();
            }
        }
        return 0;
    }


}
