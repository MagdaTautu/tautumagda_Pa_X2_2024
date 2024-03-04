package org.example;

public class Homework {
    public static boolean validateInput(int a, int b, int k) {
        return a < b && k > 0;
    }
    public static int reduce(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Insufficient arguments.");
            System.exit(1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        if (!validateInput(a, b, k)) {
            System.out.println("Invalid input.");
            System.exit(1);
        }
        System.out.println("The "+ k +"- reductible numbers are: ");

        long startTime = System.nanoTime();
        for(int i=a;i<=b;i++)
        {
            int reducedNum = reduce(i);
            if(reducedNum == k){
                System.out.print(i + " ");
            }
        }
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e6;
        System.out.printf("%nExecution time: %.2f milliseconds%n", executionTime);
    }

}
