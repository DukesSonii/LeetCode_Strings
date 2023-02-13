class Solution {
    public String countAndSay(int n) {
        if(n < 1){
            return null;
        }
        if(n ==1 ) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("11");
        for(int i = 2; i < n; i++){
            StringBuilder c = new StringBuilder();
            int count = 1;
            for( int j = 1; j < sb.length();j++){
                if(sb.charAt(j-1) == sb.charAt(j)){
                    count++;
                }else{
                    c.append(count);
                    c.append(sb.charAt(j-1));
                    count = 1;
                    //or sb.append(count).append(sb.charAt(j - 1));
                }
            }
            c.append(count);
            c.append(sb.charAt(sb.length()-1));
            sb = c;
            //sb.append(count).append(sb.charAt(sb.length() - 1)); 
        }
        return sb.toString();
    }
}
