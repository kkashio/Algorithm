class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        String temp ="";
        int len = strs.length;
        int t2=len;
        for(int a=0; a<len; a++) {
            int k = a;
            while(t2-->0){
                if (t.contains(strs[k])) {
                    t = t.replaceFirst(strs[k], "");
                    answer++;
                    k--;
                }
            }
        }
        if(!t.equals("")){
            answer=-1;
        }

        return answer;
    }
}