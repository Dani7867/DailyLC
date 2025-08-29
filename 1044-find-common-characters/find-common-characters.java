class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        int[] left = count(words[0]);
        for(int i = 1 ; i < words.length ; i++){
            left = intersection(left,words[i]);
        }

        for(int i = 0 ; i < 26 ; i++){
            while(left[i] > 0){
                char s = (char) ('a' + i);
                String ss = String.valueOf(s);
                res.add(ss);
                left[i]--;
            }
        }
        return res;
    }

    private int[] intersection(int[] arr , String s){
        int[] f = count(s);
        int[] r = new int[26];
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] > 0 && f[i] > 0){
                r[i] = Math.min(arr[i],f[i]);
            }
        }

        return r;
    }

    private int[] count(String arr){
        int[] f = new int[26];
        for(char c : arr.toCharArray()){
            f[c - 'a']++;
        }

        return f;
    }
}