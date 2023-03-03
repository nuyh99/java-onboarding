package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Deque<String> queue = new ArrayDeque<>();

        queue.addFirst(cryptogram.substring(cryptogram.length()-1,cryptogram.length()));
        cryptogram = cryptogram.substring(0,cryptogram.length()-1);

        return answer;
    }
}
