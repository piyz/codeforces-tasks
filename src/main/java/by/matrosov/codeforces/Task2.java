package by.matrosov.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        if (list.stream().noneMatch(integer -> integer != list.get(0))){
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            return;
        }

        List<Integer> listSorted = list.stream().sorted().collect(Collectors.toList());
        List<Integer> list2k1 = list.stream().sorted().filter(integer -> (integer % 2) != 0).collect(Collectors.toList());
        List<Integer> list2k = list.stream().sorted().filter(integer -> (integer % 2) == 0).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) % 2 == 0 && !list2k1.isEmpty()){
                int temp = list.get(i);
                int swaperIndex = list.indexOf(list2k1.get(0));

                if (temp > list2k1.get(0)){
                    list.set(i, list2k1.get(0));
                    list.set(swaperIndex, temp);

                    list2k1.remove(0);
                }

            }else if (list.get(i) % 2 == 1 && !list2k.isEmpty()){
                int temp = list.get(i);
                int swaperIndex = list.indexOf(list2k.get(0));

                if (temp > list2k.get(0)){
                    list.set(i, list2k.get(0));
                    list.set(swaperIndex, temp);

                    list2k.remove(0);
                }

            }

            if (listSorted.equals(list) || (list2k.isEmpty() && list2k1.isEmpty())){
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                return;
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
