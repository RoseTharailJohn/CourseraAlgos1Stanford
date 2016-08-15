package com.rose.algorithms.stanford;

/**
 * Created by tharair on 7/20/2016.
 */
public class KaratsubaMultiplication {
    // determine n, for further use
    private int findNoOfDigits(int x, int y) {
        if(x==0 || y==0) {
            return 1;
        }
        int n=0;
        while(x!=0) {
            n++;
            x = x/10;
        }
        int new_n=0;
        while(y!=0){
            new_n++;
            y = y/10;
        }
        return (new_n>n)?new_n:n;
    }

    public int multiply(int x, int y) {
        int res = 0;
        res = karatsubaMultiply(Math.abs(x), Math.abs(y));
        if((x<0&&y<0) || (x>0&&y>0)) {
            return res;
        } else{
            return (-1)*res;
        }
    }

    private int karatsubaMultiply(int x, int y) {
        int n = findNoOfDigits(x,y);
        if(n==1) {
            return x*y;
        }
        int nBy2 = n/2;
        int a = (int)(x/(Math.pow(10,nBy2)));
        int b = (int)x%(int)(Math.pow(10,nBy2));
        int c = (int)(y/(Math.pow(10,nBy2)));
        int d = (int)y%(int)(Math.pow(10,nBy2));
        int ac = karatsubaMultiply(a,c);
        int bd = karatsubaMultiply(b,d);
        int adPlusbc = karatsubaMultiply((a+b),(c+d))-ac-bd;
        // using this trick to take care of 105*48 issues so that numbers don't get bumped up by power of 10
        // if n is 3, nby2 would be 1, and ideally we need to multiply by the 2*nby2, not 3!
        int res = (int)(ac*Math.pow(10,(2*nBy2)) + adPlusbc*Math.pow(10,nBy2) + bd);
        return res;
    }
}
