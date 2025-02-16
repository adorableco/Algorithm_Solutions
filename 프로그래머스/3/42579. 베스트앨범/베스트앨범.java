import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            if(!genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], new ArrayList<>());
                playMap.put(genres[i], 0);
            }
            genreMap.get(genres[i]).add(new int[]{i, plays[i]});
            playMap.put(genres[i], playMap.get(genres[i]) + plays[i]);
        }
        
        Stream<Map.Entry<String, Integer>> sortedMap = playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedMap.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
            
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}