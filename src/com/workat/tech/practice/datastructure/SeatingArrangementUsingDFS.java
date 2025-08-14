package com.workat.tech.practice.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatingArrangementUsingDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] likes = new int[N];
        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            likes[i] = val - 1; // convert from 1-based to 0-based
        }
        System.out.println("Output: " + maxCEOs(N, likes));
    }

    public static int maxCEOs(int N, int[] likes) {
        boolean[] visited = new boolean[N];
        boolean[] inStack = new boolean[N];
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                maxCount += dfs(i, likes, visited, inStack);
            }
        }
        return maxCount;
    }

    private static int dfs(int node, int[] likes, boolean[] visited, boolean[] inStack) {
        int count = 0;
        List<Integer> path = new ArrayList<>();
        int curr = node;

        while (!visited[curr]) {
            visited[curr] = true;
            inStack[curr] = true;
            path.add(curr);
            curr = likes[curr];
        }

        if (inStack[curr]) {
            int idx = path.indexOf(curr);
            count = path.size() - idx;
        }

        for (int p : path) {
            inStack[p] = false;
        }

        return count;
    }
}
