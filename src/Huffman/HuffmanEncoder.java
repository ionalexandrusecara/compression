package Huffman;

import java.util.PriorityQueue;

public class HuffmanEncoder {
    public static void main(String[] args){
        //String test = "aaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbccccccccccddddddddeeeeeeee";
        String test = "aaaabcdeef";

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        HuffmanNode top = buildTree(charFreqs);
        System.out.println(top.toString());

        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        printCodes(top, new StringBuffer());
        System.out.println("________________");
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

        // loop until there is only one tree left
        /*System.out.println("---");
        Iterator it = trees.iterator();
        System.out.println("Priority queue values are: ");
        while(it.hasNext()){
            HuffmanNode acopy = (HuffmanNode) it.next();
            System.out.println("Value: " + acopy.data + " " + acopy.frequency);
        }*/

        int i =1;

        while (trees.size() > 1) {

            // two trees with least frequency
            HuffmanNode a = trees.poll();
            HuffmanNode b = trees.poll();

            System.out.println(i + " : " + a.frequency + " : " + a.data);
            System.out.println(i + " : " + b.frequency + " : " + b.data);
            i++;

            // put into new node and re-insert into queue
            if(a.data < b.data){
                trees.offer(new HuffmanNode(a.frequency + b.frequency, a.data, a, b));
                //System.out.println(i + " : " + a.frequency + " : " + b.frequency + " : " + a.data);
            } else {
                trees.offer(new HuffmanNode(a.frequency + b.frequency, b.data, a, b));
                //System.out.println(i + " : " + a.frequency + " : " + b.frequency + " : " + b.data);
            }
        }
        return trees.poll();
    }


    public static void printCodes(HuffmanNode top, StringBuffer prefix) {
        assert top != null;
        //System.out.println(top.toString());
        //System.out.println(top.left);
        if (top.left == null && top.right==null) {
            //System.out.println("Leaf");
            //Leaf leaf = (Leaf)top;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(top.data + "\t" + top.frequency + "\t" + prefix);

        } else {
            //System.out.println("Not Leaf");
            //Node node = (Node)top;
            /*System.out.println("1: " + node.left.frequency);
            System.out.println("2: " + node.right.frequency);*/

            // traverse left
            //System.out.println("Left");
            prefix.append('1');
            printCodes(top.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            //System.out.println("Right");
            prefix.append('0');
            printCodes(top.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
