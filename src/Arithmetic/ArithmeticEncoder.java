package Arithmetic;

import java.util.ArrayList;

public class ArithmeticEncoder {

    public static String arithmeticEncode(String text){
        ArrayList<Element> elements = new ArrayList();

        String code;
        int[] charFreqs = new int[256];


        for (char c : text.toCharArray()){
            charFreqs[c]++;
        }

        for (int i = 0; i < text.length(); i++) {
            elements.add(new Element(text.charAt(i), (double) charFreqs[text.charAt(i)] / text.length()));
        }

        double base = 0, top = 1, baseCopy, topCopy;

        for(int i = 0; i<elements.size();i++){
            baseCopy = base;
            topCopy = top;
            if(i>1){
                base = baseCopy + (topCopy-baseCopy) * elements.get(i-1).getProbability();
            } else {
                base = 0;
            }

            top = base + (topCopy-baseCopy) * elements.get(i).getProbability();

            elements.get(i).setInterval(base, top);
        }

        for(Element element: elements){
            element.setLowBinary(convertProbabilitytoBinary(element.getLow()));
            element.setHighBinary(convertProbabilitytoBinary(element.getHigh()));
        }

        code = elements.get(elements.size()-1).getLowBinary() + "";
        code = code.substring(2);
        System.out.println(code);
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


}
