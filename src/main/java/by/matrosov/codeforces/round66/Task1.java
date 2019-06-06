package by.matrosov.codeforces.round66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(reader.readLine());
        List<String[]> list = new ArrayList<>();
        reader.lines().limit(c).forEach(line -> list.add(line.split(" ")));

        for (String[] strings : list) {
            long n = Long.parseLong(strings[0]);
            long k = Long.parseLong(strings[1]);
            long count = 0;

            while (n > 0) {
                if (n % k == 0) {
                    n = n / k;
                    count++;
                } else {
                    count = count + n % k;
                    n = n - n % k;
                }
            }
            System.out.println(count);
        }
    }
}
