package Arithmetic;

import java.util.ArrayList;

public class ArithmeticDecoder {

    public static String arithmeticDecode(String test, ArrayList<Integer> frequencies, ArrayList<String> chars){
        double decimalCode = convertBinaryFractiontoDecimal(Long.parseLong(test), test.length());
        StringBuffer word = new StringBuffer();

        ArrayList<Double> probabilities = new ArrayList<>();
        ArrayList<String> characters = new ArrayList<>();
        ArrayList<Integer> freqs = new ArrayList<>();

        int total = 0;
        for(int i = 0; i < frequencies.size(); i++){
            total = frequencies.get(i) + total;
        }

        boolean ok;
        for(int i = 0; i < chars.size(); i++){
            ok = true;
            for(int j = 0; j< characters.size(); j++){
                if(characters.get(j).equals(chars.get(i))){
                    freqs.set(j, freqs.get(j) + frequencies.get(i));
                    ok = false;
                    j = characters.size();
                }
            }
            if(ok){
                characters.add(chars.get(i));
                freqs.add(frequencies.get(i));
            }
        }

        for(int i = 0; i < freqs.size(); i++){
            probabilities.add((freqs.get(i)*1.0/total));
        }

        ArrayList<Element> elements = new ArrayList();


        for (int i = 0; i < characters.size(); i++) {
            elements.add(new Element((char) characters.get(i).charAt(0), (double) probabilities.get(i)));
        }

        elements.get(0).setLow(0);
        elements.get(0).setHigh(elements.get(0).getProbability());
        for (int i = 1; i < elements.size(); i++) {
            elements.get(i).setHigh(elements.get(i-1).getHigh() + elements.get(i).getProbability());
            elements.get(i).setLow(elements.get(i - 1).getHigh());
        }

        double base = 0, top = 1, baseCopy, range, p1, p2, low, high;

        for(int i = 0; i<total; i++){
            low = base;
            high = top;

            for(int j = 0; j < elements.size(); j++){
                base = low;
                top = high;

                p1 = findCharLow(elements.get(j).getValue(), elements);
                p2 = findCharHigh(elements.get(j).getValue(), elements);

                baseCopy = base;

                range = top - base;

                base = range * p1 + baseCopy;
                top = range * p2 + baseCopy;
                if(decimalCode >= base && decimalCode < top){
                    word.append(elements.get(j).getValue());
                    j = elements.size();
                }

            }
        }
        return word.toString();
    }

    private static double convertBinaryFractiontoDecimal(long binaryCode, int length){
        double x = 0;
        while(binaryCode > 0){
            x = x + (binaryCode%10)/Math.pow(2,length);
            length --;
            binaryCode = binaryCode/10;
        }
        return ArithmeticEncoder.tag;
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