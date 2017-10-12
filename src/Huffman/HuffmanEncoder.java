package Huffman;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanEncoder {

    public static ArrayList<HuffmanNode> codes = new ArrayList<HuffmanNode>();

    public static String huffmanEncode(String message){
        int[] charFreqs = new int[256];
        codes = new ArrayList<HuffmanNode>();

        //count frequencies of each source symbol
        for (char c : message.toCharArray())
            charFreqs[c]++;

        HuffmanNode top = buildTree(charFreqs);
        //System.out.println(top.toString());

        printCodes(top, new StringBuffer());

        /*for(int i = 0; i < codes.size(); i++){
            System.out.println(codes.get(i).data + " : " + codes.get(i).code);
        }*/

        return encode(message);
    }

    //Build Tree
    public static HuffmanNode buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanNode> trees = new PriorityQueue<HuffmanNode>();
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
                trees.offer(new HuffmanNode(charFreqs[i], (char) i, null, null));
            }
        }

        assert trees.size() > 0;

        while (trees.size() > 1) {
            HuffmanNode a = trees.poll();
            HuffmanNode b = trees.poll();

            if(a.data < b.data){
                trees.offer(new HuffmanNode(a.frequency + b.frequency, a.data, a, b));
            } else {
                trees.offer(new HuffmanNode(a.frequency + b.frequency, b.data, a, b));
            }
        }
        return trees.poll();
    }


    public static void printCodes(HuffmanNode top, StringBuffer prefix) {
        assert top != null;

        if (top.left == null && top.right==null) {
            codes.add(new HuffmanNode(top.frequency, top.data, null, null));
            codes.get(codes.size()-1).code = prefix.toString();
        } else {
            // move left
            prefix.append('1');
            printCodes(top.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // move right
            prefix.append('0');
            printCodes(top.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static String encode(String text){
        StringBuffer encodedText = new StringBuffer();
        for(int i = 0; i < text.length(); i++){
            for(int j = 0; j < codes.size(); j++){
                if(text.charAt(i) == codes.get(j).data){
                    encodedText.append(codes.get(j).code);
                }
            }
        }
        return encodedText.toString();
    }


}
