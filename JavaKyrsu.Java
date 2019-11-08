/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakyrsu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Persik
 */
public class JavaKyrsu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in, "Cp1251");
        try {
            Prime(in);
            Fibonacci(in);
            Palindrome(in);
            DeleteNumber(in);
            NOD_NOK(in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Prime(Scanner in) {
        List<Integer> prime = new ArrayList<>();
        System.out.println("Введите максимальное число промежутка");
        int number = in.nextInt();
        for (int i = 2; i <= number; i++) {
            int amount = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    amount++;
                    break;
                }
            }
            if (amount == 0) {
                prime.add(i);
            }
        }
        System.out.println("Последовательность простых чисел, находящихся в промежутке [2;" + number + "]");
        for (int i : prime) {
            System.out.print(i + " ");
        }
    }

    public static void Fibonacci(Scanner in) {
        List<Integer> f = new ArrayList<>();
        System.out.println();
        System.out.println("Введите последнее число промежутка Фибоначчи");
        f.add(1);
        int N = in.nextInt();
        Recursion(f, N);
        System.out.println("Последовательность чисел Фибоначчи, находящихся в промежутке [1;" + N + "]");
        for (int i : f) {
            System.out.print(i + " ");
        }

    }

    public static List<Integer> Recursion(List<Integer> f, int N) {
        if (f.get(f.size() - 1) > N) {
            f.remove(f.size() - 1);
            return f;
        } else {
            if (f.size() == 1) {
                f.add(1);
            } else {
                f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
            }
            return Recursion(f, N);
        }
    }

    public static void Palindrome(Scanner in) {
        System.out.println();
        System.out.println("Введите строку, которую необходимо проверить");
        String stroka = in.nextLine();
        boolean label = true;
        for (int i = 0; i < stroka.length() / 2; i++) {
            if (stroka.charAt(i) != stroka.charAt(stroka.length() - 1 - i)) {
                label = false;
                break;
            }
        }
        if (label) {
            System.out.println(stroka + " - палиндром");
        } else {
            System.out.println(stroka + " - не палиндром");
        }
    }
    public static void Output(){
        System.out.println();
    }

    public static void DeleteNumber(Scanner in) {
        System.out.println();
        System.out.println("Введите строку, из которой необходимо удалить цифры");
        String stroka = in.nextLine();
        for (int i = 0; i < stroka.length(); i++) {
            if (Character.isDigit(stroka.charAt(i))) {
                stroka = stroka.substring(0, i) + stroka.substring(i + 1);
                i--;
            }
        }
        System.out.println();
        System.out.println("Преобразованная строка без чисел: " + stroka);
    }

    public static void NOD_NOK(Scanner in) {
        System.out.println();
        System.out.println("Введите через пробел два числа");
        String[] data = in.nextLine().split(" ");
        double a = Integer.parseInt(data[0]);
        double b = Integer.parseInt(data[1]);
        System.out.println("Наибольший общий делитель чисел " + a + " и " + b + " равен " + NOD(a, b));
        System.out.println("Наименьшее общее кратное чисел " + a + " и " + b + " равно " + NOK(a, b));

    }

    public static double NOD(double a, double b) {
        if (a > b) {
            double temp = b;
            b = a % b;
            a = temp;
            if (b != 0) {
                return NOD(a, b);
            } else {
                return a;
            }
        } else {
            double temp = a;
            a = b % a;
            b = temp;
            if (a != 0) {
                return NOD(a, b);
            } else {
                return b;
            }
        }
    }

    public static double NOK(double a, double b) {
        return a * b / NOD(a, b);
    }

}
package javakyrsu;

/**
 *
 * @author Persik
 */
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double X() {
        return this.x;
    }

    public double Y() {
        return this.y;
    }
}
