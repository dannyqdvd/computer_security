//http://rosettacode.org/wiki/Huffman_coding#Java

import java.util.*;
 
abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // the frequency of this tree
    public HuffmanTree(int freq) { frequency = freq; }
 
    // compares on the frequency
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends HuffmanTree {
    public final char value; // the character this leaf represents
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);

        int shifted = (int) val + 65;
        value = (char) shifted;

    }
}

class PairHuffmanLeaf extends HuffmanTree {
    public final String value; // the character this leaf represents
 
    public PairHuffmanLeaf(int freq, char val) {
        super(freq);

        int firstchar = (int) val + 65;
        int secondchar = firstchar + 65;
        StringBuilder s = new StringBuilder();
        s.append((char) firstchar).append((char) secondchar);
        //value = (char) firstchar + (char) secondchar;
        value = s.toString();
    }
}





 
class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right; // subtrees
 
    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
 
public class PairHuffmanCode {

    public static Map<String, String > encodingMap = new HashMap<String, String>();
    public static Map<String, String> decodingMap = new HashMap<String, String>();
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i ));
 
        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }
 
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
 
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
            HuffmanCode.encodingMap.put(leaf.value, prefix.toString());
            HuffmanCode.decodingMap.put(prefix.toString(), leaf.value);


 
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

 
    public static void start(int [] freq) {
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        //int[] charFreqs = args[0];
        // read each character and record the frequencies
        // for (char c : test.toCharArray())
        //     charFreqs[c]++;
 
        // build tree
        
        HuffmanTree tree = buildTree(freq);
 
        // print out results
        System.out.println("LETTER\tFREQ\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }



}