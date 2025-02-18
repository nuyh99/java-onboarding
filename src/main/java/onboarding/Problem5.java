package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        ArrayList<Integer> cost = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));

        for (int i=0;i<9;i++){
            Integer n = money/cost.get(i);
            money%=cost.get(i);
            answer.add(n);
        }

        return answer;
    }
}
