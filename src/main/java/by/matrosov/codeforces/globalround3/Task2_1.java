package by.matrosov.codeforces.globalround3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> list = new ArrayList<>();

        reader.lines().limit(3).forEach(line ->
                list.add(Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
        );

        int n = list.get(0).get(0);
        int m = list.get(0).get(1);
        int ta = list.get(0).get(2);
        int tb = list.get(0).get(3);
        int k = list.get(0).get(4);

        if (k == n){
            System.out.println(-1);
            return;
        }

        if (k == 1){
            for (int i = 0; i < m; i++) {
                if (list.get(2).get(i) >= list.get(i).get(1) + ta){
                    System.out.println(list.get(2).get(i) + tb);
                    return;
                }
            }
            System.out.println(-1);
            return;
        }

        int fromAtoB = list.get(1).get(k-1) + ta;
        for (int i = 0; i < m; i++) {

            if (list.get(2).get(i) >= fromAtoB){

                if ( i+1 == m ){
                    System.out.println(-1);
                    return;
                }

                System.out.println(list.get(2).get(i+1) + tb);
                return;
            }
        }
        System.out.println(-1);
    }
}

