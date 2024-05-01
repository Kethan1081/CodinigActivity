class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if(idx == -1) return word;
        char[] c = word.toCharArray();
        int i=0;
        while(i<=idx) {
            char tmp = c[i];
            c[i] = c[idx];
            c[idx] = tmp;
            i++;
            idx--;
        }
        return String.valueOf(c);
    }
}