package heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        int k = 4;

        List<String> ans = topKFrequent(words, k);
        System.out.println("Top K Frequent Words : " + ans);
    }

    static class pair {
        String word;
        int freq;

        public pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>(
                (a, b) -> b.freq == a.freq ? a.word.compareTo(b.word) : b.freq - a.freq);

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            pq.offer(new pair(word, map.get(word)));
        }
        List<String> list = new ArrayList<>();
        while (k-- > 0) {
            pair p = pq.poll();
            list.add(p.word);
        }
        return list;
    }
}
