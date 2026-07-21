class StockSpanner {

    public class Pair{
        int price;
        int span;
        public Pair(int price, int span){
        this.price = price;
        this.span = span;
    }
    }
    
    Stack<Pair> stack = new Stack<Pair>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().price <= price){
            Pair p = stack.pop();
            span = span + p.span;
        }
        stack.push(new Pair(price,span));

        return span;
    }
}

/**

 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */