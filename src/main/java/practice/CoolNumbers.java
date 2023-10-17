package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CoolNumbers {
    static ArrayList<String> listOfNumbers = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (String letter : letters) {
            for (int num = 0; num < 10; num++) {
                for (int reg = 1; reg < 200; reg++) {
                    String region = String.valueOf(reg);
                    if (reg < 10) {
                        region = "0" + region;
                    }
                    String number = String.format("%s%d%d%d%s%s%s", letter, num, num, num, letter, letter, region);
                    listOfNumbers.add(number);
                }
            }
            if (listOfNumbers.size() <= 2_000_000) {
                listOfNumbers.addAll(listOfNumbers);
            }
        }
        return listOfNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.contains(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int searchNumber = Collections.binarySearch(sortedList, number);
        return searchNumber >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}
