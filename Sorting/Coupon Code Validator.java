// Problem: Coupon Code Validator
// Platform: Leetcode
// Time Complexity: O(n log n)
// Space Complexity: O(n) 

import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        String[] order = {"electronics", "grocery", "pharmacy", "restaurant"};

        Map<String, List<String>> map = new HashMap<>();
        for (String b : order) {
            map.put(b, new ArrayList<>());
        }

        String regex = "^[a-zA-Z0-9_]+$";

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!map.containsKey(businessLine[i])) continue;
            if (code[i] == null || !code[i].matches(regex)) continue;
            map.get(businessLine[i]).add(code[i]);
        }

        List<String> result = new ArrayList<>();
        for (String b : order) {
            List<String> list = map.get(b);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }
}
