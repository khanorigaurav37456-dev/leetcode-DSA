class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int distance = 0;
        while(!queue.isEmpty()){

            int size = queue.size();

            for(int level =0; level<size; level++){
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            for(int i =0; i<4; i++){
                int r = row + x[i];
                int c = col + y[i];

                if(valid(m,n,r,c) && maze[r][c] == '.'){

                    if(r == 0||r == m-1 || c ==0 || c == n-1){
                        return distance + 1;
                    }
                    maze[r][c] = '+';
                    queue.offer(new int[]{r,c});
                }
            }    
            }
            distance++;
        }
        return -1;
            
        }
        boolean valid(int m, int n,int i,int j){
        return i >= 0 && i <m && j >=0 && j<n;
    }
    }
