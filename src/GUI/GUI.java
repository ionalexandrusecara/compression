package GUI;

import Arithmetic.ArithmeticDecoder;
import Arithmetic.ArithmeticEncoder;
import Huffman.HuffmanDecoder;
import Huffman.HuffmanEncoder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GUI {

    private JFrame frame;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;


    ArrayList<JTextField> sources = new ArrayList<JTextField>();
    ArrayList<JTextField> frequencies = new ArrayList<JTextField>();


    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() { return textField2; }

    public JTextField getTextField3() {
        return textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public JTextField getTextField6() {
        return textField6;
    }

    public JTextField getTextField7() {
        return textField7;
    }

    public JTextField getTextField8() {
        return textField8;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GUI() {
        initialize();
    }



    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();


        frame = new JFrame();
        frame.setBounds(0, 0, screen.width,screen.height - 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(215, 27, 60, 21);
        frame.getContentPane().add(textField1);
        textField1.setColumns(10);



        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(326, 27, 60, 21);
        frame.getContentPane().add(textField2);

        textField3 = new JTextField();
        textField3.setColumns(10);
        textField3.setBounds(440, 27, 60, 21);
        frame.getContentPane().add(textField3);

        textField4 = new JTextField();
        textField4.setColumns(10);
        textField4.setBounds(541, 27, 60, 21);
        frame.getContentPane().add(textField4);

        sources.add(textField1);
        sources.add(textField2);
        sources.add(textField3);
        sources.add(textField4);

        textField5 = new JTextField();
        textField5.setColumns(10);
        textField5.setBounds(215, 78, 60, 21);
        frame.getContentPane().add(textField5);

        textField6 = new JTextField();
        textField6.setColumns(10);
        textField6.setBounds(326, 78, 60, 21);
        frame.getContentPane().add(textField6);

        textField7 = new JTextField();
        textField7.setColumns(10);
        textField7.setBounds(440, 78, 60, 21);
        frame.getContentPane().add(textField7);

        textField8 = new JTextField();
        textField8.setColumns(10);
        textField8.setBounds(541, 78, 60, 21);
        frame.getContentPane().add(textField8);

        frequencies.add(textField5);
        frequencies.add(textField6);
        frequencies.add(textField7);
        frequencies.add(textField8);

        JLabel sourceSymbolsLabel = new JLabel("Source Symbols:");
        sourceSymbolsLabel.setBounds(20, 25, 150, 20);
        frame.getContentPane().add(sourceSymbolsLabel);

        JLabel frequenciesLabel = new JLabel("Probability:");
        frequenciesLabel.setBounds(20, 75, 150, 20);
        frame.getContentPane().add(frequenciesLabel);

        JLabel textLabel = new JLabel("Text:");
        textLabel.setBounds(20, 170, 200, 20);
        frame.getContentPane().add(textLabel);

        JLabel generatedTextLabel = new JLabel("---");
        generatedTextLabel.setBounds(250, 170, 200, 20);
        frame.getContentPane().add(generatedTextLabel);

        JLabel HuffmanEncodingLabel = new JLabel("Huffman Encoding");
        HuffmanEncodingLabel.setBounds(20, 220, 150, 20);
        frame.getContentPane().add(HuffmanEncodingLabel);

        JLabel HuffmanDecodingLabel = new JLabel("Huffman Decoding");
        HuffmanDecodingLabel.setBounds(20, 270, 150, 20);
        frame.getContentPane().add(HuffmanDecodingLabel);

        JLabel HuffmanEncodedText = new JLabel("---");
        HuffmanEncodedText.setBounds(200, 220, 300, 20);
        frame.getContentPane().add(HuffmanEncodedText);

        JLabel HuffmanDecodedText = new JLabel("---");
        HuffmanDecodedText.setBounds(200, 270, 300, 20);
        frame.getContentPane().add(HuffmanDecodedText);

        JLabel ArithmeticEncodingLabel = new JLabel("Arithmetic Encoding");
        ArithmeticEncodingLabel.setBounds(550, 220, 150, 20);
        frame.getContentPane().add(ArithmeticEncodingLabel);

        JLabel ArithmeticDecodingLabel = new JLabel("Arithmetic Decoding");
        ArithmeticDecodingLabel.setBounds(550, 270, 150, 20);
        frame.getContentPane().add(ArithmeticDecodingLabel);

        JLabel ArithmeticEncodedText = new JLabel("---");
        ArithmeticEncodedText.setBounds(730, 220, 300, 20);
        frame.getContentPane().add(ArithmeticEncodedText);

        JLabel ArithmeticDecodedText = new JLabel("---");
        ArithmeticDecodedText.setBounds(730, 270, 300, 20);
        frame.getContentPane().add(ArithmeticDecodedText);

        JLabel statsText = new JLabel("Statistics");
        statsText.setBounds(20, 330, 300, 20);
        frame.getContentPane().add(statsText);

        JLabel originalSizeText = new JLabel("Original Size");
        originalSizeText.setBounds(20, 370, 200, 20);
        frame.getContentPane().add(originalSizeText);

        JLabel originalSize = new JLabel("---");
        originalSize.setBounds(250, 370, 300, 20);
        frame.getContentPane().add(originalSize);

        JLabel HuffmanSizeText = new JLabel("Huffman Size");
        HuffmanSizeText.setBounds(20, 420, 200, 20);
        frame.getContentPane().add(HuffmanSizeText);

        JLabel HuffmanSize = new JLabel("---");
        HuffmanSize.setBounds(250, 420, 300, 20);
        frame.getContentPane().add(HuffmanSize);

        JLabel ArithmeticSizeText = new JLabel("Arithmetic Size");
        ArithmeticSizeText.setBounds(550, 420, 200, 20);
        frame.getContentPane().add(ArithmeticSizeText);

        JLabel ArithmeticSize = new JLabel("---");
        ArithmeticSize.setBounds(730, 420, 300, 20);
        frame.getContentPane().add(ArithmeticSize);

        JLabel HuffmanCompressionRatioText = new JLabel("Huffman Compression Ratio");
        HuffmanCompressionRatioText.setBounds(20, 470, 200, 20);
        frame.getContentPane().add(HuffmanCompressionRatioText);

        JLabel HuffmanCompressionRatio = new JLabel("---");
        HuffmanCompressionRatio.setBounds(250, 470, 300, 20);
        frame.getContentPane().add(HuffmanCompressionRatio);

        JLabel ArithmeticCompressionRatioText = new JLabel("Arithmetic Compression Ratio");
        ArithmeticCompressionRatioText.setBounds(550, 470, 230, 20);
        frame.getContentPane().add(ArithmeticCompressionRatioText);

        JLabel ArithmeticCompressionRatio = new JLabel("---");
        ArithmeticCompressionRatio.setBounds(800, 470, 300, 20);
        frame.getContentPane().add(ArithmeticCompressionRatio);

        JLabel HuffmanEncodingTimeText = new JLabel("Huffman Encoding Time");
        HuffmanEncodingTimeText.setBounds(20, 520, 200, 20);
        frame.getContentPane().add(HuffmanEncodingTimeText);

        JLabel HuffmanEncodingTime = new JLabel("---");
        HuffmanEncodingTime.setBounds(250, 520, 300, 20);
        frame.getContentPane().add(HuffmanEncodingTime);

        JLabel ArithmeticEncodingTimeText = new JLabel("Arithmetic Encoding Time");
        ArithmeticEncodingTimeText.setBounds(550, 520, 230, 20);
        frame.getContentPane().add(ArithmeticEncodingTimeText);

        JLabel ArithmeticEncodingTime = new JLabel("---");
        ArithmeticEncodingTime.setBounds(800, 520, 300, 20);
        frame.getContentPane().add(ArithmeticEncodingTime);

        JLabel HuffmanDecodingTimeText = new JLabel("Huffman Decoding Time");
        HuffmanDecodingTimeText.setBounds(20, 570, 200, 20);
        frame.getContentPane().add(HuffmanDecodingTimeText);

        JLabel HuffmanDecodingTime = new JLabel("---");
        HuffmanDecodingTime.setBounds(250, 570, 300, 20);
        frame.getContentPane().add(HuffmanDecodingTime);

        JLabel ArithmeticDecodingTimeText = new JLabel("Arithmetic Decoding Time");
        ArithmeticDecodingTimeText.setBounds(550, 570, 230, 20);
        frame.getContentPane().add(ArithmeticDecodingTimeText);

        JLabel ArithmeticDecodingTime = new JLabel("---");
        ArithmeticDecodingTime.setBounds(800, 570, 300, 20);
        frame.getContentPane().add(ArithmeticDecodingTime);






        JButton btnCreateMessage = new JButton("Generate!");
        btnCreateMessage.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                int countSourceSymbols = sourceSymbolsCount();
                int countProbabilities = countFrequencies();

                if(countSourceSymbols != countProbabilities){
                    System.out.println("Source symbol doesn't match probability!");
                } else if (countSourceSymbols == 0) {
                    System.out.println("No Input!");
                } else if(!areSourceLettersAChar()){
                    System.out.println("Source symbol is not a char!");
                } else if(!checkFrequenciesAsIntegers()){
                    System.out.println("Frequencies have to be integers!");
                } else {
                    String text = generateText();
                    long startTime, endTime, huffmanEncodingTime, arithmeticEncodingTime, huffmanDecodingTime, arithmeticDecodingTime;

                    //Huffman Encoding
                    startTime = System.nanoTime();
                    String huffmanCode = HuffmanEncoder.huffmanEncode(text);
                    endTime = System.nanoTime();
                    huffmanEncodingTime = endTime - startTime;

                    //Arithmetic Encoding
                    startTime = System.nanoTime();
                    String arithmeticCode = ArithmeticEncoder.arithmeticEncode(text);
                    endTime = System.nanoTime();
                    arithmeticEncodingTime = endTime - startTime;

                    //HuffmanDecoding
                    startTime = System.nanoTime();
                    String huffmanText = HuffmanDecoder.huffmanDecode(huffmanCode, text);
                    endTime = System.nanoTime();
                    huffmanDecodingTime = endTime - startTime;

                    //ArithmeticDecoding
                    startTime = System.nanoTime();
                    String arithmeticText = ArithmeticDecoder.arithmeticDecode(arithmeticCode, getFrequencies(), getChars());
                    endTime = System.nanoTime();
                    arithmeticDecodingTime = endTime - startTime;

                    generatedTextLabel.setText(text);
                    HuffmanEncodedText.setText(huffmanCode);
                    ArithmeticEncodedText.setText(arithmeticCode);
                    HuffmanDecodedText.setText(huffmanText);
                    ArithmeticDecodedText.setText(arithmeticText);

                    //Time Labels
                    HuffmanEncodingTime.setText(huffmanEncodingTime + "");
                    ArithmeticEncodingTime.setText(arithmeticEncodingTime + "");
                    HuffmanDecodingTime.setText(huffmanDecodingTime + "");
                    ArithmeticDecodingTime.setText(arithmeticDecodingTime + "");

                    //Original Size
                    byte[] byteArray;
                    int sizeInBits = 1;
                    try{
                        byteArray = text.getBytes("UTF-16BE");
                        sizeInBits = byteArray.length * 8;
                        originalSize.setText(sizeInBits + "");
                    } catch (Exception exception){
                        System.out.println("Unsupported Encoding Format!");
                    }

                    //Huffman Size
                    HuffmanSize.setText(huffmanCode.length() + "");

                    //Arithmetic Size
                    ArithmeticSize.setText(arithmeticCode.length() + "");

                    //HuffmanCompressionRatio
                    HuffmanCompressionRatio.setText(((huffmanCode.length()*100.0 / sizeInBits)) + "");

                    //ArithmeticCompressionRatio
                    ArithmeticCompressionRatio.setText(((arithmeticCode.length()*100.0 / sizeInBits)) + "");
                }
            }

            public ArrayList<Integer> getFrequencies() {
                ArrayList<Integer> frequencyList = new ArrayList<>();
                for (int i = 0; i < frequencies.size(); i++) {
                    if(frequencies.get(i).getText() != null && !frequencies.get(i).getText().isEmpty()) {
                        frequencyList.add(Integer.parseInt(frequencies.get(i).getText()));
                    }
                }
                return frequencyList;
            }

            public ArrayList<String> getChars() {
                ArrayList<String> chars = new ArrayList<>();
                for (int i = 0; i < sources.size(); i++) {
                    if(sources.get(i).getText() != null && !sources.get(i).getText().isEmpty()) {
                        chars.add(sources.get(i).getText());
                    }
                }
                return chars;
            }


            public int sourceSymbolsCount(){
                int count = 0;
                for(int i = 0; i < sources.size(); i++){
                    if(sources.get(i).getText() != null && !sources.get(i).getText().isEmpty()){
                        count ++;
                    }
                }
                return count;
            }

            public boolean areSourceLettersAChar(){
                for(int i = 0; i < sources.size(); i++){
                    if(sources.get(i).getText().length() > 1){
                        return false;
                    }
                }
                return true;
            }

            public boolean checkFrequenciesAsIntegers(){
                for(int i = 0; i < frequencies.size(); i++){
                    if(frequencies.get(i).getText() != null && !frequencies.get(i).getText().isEmpty()){
                        try{
                            Integer.parseInt(frequencies.get(i).getText());
                        } catch (Exception e){
                            return false;
                        }
                    }
                }
                return true;
            }

            public int countFrequencies(){
                int count = 0;
                for(int i = 0; i < frequencies.size(); i++){
                    if(frequencies.get(i).getText() != null && !frequencies.get(i).getText().isEmpty()){
                        count++;
                    }
                }

                return count;
            }

            public String generateText() {
                StringBuffer text = new StringBuffer();
                ArrayList<String> chars = new ArrayList<>();
                for (int i = 0; i < sources.size(); i++) {
                    if(sources.get(i).getText() != null && !sources.get(i).getText().isEmpty()) {
                        for (int j = 0; j < Integer.parseInt(frequencies.get(i).getText()); j++) {
                            chars.add(sources.get(i).getText());
                        }
                    }
                }
                int random;
                while(chars.size() > 1){
                    random = (int)(Math.random() * chars.size());
                    text.append(chars.get(random));
                    chars.remove(random);
                }
                text.append(chars.get(0));
                return text.toString();
            }
        });

        btnCreateMessage.setBounds(20, 120, 150, 20);
        frame.getContentPane().add(btnCreateMessage);
    }
}

