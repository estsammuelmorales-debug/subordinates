import java.io.*;
import java.util.*;

public class Subordinates {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] boss = new int[n + 1];
        int[] hijosPendientes = new int[n + 1];
        int[] sub = new int[n + 1];

        if (n > 1) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 2; i <= n; i++) {
                int b = Integer.parseInt(st.nextToken());
                boss[i] = b;
                hijosPendientes[b]++;
            }
        }

        Deque<Integer> cola = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (hijosPendientes[i] == 0) {
                cola.add(i);
            }
        }

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (actual == 1) continue;

            int miJefe = boss[actual];
            sub[miJefe] += sub[actual] + 1;
            hijosPendientes[miJefe]--;

            if (hijosPendientes[miJefe] == 0) {
                cola.add(miJefe);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sub[i]).append(" ");
        }
        System.out.println(sb);
    }
}