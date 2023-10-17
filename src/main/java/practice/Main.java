package practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        CoolNumbers.generateCoolNumbers();
        System.out.println(CoolNumbers.listOfNumbers);
        System.out.println(CoolNumbers.listOfNumbers.size());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите интересующий номер:");
        String searchNumber = scanner.nextLine();

        long timeCounterForList = System.nanoTime();
        if (CoolNumbers.bruteForceSearchInList(CoolNumbers.listOfNumbers, searchNumber)) {
            printSuccess("Поиск перебором", timeCounterForList);
        } else {
            printFail("Поиск перебором", timeCounterForList);
        }

        long timeCounterForBinary = System.nanoTime();
        Collections.sort(CoolNumbers.listOfNumbers);
        if (CoolNumbers.binarySearchInList(CoolNumbers.listOfNumbers, searchNumber)) {
            printSuccess("Бинарный поиск", timeCounterForBinary);
        } else {
            printFail("Бинарный поиск", timeCounterForBinary);
        }

        long timeCounterForHash = System.nanoTime();
        HashSet<String> hashSet = new HashSet<>(CoolNumbers.listOfNumbers);
        if (CoolNumbers.searchInHashSet(hashSet, searchNumber)) {
            printSuccess("Поиск в HashSet", timeCounterForHash);
        } else {
            printFail("Поиск в HashSet", timeCounterForHash);
        }

        long timeCounterForTree = System.nanoTime();
        TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.listOfNumbers);
        if (CoolNumbers.searchInTreeSet(treeSet, searchNumber)) {
            printSuccess("Поиск в TreeSet", timeCounterForTree);
        } else {
            printFail("Поиск в TreeSet", timeCounterForTree);
        }
    }
    
    private static void printSuccess(String methodName, long timeCounter){
        System.out.println(methodName + ": номер найден, поиск занял: "
                + (System.nanoTime() - timeCounter) + " нс");
    }

    private static void printFail(String methodName, long timeCounter){
        System.out.println(methodName + ": номер не найден, поиск занял: "
                + (System.nanoTime() - timeCounter) + " нс");
    }
}
