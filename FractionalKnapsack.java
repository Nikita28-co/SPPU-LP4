import java.util.*;
class Item {
    int value, weight;
    Item(int v, int w) {
        value = v;
        weight = w;
    }
}
public class FractionalKnapsack {
    static double getMaxValue(int[] wt, int[] val, int capacity) {
        double totalValue = 0.0;
        int n = wt.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++)
            items[i] = new Item(val[i], wt[i]);

        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));


        for (Item item : items) {
            if (capacity - item.weight >= 0) {
                                                                                                    // Take the whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                                                                                                    // Take a fraction of the item
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }
        return totalValue;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter values and weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            value[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        double maxValue = getMaxValue(weight, value, capacity);
        System.out.println("\nMaximum value in Knapsack = " + maxValue);

        sc.close();
    }
}
