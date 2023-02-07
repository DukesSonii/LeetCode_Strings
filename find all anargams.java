class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = p.length();
			if(m>n){
                return ans;
            }
			int []arrs = new int[26];
			int []arrp = new int[26];
            //m isliye kyo ki apan ko m str ke end tak iterate krna h 
			for(int i=0;i<m;i++){
				arrs[s.charAt(i)-'a']++;
				arrp[p.charAt(i)-'a']++;
			}

            //see testcase 1 iterate over n-m = 7
			for(int i=0;i<=n-m;i++){    //first add a 
			    if(iszero(arrs,arrp)){
                    ans.add(i);
                }
				arrs[s.charAt(i)-'a']--;    //then remove a

				//to prevent index out of bound condition
                if(i+m < n){
                    arrs[s.charAt(i+m)-'a']++;
                }
			}
			return ans;
		}

        //pehle case mai 0 mila toh usko apn ne ans.add mai dal dia
        public boolean iszero(int [] arrs, int []arrp){
            for(int j=0;j<26;j++){
				if(arrs[j]!=arrp[j]){
					return false;
				    }
				}
            return true;
        }
	}
