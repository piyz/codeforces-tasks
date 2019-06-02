package by.matrosov.codeforces.globalround3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //reader.lines().forEach(line -> System.out.println(line.toUpperCase()));

        List<Long> input = Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong).collect(Collectors.toList());

        solve(input.get(0), input.get(1), input.get(2));
    }

    private static void solve(long a, long b, long ab){

        if (a == b){
            System.out.println(ab*2 + a+ b);
        }else {
            System.out.println(ab*2 + Math.min(a,b)*2 + 1);
        }
    }
}