class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stck = new Stack<>();
        for(String s : operations){
            if(s.equals("D")){
                int p = stck.peek();
                stck.push(2*p);
            }else if(s.equals("C")){
                stck.pop();
            }else if(s.equals("+")){
                int n1 = stck.pop();
                int sum = n1+stck.peek();
                stck.push(n1);
                stck.push(sum);
            }else{
                stck.push(Integer.parseInt(s,10));
            }
        }
        int res = 0 ;
        while(!stck.isEmpty()){
            res += stck.pop();
        }
        return res;
    }
}