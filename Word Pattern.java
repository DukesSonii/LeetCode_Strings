class Solution {
    public boolean wordPattern(String pattern, String s) {
        //split function will convert string into words use split for alag alag words
        String words[] = s.split(" ");
        //pattern ka ek char ek word ke sath map hojaye
        HashMap<Character,String> map = new HashMap<>();
        //str vs bool ki koi word use hogya h toh usse dubara use nh krna 
        HashMap<String,Boolean> used = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            //abh dekhna h ki yeh map mai already used h agr nh h toh use else use
            if(map.containsKey(ch) == false){
                if(used.containsKey(words[i])==true){    //agr word jiske sath comp kr rhe h wo used h 
                    return false;
                } else{ //if word is not used then use it or char ke samne map kedo
                    used.put(words[i],true);    
                    map.put(ch,words[i]);
                }
            }else{  //if char is mapped toh pata kro kis word ke sath mapped h 
                String mp_with = map.get(ch);
                if(mp_with.equals(words[i]) == false){
                    return false;   //a-the ke sath map h phir a-that ke sath map h toh that case
                }
            }
        }
        return true;
    }
}
