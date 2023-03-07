package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList();
        ArrayList<String> [] FriendList = new ArrayList[5000];

        Map<Integer, Integer> Point = new HashMap();
        Map<String, Integer> Index = new HashMap();
        HashMap<String, Integer> Result = new HashMap();

        int idx = 0;

        /*friend를 순회하며
        ** Point를 0으로 초기화,
        ** 닉네임대신 사용할 Index 해쉬맵 초기화,
        ** Friendlist 각 사람마다 친구목록을 생성 이때 Friendlist의 위에서 정의한 인덱스 번호에 해당하는 리스트가 그 사람의 친구목록 */
        for(int i = 0;i<friends.size();i++) {
            String fri1 = friends.get(i).get(0);
            String fri2 = friends.get(i).get(1);
            if (Index.get(fri1) == null) {
                Point.put(idx, 0);
                Index.put(fri1,idx++);
                FriendList[Index.get(fri1)] = new ArrayList();
            }
            if (Index.get(fri2) == null) {
                Point.put(idx, 0);
                Index.put(fri2,idx++);
                FriendList[Index.get(fri2)] = new ArrayList();

            }

            FriendList[Index.get(fri1)].add(fri2);
            FriendList[Index.get(fri2)].add(fri1);
        }

        /*user의 친구목록은 따로생성*/
        ArrayList<String> UserFriend = (ArrayList<String>) FriendList[Index.get(user)].clone();


        return answer;
    }
}