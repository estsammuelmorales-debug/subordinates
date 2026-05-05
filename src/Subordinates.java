import java.util.*;

public class Subordinates {

    static List<Integer>[] tree;
    static int[] subordinates;

    static void dfs(int node) {
        for (int child : tree[node]) {
            dfs(child); 

            subordinates[node] += subordinates[child] + 1;
        }
    }
}