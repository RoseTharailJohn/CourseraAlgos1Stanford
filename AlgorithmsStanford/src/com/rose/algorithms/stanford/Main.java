package com.rose.algorithms.stanford;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int[] readFile(File file) {
        int[] nums = new int[100000];
        int i=0;
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = br.readLine()) != null) {
                nums[i++] = (Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nums;
    }

    public static void main(String[] args) {
        /*
        // Karatsuba multiplication
        int x = 3909;
        int y = 897;
        KaratsubaMultiplication multiplier = new KaratsubaMultiplication();
        System.out.println("Result: of "+x+" * "+y+" = "+multiplier.multiply(x,y));
       */

        // Count inversions using merge sort
        // int [] arr = {1, 3, 5, 2, 4, 6};
        // int [] arr = {1, 3, 10, 11, 2, 4, 6, 7 };
        // int[] arr = { 37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45 };
        //int[] arr = {1,6,3};
        CountInversions counter = new CountInversions();
        // System.out.println("Number of inversions in arr : "+ Arrays.toString(arr)+ " is " +counter.countInversions(arr));
        System.out.println("Number of inverstions is "+ counter.countInversions(
                readFile(new File("C:\\Users\\tharair\\JavaProjects\\AlgorithmsStanford\\rsc\\IntegerArray.txt"))
        ));
    }
}
