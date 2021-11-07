package ru.geekbrains.lesssons;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    private static int maxPrice = 0;
    private static List<Item> maxValues = new ArrayList<>();

    public static void main(String[] args) {

        int k = 2;
        int n = 4;
        System.out.println(k + "^" + n + " = " + getDegree(k, n));

        int maxWeight = 4;
        Item[] items = {new Item("гитара", 1, 1500),
                new Item("бензопила", 4, 3000),
                new Item("ноутбук", 3, 2000)};

        findMaxValues(items, new ArrayList<Item>(), 0, 4);
        System.out.println();
        System.out.println("Максимальная стоимость: " + maxValues.toString() + ", сумма - " + maxPrice);
        System.out.println();

        Item[] items1 = { new Item("книга", 1, 600),
                new Item("бинокль", 2, 5000),
                new Item("аптечка", 4, 1500),
                new Item("ноутбук", 2, 40000),
                new Item("котелок", 1, 500)};
        findMaxValues(items1, new ArrayList<Item>(), 0, 5);
        System.out.println();
        System.out.println("Максимальная стоимость: " + maxValues.toString() + ", сумма - " + maxPrice);
    }

    public static int getDegree(int k, int n)
    {
        if (n == 0)
            return 1;
        if (n == 1)
            return k;
        return k * getDegree(k, n-1);
    }

    public static void findMaxValues(Item[] items, List<Item> itemList, int count, int maxWeight) {
        for (int i = 0; i < items.length; i++) {
            if (itemList.contains(items[i]))
                break;
            List<Item> itemList1 = new ArrayList<>(itemList);
            if (count < items.length) {
                itemList1.add(items[i]);
                findMaxValues(items, itemList1, count + 1, maxWeight);
            }
            int price = 0;
            int weight = 0;
            for (Item item : itemList1) {
                price += item.getPrice();
                weight += item.getWeight();
            }
            if (weight <= maxWeight) {
                System.out.println(itemList1.toString() + ", сумма - " + price);
                if (price > maxPrice) {
                     maxPrice = price;
                     maxValues = itemList1;
                }
            }
        }
    }

    public static int getPrice(List<Item> items) {
        int price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }
}
