package Arithmetic;

import java.util.ArrayList;

public class ArithmeticEncoder {

    public static void main(String[] args){
        ArrayList<Element> elements = new ArrayList();
        String test = "aabe";
        String code;
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray()){
            charFreqs[c]++;
        }

        for (int i = 0; i < test.length(); i++) {
            elements.add(new Element(test.charAt(i), (double) charFreqs[test.charAt(i)] / test.length()));
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
