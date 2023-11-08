import java.util.Arrays;
import java.util.Scanner;

class Item {
    double weight;
    double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}

class CompareItems implements java.util.Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return Double.compare(b.value / b.weight, a.value / a.weight);
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the weight and value for item " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();
            items[i] = new Item(weight, value);
        }

        Arrays.sort(items, new CompareItems());

        double maxValue = fractionalKnapsack(items, n, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }

    public static double fractionalKnapsack(Item[] items, int n, double capacity) {
        double totalValue = 0.0;
        for (int i = 0; i < n; i++) {
            if (items[i].weight <= capacity) {
                totalValue += items[i].value;
                capacity -= items[i].weight;
            } else {
                totalValue += (capacity / items[i].weight) * items[i].value;
                break;
            }
        }

        return totalValue;
    }
}
