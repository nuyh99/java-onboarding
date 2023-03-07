package onboarding;

import java.util.Scanner;
public class Problem4 {
    public static final int CAPITAL = (int)'A'+(int)'Z';
    public static final int SMALL = (int)'a'+(int)'z';
    public static char Frog (char c) {
        if ((int)c>=(int)'A' && (int)c<=(int)'Z'){
            return (char) (CAPITAL - (int) c);
        }
        else if((int)c>=(int)'a' && (int)c<=(int)'z'){
            return (char) (SMALL - (int) c);
        }
        else{
            return c;
        }
    }
    public static String solution(String word) {
        String answer = "";

        for(int i = 0;i<word.length();i++){
            answer+=Frog(word.charAt(i));
        }

        return answer;
    }
}
