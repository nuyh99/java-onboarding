package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {

    public static int compare (String str1, String str2) {
        for (int i = 0;i<str1.length()-1;i++){
            String s1 = str1.substring(i,i+2);

            if (str2.contains(s1)) {
                return 0;
            }
        }
        return -1;
    }

    public static  ArrayList<Integer> init(ArrayList<Integer> l,int size){
        for(int i = 0;i<size;i++){
            l.add(0);
        }
        return l;
    }

    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<String>();
        ArrayList<Integer> check = new ArrayList<Integer>();
        check = init(check,forms.size());


        for(int i=0;i<forms.size()-1;i++){
            String s = forms.get(i).get(1);
            for(int j=i+1;j<forms.size();j++){
                String t = forms.get(j).get(1);
                if (compare(s,t)==0){
                    check.set(i,1);
                    check.set(j,1);
                }
            }
        }


        return answer;

    }
}
