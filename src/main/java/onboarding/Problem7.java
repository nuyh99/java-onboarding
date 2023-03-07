package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    /*value값을 기준으로 정렬하되 같은 경우에는 key를 기준으로 정렬*/
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        HashMap<String, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted((k1,k2)
                        ->k1.getKey().compareTo(
                        k2.getKey()))
                .sorted((i2, i1)
                        -> i1.getValue().compareTo(
                        i2.getValue()))

                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return temp;
    }

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

        /*함께하는 친구에 대한 Point부여*/
        for(int i = 0;i<idx;i++){
            if(i==Index.get(user)){
                continue;
            }
            for(int j = 0;j<FriendList[i].size();j++){
                for(int z =0;z<UserFriend.size();z++){
                    if (Index.get(UserFriend.get(z))==i){
                        Point.put(i,-1);
                        break;
                    }
                    if (FriendList[i].get(j)==UserFriend.get(z)){
                        int newScore = Point.get(i)+10;
                        Point.put(i,newScore);
                    }
                }
            }
        }

        /*방문횟수에 따른 포인트 부여*/
        for (int i = 0;i< visitors.size();i++){
            String vst = visitors.get(i);
            System.out.println(i+"vst:"+vst+";"+Point.get(Index.get(vst)));
            if (Index.get(vst) == null) {
                Point.put(idx, 1);
                Index.put(vst,idx++);
                FriendList[Index.get(vst)] = new ArrayList();
            }
            else if(Point.get(Index.get(vst))<0){
                continue;
            }
            else{
                int newscore = Point.get(Index.get(vst)) + 1;
                Point.put(Index.get(vst),newscore);
            }
        }

        /*인덱스번호 - 포인트로 구성된 Point 해쉬맵을 닉네임 - 포인트 형식인 Result 해쉬맵으로 저장 */
        Iterator<Map.Entry<String, Integer>> entries = Index.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            Result.put(entry.getKey(),Point.get(entry.getValue()));
        }

        /*Result 해쉬맵을 value를 기준으로 정렬*/
        Result=sortByValue(Result);

        /*Result 해쉬맵을 순회하며 answer에 최대 상위 5개의 닉네임 추가*/
        entries = Result.entrySet().iterator();
        int limit = 0;
        while (entries.hasNext()) {
            if(limit>5){
                break;
            }
            Map.Entry<String, Integer> entry = entries.next();
            if(entry.getValue()>0){
                answer.add(entry.getKey());
                limit++;
            }

        }


        return answer;
    }
}