package Huffman;

import java.util.PriorityQueue;

public class HuffmanDecoder {

    public static String huffmanDecode(String S, String test){

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        HuffmanNode root = buildTree(charFreqs);

        //System.out.println(root.toString());

        StringBuilder output = new StringBuilder();
        HuffmanNode base = root;
        //System.out.println(base.toString());
        while (!S.isEmpty()){
            if (S.charAt(0) == '0'){
                base = base.right;
                S = S.substring(1);
            }
            else {
                base = base.left;
                S = S.substring(1);
            }
            if (base.left == null && base.right == null){
                output.append(base.data);
                base = root;
            }

        }
        return output.toString();
    }


    public static HuffmanNode buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanNode> trees = new PriorityQueue<HuffmanNode>();

        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanNode(charFreqs[i], (char) i, null, null));
        }

        assert trees.size() > 0;

        while (trees.size() > 1) {

            // two trees with least frequency
            HuffmanNode a = trees.poll();
            HuffmanNode b = trees.poll();


            // put into new node and re-insert into queue
            if(a.data < b.data){
                trees.offer(new HuffmanNode(a.frequency + b.frequency, a.data, a, b));
            } else {
                trees.offer(new HuffmanNode(a.frequency + b.frequency, b.data, a, b));
            }

        }
        HuffmanNode test = trees.poll();
        return test;
    }
}
