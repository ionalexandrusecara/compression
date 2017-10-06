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
        Tree tree = buildTree(charFreqs);

        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }

    public static Tree buildTree(int[] charFreqs) {
        PriorityQueue<Tree> trees = new PriorityQueue<Tree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++) {
            //System.out.println(charFreqs[i]);
            if (charFreqs[i] > 0)
                trees.offer(new Leaf(charFreqs[i], (char) i));
        }

        assert trees.size() > 0;
        // loop until there is only one tree left
        /*System.out.println("---");
        Iterator it = trees.iterator();
        System.out.println("Priority queue values are: ");
        while(it.hasNext()){
            Leaf acopy = (Leaf)it.next();
            System.out.println("Value: " + acopy.value + " " + acopy.frequency);
        }*/
        //int i =1;
        while (trees.size() > 1) {

            // two trees with least frequency
            Tree a = trees.poll();
            Tree b = trees.poll();

            //System.out.println(i + " : " + a.frequency + " : " + b.frequency);
            //i++;

            // put into new node and re-insert into queue
            trees.offer(new Node(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(Tree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof Leaf) {
            //System.out.println("Leaf");
            Leaf leaf = (Leaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof Node) {
            //System.out.println("Not Leaf");
            Node node = (Node)tree;
            /*System.out.println("1: " + node.left.frequency);
            System.out.println("2: " + node.right.frequency);*/

            // traverse left
            //System.out.println("Left");
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            //System.out.println("Right");
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }



}
