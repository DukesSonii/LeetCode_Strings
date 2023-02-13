class Solution {
    List<List<String>> res = new LinkedList<>();
    String str;
    
    public List<List<String>> partition(String s) {
        str = s;
        helper(new LinkedList<>(), 0);  //empty list starting at 0 
        return res;     
    }

    //when we found the string which is palindrome we will add this to our list and when we reach end 
    //we return the curr list that we built onto our res ist 
    public void helper(List<String> list, int start){
        if(start == str.length()){
            res.add(new ArrayList<>(list));
            return; 
        } 
        //why st+1 b/c we are goint o=to get our substring that stars at starts  to i so st + 1 
        //i gives where to partition
        for(int i = start + 1; i<=str.length(); i++){
            String sub = str.substring(start,i);
            //check if curre str is substr is palin
            if(palin(sub)){
                list.add(sub);
                helper(list,i);
                //when we do continue to backtrack we remove last element that we added it 
                list.remove(list.size() -1);
            }
        }
    }
    
    public static boolean palin(String s){
        int n =s.length();
        for(int i=0; i<n/2; i++){  
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
