
import java.util.*;
public class Graph7 {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    public static void topsortutil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr]=true;
        
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);

            if(!vis[e.dest]){
                topsortutil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }
    public static void topsort(ArrayList<Edge> graph[],int V){
        boolean vis[]=new boolean[V];
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
                topsortutil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    public static void main(String args[]){
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        topsort(graph,V);
    }
}