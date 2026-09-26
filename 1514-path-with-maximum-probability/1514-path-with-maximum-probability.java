class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<double[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph[u].add(new double[]{v,prob});
            graph[v].add(new double[]{u,prob});
        }
        double[] probability = new double[n];
        PriorityQueue<Pair> heap =  new PriorityQueue<>((a,b) -> Double.compare(b.prob,a.prob));
        heap.offer(new Pair(1.0,start_node));
        probability[start_node] = 1.0;
        while(!heap.isEmpty()){
            Pair  current = heap.poll();
            double prob = current.prob;
            int node = current.node;

            for(int i =0; i<graph[node].size(); i++){
                double[] edge = graph[node].get(i);

                int neigh = (int)edge[0];
                double edgeProb = edge[1];

                double newProb = edgeProb * prob;

                if(newProb > probability[neigh]){
                    probability[neigh] = newProb;
                    heap.offer(new Pair(newProb,neigh));
                }
            }
        }
        return probability[end_node];
    }
}
class Pair{
    double prob;
    int node;

    Pair(double prob, int node){
        this.prob = prob;
        this.node = node;
    }
}