package hmwapp;

import java.lang.*;
import java.sql.SQLOutput;

//**
//
//
//
public class App {
    public static boolean meanCompareOfTwoArrays(int[] arr1, int arr2[], Integer i, int k) {
        int sum=0;
        int mean;
        boolean t=false;
        for (int j=0;j<arr1.length;j++){
            sum+=arr1[j];
        }
        for (int j=0;j<arr2.length;j++){
            sum+=arr2[j];
            System.out.println("");
        }
        mean=sum/(arr1.length+arr2.length);


        if(i.compare(mean,k)==0){
            t=true;

        }

        return t ;


    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Integer i = 5;




    }
}