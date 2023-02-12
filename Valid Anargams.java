class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);   
            //map ka andar put krna ith idx wala char ko or uske liye frequency
            //agr exist nh krta toh 0 usme +1 or agr exist krta h toh purani freq mai add ia +1 
        }
        
        //for t i.e 2nd string 
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {  //agar frequency 1 h toh uss element ko removekr do 
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) -1);  //if freq > 1 toh usko - krdo 1 se 
                }
            } else{
                return false;   //t ka char h jo s mai exist nh krta
            }
        }
        return map.isEmpty();
    }
}
