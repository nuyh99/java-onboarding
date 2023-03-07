package onboarding;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.mockito.internal.util.collections.ListUtil.filter;

public class Problem3 {
    public static final String Clap_num = "369";
    public static long Clap (String str) {
        int clap = 0;
        while(str.length()!=0) {
            String s = str.substring(str.length() - 1, str.length());
            str = str.substring(0, str.length() - 1);
            if (Clap_num.contains(s)) {
                clap += 1;
            }
        }
        return clap;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
