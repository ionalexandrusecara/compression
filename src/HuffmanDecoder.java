public class HuffmanDecoder {

    public static void main(String[] args){
        //String test = "aaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbccccccccccddddddddeeeeeeee";
        String test = "0100";

        int[] charFreqs = new int[256];
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        decode(test, (Node)HuffmanEncoder.buildTree(charFreqs));
    }

    /*public static void decode(String S, Node root)
    {
        StringBuilder sb = new StringBuilder();
        Node c = root;
        for (int i = 0; i < S.length(); i++) {
            System.out.println(i);
            c = (Node) (S.charAt(i) == '1' ? c.right : c.left);
            if (c.left == null && c.right == null) {
                sb.append(c.value);
                c = root;
            }
        }
        System.out.print(sb);
    }*/

    public static void decode(String S ,Node root)
    {
        if (root == null) return;
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        Node current = root;
        char[] chars = S.toCharArray();
        while (pos < chars.length) {
            char c = chars[pos];
            if (c == '0' && current.left != null) {
                current = (Node)current.left;
            }
            else if (c == '1' && current.right != null) {
                current = (Node)current.right;
            }
            if (current.left == null && current.right == null) {
                sb.append(current.value);
                current = root;
            }
            pos++;
        }
        System.out.print(sb.toString());
    }
}
