import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;
    Node(char c, int f) { 
        ch = c; 
        freq = f; 
    }
}

public class HuffmanUserInput {
    static void printCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            System.out.println(root.ch + ": " + code);
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            chars[i] = sc.next().charAt(0);
            System.out.print("Enter frequency of " + chars[i] + ": ");
            freq[i] = sc.nextInt();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int i = 0; i < n; i++)
            pq.add(new Node(chars[i], freq[i]));

        while (pq.size() > 1) {
            Node left = pq.poll(), right = pq.poll();
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");
        sc.close();
    }
}

