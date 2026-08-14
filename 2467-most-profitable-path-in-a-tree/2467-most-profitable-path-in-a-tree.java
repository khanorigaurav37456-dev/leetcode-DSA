class Solution {
    int answer = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
     int n = amount.length;

     List<List<Integer>> graph = new ArrayList<>();
     for(int i = 0; i<n; i++){
        graph.add(new ArrayList<>());
     }   

     for(int[] edge : edges){
        int a = edge[0];
        int b = edge[1];

        graph.get(a).add(b);
        graph.get(b).add(a);
     }
     List<Integer> bobPath = new ArrayList<>();

     findBobPath(0,-1,bob,graph,bobPath);

     int[] bobTime = new int[n];
     Arrays.fill(bobTime, Integer.MAX_VALUE);

     int time = 0;

     for(int i = bobPath.size()-1; i>=0; i--){
        int node = bobPath.get(i);

        bobTime[node] = time;
        time++;
     }

     dfsAlice(0,-1,0,0,graph,amount,bobTime);
     return answer;
    }
    boolean findBobPath(
        int node,
        int parent,
        int bob,
        List<List<Integer>> graph,
        List<Integer> path
    ){
        path.add(node);
        if(node == bob){
            return true;
        }

        for(int neighbor : graph.get(node)){
            if(neighbor == parent){
                continue;
            }

            if(findBobPath(neighbor,node,bob,graph,path)){
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }
    void dfsAlice(
        int node,
        int parent,
        int aliceTime,
        int income,
        List<List<Integer>> graph,
        int[] amount,
        int[] bobTime
    ){
        if(aliceTime < bobTime[node]){
            income += amount[node];
        } else if(aliceTime == bobTime[node]){
            income += amount[node] /2;
        }

        boolean isLeaf = true;

        for(int neighbor : graph.get(node)){
            if(neighbor != parent){
                isLeaf = false;
                break;
            }
        }

        if(isLeaf){
            answer = Math.max(answer, income);
            return;
        }

        for(int neighbor : graph.get(node)){
            if(neighbor == parent){
                continue;
            }

            dfsAlice(
                neighbor,
                node,
                aliceTime+1,
                income,
                graph,
                amount,
                bobTime
                );
        }
    }
}