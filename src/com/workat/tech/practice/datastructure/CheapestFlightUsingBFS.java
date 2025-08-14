package com.workat.tech.practice.datastructure;

import java.util.*;

public class CheapestFlightUsingBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Number of hubs
        int M = sc.nextInt(); // Number of routes

        //Build adjacency list for the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < N; i++) {
            graph.put(i, new java.util.ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            int from = sc.nextInt(); // Start hub
            int to = sc.nextInt(); // Destination hub
            int price = sc.nextInt(); // Cost of the flight
            graph.get(from).add(new int[]{to, price});
        }

        int src = sc.nextInt(); // Source hub
        int dest = sc.nextInt(); // Destination hub
        int k = sc.nextInt(); // Maximum number of stops
        int result = findCheapestFlight(N, graph, src, dest, k);

        if(result == -1) {
            System.out.println("No route available");
        } else {
            System.out.println(result);
        }
    }

    private static int findCheapestFlight(int N, Map<Integer, List<int[]>> graph, int src, int dest, int K) {

        //Min-heap : cost so far, current hub, stops
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.cost));
        pq.offer(new Route(src, 0, 0));

        //Track minimum cost to reach a hub with a given stops count
        int[][] mimCost = new int[N][K+2];
        for(int[] row : mimCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        mimCost[src][0] = 0;

        while(!pq.isEmpty()) {
            Route current = pq.poll();
            if(current.hub == dest) {
                return current.cost; // Found the cheapest flight to destination
            }
            if(current.stops > K)  continue; // Exceeded the maximum number of stops

            for(int[] next : graph.get(current.hub)) {
                int nextHub = next[0];
                int newCost = current.cost + next[1];
                int newStops = current.stops + 1;

                if(newStops <= K+1 && newCost < mimCost[nextHub][newStops]) {
                    mimCost[nextHub][newStops] = newCost;
                    pq.offer(new Route(nextHub, newCost, newStops));
                }
            }
        }
        return -1; // No route found within the given stops
    }

    static class Route {
        int hub;
        int cost;
        int stops;
        Route(int hub, int cost, int stops) {
            this.hub = hub;
            this.cost = cost;
            this.stops = stops;
        }
    }
}
