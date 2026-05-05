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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        tree = new ArrayList[n + 1];
        subordinates = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
    }