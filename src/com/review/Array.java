package com.review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Array {
//    a:[1,2,4,0,8,0,5,0]
//    OP: [0,0,0,1,2,4,5,8]
//    OP2: [1,2,4,5,8]
//    Print non-prime list
    public static void main(String[] args) {
        int [] arr = {10,20,30,5,8,0,0,6,0,25};
        ArrayList<Integer> removeZero = new ArrayList<>();
        int temp=0;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j< arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int a:arr) {
            System.out.print(a+" ");
        }
        System.out.println();
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0)
                removeZero.add(arr[i]);
        }
        for(Integer i : removeZero){
            System.out.print(i+" ");
        }
        System.out.println();
//        ArrayList<Integer> nonPrimeNo = new ArrayList<>();
//        int j = 2, count =0;
        List<Integer> nonPrimeList = removeZero.stream()
                .filter(num -> !isPrime(num))
                .collect(Collectors.toList());

        // Print non-prime list
        System.out.println("Non-prime List:");
        nonPrimeList.forEach(num -> System.out.print(num + " "));
//        for(Integer i : removeZero){
//            while (j<i/2){
//                if (i%j==0){
//                    count++;
//                }
//                j++;
//            }
//            if (count!=0){
//                nonPrimeNo.add(i);
//            }
//        }
//        for (Integer nonPrimes : nonPrimeNo){
//            System.out.print(nonPrimes+" ");
//        }

    }
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
