package by.matrosov.codeforces.round563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n + 1];
        int count = 1;

        for (int i = 2; i < n + 1; i++) {
            if (arr[i] == 0){
                arr[i] = count;
                for (int j = i * 2; j < n + 1; j += i) {
                    arr[j] = count;
                }
                count++;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
