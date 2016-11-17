import java.util.*;

class digraph{
    private LinkedList<Integer>[]adj;
    private int v;
    private int E;
    public digraph(int v){
        this.v=v;
        this.E=0;
        this.adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            this.adj[i]=new LinkedList<Integer>();
            
        }
    }
     public void addEdge(int v,int w){
            this.adj[v].add(w);
            this.E++;
        }
        public int v(){
            return this.v;
        }
        public int E(){
            return this.E;
        }
        public Iterable<Integer> adj(int v){
            return this.adj[v];
        }
}

class DFS{

    private boolean []marked;
    private int [] edgeTo;

    public DFS(digraph g,int s){
        marked =new boolean[g.v()];
        edgeTo =new int [g.v()];
        for(int i=0;i<g.v();i++){
            edgeTo[i]=Integer.MAX_VALUE;
        }
        dfs(g,s);
    }
    /*private DFS(Graph g,int s){
        marked =new boolean[g.v()];
        DFS(g,s);
    }*/
    private void dfs(digraph g,int v){
        marked[v]=true;
        for(int w:g.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(g,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
}
class BFS{
    private boolean []marked;
    private int [] edgeTo;

    public BFS(digraph g,int s){
        marked =new boolean[g.v()];
        edgeTo =new int [g.v()];
        for(int i=0;i<g.v();i++){
            edgeTo[i]=Integer.MAX_VALUE;
        }
        bfs(g,s);
    }

}
public class DirGraph{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        digraph dg=new digraph(5);
        for(int i=0;i<x;i++){
            dg.addEdge(sc.nextInt(),sc.nextInt());
        }
        DFS df=new DFS(dg,0);
        System.out.println(df.hasPathTo(3));
    }
}