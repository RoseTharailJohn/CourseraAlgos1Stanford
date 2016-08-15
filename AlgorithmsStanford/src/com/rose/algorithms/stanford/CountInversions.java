package com.rose.algorithms.stanford;

/**
 * Created by tharair on 7/20/2016.
 */
public class CountInversions {
    public class InverstionMergeSortResult {
        int [] sortedArray;
        long inversionCount;
        public InverstionMergeSortResult(int[] array, long count){
            this.sortedArray = array;
            this.inversionCount = count;
        }
    }
    /*public class InversionResult{
        long inverstionCount;
        public InversionResult(int[] leftArray, int[] rightArray, int[] sortedArray, long inverstionCount) {
            this.leftArray=leftArray;
            this.rightArray = rightArray;
            this.sortedArray = sortedArray;
            this.inverstionCount=inverstionCount;
        }
    }*/

    public long countInversions(int[] arr) {
        long inversions = inversionsCount_mergeSort(arr).inversionCount;
        return inversions;
    }

    private int[] copyArray(int[] src, int from, int to) {
        int [] dest = new int[(to-from)+1];
        int j = 0;
        for(int i=from; i<=to;i++) {
            dest[j++] = src[i];
        }
        return dest;
    }

    private InverstionMergeSortResult inversionsCount_mergeSort(int[] arr) {
        int n = arr.length;
        if(n<=1) {
            return new InverstionMergeSortResult(arr, 0);
        }
        int mid = (n)/2;
        int[] leftArr = copyArray(arr, 0, mid-1);
        int[] rightArr = copyArray(arr, mid, n-1 );
        InverstionMergeSortResult leftArrayRes = inversionsCount_mergeSort(leftArr);
        InverstionMergeSortResult rightArrayRes = inversionsCount_mergeSort(rightArr);

        // long leftInversionsCount = inversionsCount_mergeSort(leftArr).inversionCount;
        // long rightInversionsCount = inversionsCount_mergeSort(rightArr).inversionCount;
        // long splitInverstionsCount = inversionsCount_merge(leftArr, rightArr, arr);
        InverstionMergeSortResult res = inversionsCount_merge(leftArrayRes.sortedArray, rightArrayRes.sortedArray);
        return new InverstionMergeSortResult(res.sortedArray, leftArrayRes.inversionCount+rightArrayRes.inversionCount+res.inversionCount);
    }

    // private long inversionsCount_merge(int[] leftArr, int[] rightArr, int[] unmergedArr) {
    // private InversionResult inversionsCount_merge(int[] leftArr, int[] rightArr, int[] unmergedArr) {
    private InverstionMergeSortResult inversionsCount_merge(int[] leftArr, int[] rightArr) {
        int l = 0;
        int r = 0;
        int m = 0;
        long inversionCount = 0;
        int[] merged = new int[leftArr.length+rightArr.length];
        while(l<leftArr.length && r<rightArr.length) {
            if(leftArr[l]<=rightArr[r]) {
                merged[m++] = leftArr[l++];
            } else {
                inversionCount += leftArr.length-l;
                merged[m++] = rightArr[r++];
            }
        }
        while(l<leftArr.length) {
            merged[m++] = leftArr[l++];
        }
        while(r<rightArr.length) {
            merged[m++] = rightArr[r++];
        }

        // unmergedArr = merged;
        // leftArr = copyArray(merged,0,(merged.length/2)-1);
        // rightArr = copyArray(merged, (merged.length/2), (merged.length-1));
        InverstionMergeSortResult res = new InverstionMergeSortResult(merged, inversionCount);
        return res;
        // return inversionCount;
    }
}
