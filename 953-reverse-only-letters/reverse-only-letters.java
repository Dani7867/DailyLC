class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();

        while(i<j){
            if(isValid(arr[i])){
                while(!isValid(arr[j])){
                    j--;
                }
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            i++;
        }

        return new String(arr);
        }

        private boolean isValid(char c){
            return (97<=c && c<=122) || (65<=c && c<=90);
        }
    }
