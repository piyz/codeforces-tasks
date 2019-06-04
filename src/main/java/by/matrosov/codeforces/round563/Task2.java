package by.matrosov.codeforces.round563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        boolean evenExists = list.stream().anyMatch(integer -> integer % 2 == 0);
        boolean oddExists = list.stream().anyMatch(integer -> integer % 2 != 0);

        if (evenExists && oddExists) Collections.sort(list);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
