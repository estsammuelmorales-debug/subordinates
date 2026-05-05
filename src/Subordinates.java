import java.io.*;
import java.util.*;

public class Subordinates {

    static List<Integer>[] tree;
    static int[] sub;

    static void dfs(int node) {
        for (int child : tree[node]) {
            dfs(child);

            sub[node] += sub[child] + 1;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        sub = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(input[i - 2]);
            tree[boss].add(i);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sub[i]).append(" ");
        }

        System.out.println(sb);
    }
}