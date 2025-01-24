import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> collect = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        Collections.reverse(collect);
        
        return collect.stream().mapToInt(Integer::intValue).toArray();
    }
}