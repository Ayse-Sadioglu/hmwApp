package hmwapp;

import java.lang.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


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
        }
        mean=sum/(arr1.length+arr2.length);


        if(i.compare(mean,k)==0){
            t=true;

        }

        return t ;


    }

    public static void main(String[] args) {



        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            int[]arr1=new int[inputList.size()];

            for (int i=0;i<inputList.size();i++)
                arr1[i]=inputList.get(i);

            sc1.close();
            System.out.println(inputList);
            //
            //
            //

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            int[]arr2=new int[inputList2.size()];

            for (int i=0;i<inputList2.size();i++)
                arr2[i]=inputList2.get(i);

            sc2.close();


            String input4 = req.queryParams("input4").replaceAll("\\s","");
            int input4AsInt = Integer.parseInt(input4);


            String input3 = req.queryParams("input3").replaceAll("\\s","");
            int input3asInt= Integer.parseInt(input3);
            Integer input3asInteger= input3asInt;

            boolean result = App.meanCompareOfTwoArrays(arr1,arr2,input3asInt, input4AsInt);

            Map<String, Boolean> map = new HashMap<String, Boolean>();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}






