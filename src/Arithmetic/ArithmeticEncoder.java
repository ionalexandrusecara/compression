package Arithmetic;

import java.util.ArrayList;

public class ArithmeticEncoder {

    public static void main(String[] args){
        ArrayList<Element> elements = new ArrayList();
        String test = "aabe";
        String code;
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        int j = 0;
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0){
                if(j==0) {
                    elements.add(new Element((char) i, (double) charFreqs[i] / test.length()));
                    j++;
                } else {
                    elements.add(new Element((char) i, (double) charFreqs[i] / test.length() + elements.get(j-1).getProbability()));
                    j++;
                }
            }
        }

        double base = 0, top = elements.get(0).getProbability()/2, baseCopy, topCopy;
        elements.get(0).setInterval(base, top);

        for(int i = 1; i<elements.size();i++){
            baseCopy = base;
            topCopy = top;

            base = baseCopy + (topCopy-baseCopy) * elements.get(i-1).getProbability();
            top = baseCopy + (topCopy-baseCopy) * elements.get(i).getProbability();

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
