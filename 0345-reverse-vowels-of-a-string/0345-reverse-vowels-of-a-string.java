class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;

        while(i<j){
            if(Character.toLowerCase(arr[i]) != 'a' && Character.toLowerCase(arr[i]) != 'e' && Character.toLowerCase(arr[i]) != 'i' &&
               Character.toLowerCase(arr[i]) != 'o' &&
               Character.toLowerCase(arr[i]) != 'u'){
                i++;
               }
                else if(Character.toLowerCase(arr[j]) != 'a' && Character.toLowerCase(arr[j]) != 'e' && Character.toLowerCase(arr[j])  != 'i' && Character.toLowerCase(arr[j])  != 'o' && Character.toLowerCase(arr[j])  != 'u'){
                j--;
               } else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
               }
        }
        return new String(arr);
    }
}