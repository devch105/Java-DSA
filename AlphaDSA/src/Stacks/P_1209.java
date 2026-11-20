package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1209 {

   static  class pair {
        Character ch;
        int count;

        pair(char item, int count) {
            this.ch = item;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Deque<pair> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop();
                }
            } else {
                st.push(new pair(ch, 1));
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            pair p = st.pop();

            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.reverse().toString();
    }
}
