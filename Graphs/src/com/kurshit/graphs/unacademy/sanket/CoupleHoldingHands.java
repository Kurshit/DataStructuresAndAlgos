package com.kurshit.graphs.unacademy.sanket;

/*
    Problem Source : https://unacademy.com/class/graph-interview-problems-part-3/3SHQBYJN

    Problem : There are N couples (2N people). all these people are arranged in some random permutation in a linear row - array.
    Now the each couple wishes to hold hands and thus need to seat together next to each other (adjacent). The couple are numbered from 1 to 2N
    and you can assume 1,2 are one couple, 3,4 are second, 5,6 third and so 2N-1, 2N last one.
    Even though the couple sequence does not matter amongst them, over all sequence of couple matters. i.e couplpe 1 & 2 can sit in any order, but couple (1,2) has to come first before
    (3,4)
    You have to find number of swaps required on randomly sitting people to acheive above arrangements.

    Ex. People given are as -  1 3 2 4

    One of the correct order would be - 1 2 3 4

    Or                                  2 1 4 2

    the above would require 2 swaps - 3 & 2
 */

/*
        Few points -

        1. Q : Isn't is same as finding number of swaps required to get the array sorted ?
        Ans : Well, no. Array may not need be sorted as couple can sit in any order like 1 2 OR 2 1.
 */

public class CoupleHoldingHands {


    public static void main(String[] args) {

    }


    /*
        Solution Approach :
            -- Try to visualize it in graphs - 1 3 2 4
            -- Draw following and locate swap positions of 2 4 5 1 5 6. You will notice (2, 4, 1), (5,3) & (6) are three connectd components.
            -- Now notice, using 3 swaps, you get your desired answer. If you notice, each component can resolve itself independent of another one.
                Compo (2,4,1) requires 2 swaps
                Compo (5,3) requires one swap
                Compo (6) requires 0 swaps as it is already at its  correct position
            -- Now consider you have N nodes and you have K C1, C2, C3 .... Ck components as above.
            Now, lets say you have n1 nodes in C1, n2 in C2 and Nk nodes in Ck
            So N = n1 + 2 + n3 + .... nk.     //equation 1
            Now go back and again notice above example components individually -
                C1 had 3 nodes and required 2 swaps.
                C2 had 3 nodes and needed 1 swap
                C3 had 1 nodes and required 0 swaps.
            i.e. If a component has N' nodes you need N' - 1 swaps to resolve it.

            So to resolve all K components - total swaps will be --

                => (n1-1) + (n2-1) + (n3-1) + (n4-1) + ... (nk-1)
                => (n1 + n2 + n3 + n4 ---nk) - (1 + 1 + 1 + ...k times)
                => (n1 + n2 + n3 + n4 ---nk) - K
                => N - K        //from eq 1

        i.e Total no of swaps required = N - K   // where K is no of components

        We have to find Total No of components and also while doing so, ensure couple order across all couple is maintained.

        For this, what we will consider is - Each couple would be one pair for us and will consider is as -
        Let's consider o index based couple for the sake of code

        (0,1) -> 0'
        (2,3) -> 1'
        (4,5) -> 2'
        (6,7) -> 3'

        ans so on.

        We will focus on achieving order as - 0' 1' 2' 3' ---N-1' (N couple)

        Now initially, every element is in its own component -
        ex : 0, 2, 1, 3

        We will just loop through N couple (not 2N) and will map each person to the couple it belongs

        0 belons to 0'
        2 belongs tp 1'

        map this using value/2

         Q : Now how to find number of components ? Which graph approach gives you humber of components.
         Ans : DSU


     */
}
