class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;   // last index of a
        int j = b.length() - 1;   // last index of b

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0 || carry == 1) {

            int sum = carry;

            if(i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);   // binary digit

            carry = sum / 2;      // new carry
        }

        return sb.reverse().toString();
    }
}