import ArrayListImplementation.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {


    public static boolean checkIfEmpty(int []arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2)
                return true;
        }
        return false;
    }

    public static int ArrayChallenge(int[] arr) {
        // code goes here



        return arr[0];
    }


    public static List<String> filternames(List<String> list){
        return list.stream().distinct().filter(el -> el.charAt(0) == 'M' && el.length() > 3).map(el -> el.toUpperCase()).collect(Collectors.toList());
    }

    public static void main(String[] args) {



    }
}
