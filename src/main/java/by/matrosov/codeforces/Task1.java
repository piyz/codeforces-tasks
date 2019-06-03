package by.matrosov.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        if (n == 1){
            System.out.println(-1);
            return;
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            sum1 += list.get(i);
            sum2 += list.get(list.size() - 1 - i);
        }


        for (int i = 0; i < list.size() / 2; i++) {

            for (int j = 0; j < list.size() / 2; j++) {
                if (list.get(i) != list.get(list.size() - 1 - j)){

                    int s1 = sum1 - list.get(i) + list.get(list.size() - 1 - j);
                    int s2 = sum2 + list.get(i) - list.get(list.size() - 1 - j);

                    if (s1 != s2){

                        //swap
                        int temp = list.get(i);
                        list.set(i, list.get(list.size() - 1 - j));
                        list.set(list.size() - 1 - j, temp);

                        for (Integer integer : list) {
                            System.out.print(integer + " ");
                        }
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static int readInt(String s){
        return Integer.parseInt(s);
    }

    private static long readLong(String s){
        return Long.parseLong(s);
    }

    private static String[] readLineToStringArr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().split(" ");
    }

    private static List<List<Integer>> readLinesToList(int numberOfLines){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> list = new ArrayList<>();
        reader.lines().limit(numberOfLines).forEach(line ->
                list.add(Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
        );
        return list;
    }
}
