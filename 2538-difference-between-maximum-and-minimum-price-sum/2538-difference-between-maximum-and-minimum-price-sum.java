class Solution {
    List<Integer>[] graph;
    int[] price;
    long[] down;
    long answer = 0;
    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        graph = new ArrayList[n];
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        down = new long[n];

        dfs1(0,-1);
        dfs2(0,-1,0);
        return answer;
    }
    void dfs1(int node, int parent){
        down[node] = price[node];

        for(int neighbor : graph[node]){
            if(neighbor == parent){
                continue;
            }

            dfs1(neighbor,node);

            down[node] = Math.max(
                down[node], price[node] + down[neighbor]
            );
        }
    }

    void dfs2(int node, int parent, long up){
        long best = price[node] + Math.max(down[node] - price[node], up);

        answer = Math.max(answer, best - price[node]);

        long best1 = 0;
        long best2 = 0;
        for(int neighbor : graph[node]){
            if(neighbor == parent){
                continue;
            }

            long value = down[neighbor];

            if(value > best1){
                best2 = best1;
                best1 = value;
            } else if(value > best2){
                best2 = value;
            }
        }

        for(int neighbor : graph[node]){
            if(neighbor == parent){
                continue;
            }

            long use;

            if(down[neighbor] == best1){
                use = best2;
            } else{
                use = best1;
            }

            long newUp = price[node] + Math.max(up,use);

            dfs2(neighbor,node,newUp);
        }

    }

}