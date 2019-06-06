package by.matrosov.codeforces.round66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task2_1 {
    public static void main(String[] args) throws IOException {

        double upperBound = Math.pow(2,32) - 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int l  = Integer.parseInt(reader.readLine());
        //List<String> commandList = new ArrayList<>();
        //reader.lines().limit(l).forEach(commandList::add);

        Stack<Integer> stack = new Stack<>();
        long x = 0;
        while (l > 0){

            String command = reader.readLine();

            if (command.equals("add")) {

                if (stack.isEmpty()){
                    x++;
                }else {
                    long count = 1;
                    for (Integer integer : stack) {
                        count = count * integer;
                        if (count > upperBound) {
                            System.out.println();
                            System.out.println("OVERFLOW!!!");
                            return;
                        }
                    }

                    x += count;
                    if (x > upperBound) {
                        System.out.println();
                        System.out.println("OVERFLOW!!!");
                        return;
                    }
                }

            }else if (command.contains("for")){
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }else {
                stack.pop();
            }

            l--;
        }

        if (x > upperBound){
            System.out.println("OVERFLOW!!!");
        }else {
            System.out.println(x);
        }
    }
}
