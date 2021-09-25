package hmwapp;

import java.lang.*;

public class App { //arraylerin elemanlarının ortalamsı gelen sayıya esitse true
    public static boolean meanCompareOfTwoArrays(int[] arr1, int arr2[], Integer i, int k) {
        int sum=0;
        int mean;
        boolean t=false;
        for (int j=0;j<arr1.length;j++){
            sum+=arr1[j];
        }
        for (int j=0;j<arr2.length;j++){
            sum+=arr2[j];
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