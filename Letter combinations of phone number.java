class Solution {
     public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)    //if str is empty, then no combination can be made so return empty str
            return ans;
        
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        
        backtrack(digits, 0, hm, new StringBuilder(), ans); 
        //why 0 b/c mai problem ko 0 idx se apni problem ko solve krna start krunga
        return ans;
    }

    public static void backtrack(String digits, int i, HashMap<Character, String> hm, StringBuilder sb, List<String> ans){
        //eg. 23 pehle apan ne 2 se a le lia phir (i ptr aage badaya mtlb 2 se 3 pe aaye) 3 se b le lia toh sb = ab toh 1 ans is ready and store it in list
        //then backtrack and go to previous i.e 3 phir dusre char loge ae, af 

        if(i == digits.length()){  //we have got our first ans toh us state pe sb mai jo str padi h usko string mai convert kro, add it in ans and then 
                                    //backtrack
            ans.add(sb.toString());
            return;
        }
        /*map se pata kro ki idx i pe konsa char h eg.
            0 1-->idx
            2 3-->char 
            abh 3 se def bana skta ho, toh def wale str ko curr mai daldo
        */
        String curr = hm.get(digits.charAt(i));
        for(int j=0; j<curr.length(); j++){
            sb.append(curr.charAt(j));
            backtrack(digits,i+1, hm,sb,ans);
            //or backtrack krte waqt last wala char delete kr doge
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
