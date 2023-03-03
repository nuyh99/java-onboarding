package onboarding;

import java.util.List;

class Problem1 {

    public static int sum(int x){
        int result_sum = 0;
        int result_mul = 1;
        while (x!=0){
            result_sum+=(x%10);
            result_mul*=(x%10);
            x/=10;
        }
        return Math.max(result_sum,result_mul);
    }

    public static class PageOrderException extends Exception{
        public PageOrderException(){ }
        public PageOrderException(String message){
            super(message);
        }
    }

    public static class Gamer{
        int left,right,max_num;
        public Gamer(){
        }

        public void makeNum() throws PageOrderException{
            if((left>=1 && left<=399)|| left%2==1 || left+1!=right) {
                throw new PageOrderException("예외사항 발생");
            }
            max_num = Math.max(sum(left),sum(right));
        }

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Gamer po = new Gamer();
        Gamer cr = new Gamer();

        po.left = pobi.get(0);
        po.right = pobi.get(1);
        cr.left = crong.get(0);
        cr.right = crong.get(1);

        try{
            po.makeNum();
            cr.makeNum();
        }catch(PageOrderException e){
            String message = e.getMessage();
            e.printStackTrace();
            answer = -1;
            return answer;
        }

        if (po.max_num>cr.max_num){
            answer = 1;
        }
        else if (po.max_num<cr.max_num){
            answer = 2;
        }
        else if (po.max_num==cr.max_num){
            answer = 0;
        }
        else{
            answer = -1;
        }

        return answer;
    }
}