package com.kurshit.graphs.directed.traversals;

import java.util.Scanner;

public class Sample {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while(T-- > 0) {
            int N = scan.nextInt();
            solve(N);
        }


    }

    public static void solve(int N) {

        for(int i = 1; i <= N; i++) {
            if(i % 3 == 0 && i% 5 == 0) {
                System.out.println("FIzzBuss");
            } else if(i % 3 == 0) {
                System.out.println("FIzz");
            } else if( i % 5 == 0) {
                System.out.println("Buss");
            } else {
                System.out.println(i);
            }
        }
    }
}
