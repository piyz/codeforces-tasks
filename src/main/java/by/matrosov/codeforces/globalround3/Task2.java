package by.matrosov.codeforces.globalround3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        String[] secondLine = reader.readLine().split(" ");
        String[] thirdLine = reader.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int ta = Integer.parseInt(firstLine[2]);
        int tb = Integer.parseInt(firstLine[3]);
        int k = Integer.parseInt(firstLine[4]);

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(secondLine[i]) + ta;
        }

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(thirdLine[i]);
        }

        int result = -1;
        if (k < Math.min(n,m)){

            int j = 0;
            for (int i = 0; i <= k; i++) {

                while (j < m && b[j] < a[i]){
                    j++;
                }

                if (j + k - i < m){
                    result = Math.max(result, b[j+k-i] + tb);
                }else {
                    result = -1;
                    break;
                }
            }
        }
        System.out.println(result);
    }

}
