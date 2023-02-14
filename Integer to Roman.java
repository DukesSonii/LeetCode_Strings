class Solution {
    public String intToRoman(int num) {
         int[] base = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX", "V", "IV", "I"};
        String result = "";
        for (int i = 0; i < base.length; i ++) {
            if (num / base[i] > 0) {
                for (int j = 0; j < num/base[i]; j ++) {
                    result = result + chars[i];
                }
                num = num - (num / base[i]) * base[i];
            }
        }
        return result;
    }
}
