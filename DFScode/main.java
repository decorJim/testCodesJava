import java.util.ArrayList;

public class main {

    public static boolean checkGraph() {
        for(int i=0;i<GraphElements.size();i++) {
            if(GraphElements.get(i).getState()==false) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNeighboors(Node node) {
        boolean allVisited=true;
        for(int i=0;i<node.getNeighboors().size();i++) 
         {
            if(node.getNeighboors().get(i).getNode().getState()==false) 
            {
              allVisited=false;
              return allVisited;
            }
         }
        return allVisited;
    }

    public static void backTrack(Node node) 
    {
        Node previousNode=new Node();

      
        if(checkNeighboors(node)==true)
        {
            for(int i=dfsOrder.size()-1;i>0;i--) 
            {
                if(dfsOrder.get(i).getID()==node.getID()) 
                {
                    previousNode=dfsOrder.get(i-1);
                    System.out.println("previous node "+previousNode.getID());
                    System.out.println(previousNode.getState());
                    backTrack(previousNode);
                }
            } 
        }
        if(checkNeighboors(node)==false) {
            dfs(node);
        }
        
    }

    public static void findNextNode(Node node) 
    {
       Node nextNode=new Node();
       
       boolean NeighboorsVisited=true;
       int minID=1000;
       for(int i=0;i<node.getNeighboors().size();i++) {
           if(node.getNeighboors().get(i).getNode().getState()==false && node.getNeighboors().get(i).getNode().getID()<minID ) {
               minID=node.getNeighboors().get(i).getNode().getID();
               NeighboorsVisited=false;
               nextNode=node.getNeighboors().get(i).getNode();
               dfs(nextNode);
           }
       }
       
       if(NeighboorsVisited==true && checkGraph()==false) 
       {
         backTrack(node);
       }
       
    }

    public static void dfs(Node node) {
        if(checkGraph()==false) {
           if(node.getState()==false) 
           {   
             node.setState(true);
             dfsOrder.add(node);
             System.out.println(node.getID());
             System.out.println(node.getState());
           }
           if(node.getState()==true) 
           {
             findNextNode(node);
           }
        }
    }


    static ArrayList<Node> dfsOrder=new ArrayList<Node>();
    static ArrayList<Node> GraphElements=new ArrayList<Node>();
    public static void main(String[] args) {

        // node creation
        Node n0=new Node();
        n0.setID(0);
        Node n1=new Node();
        n1.setID(1);
        Node n2=new Node();
        n2.setID(2);
        Node n3=new Node();
        n3.setID(3);
        Node n4=new Node();
        n4.setID(4);
        

        // fill in graph array
        GraphElements.add(n0);
        GraphElements.add(n1);
        GraphElements.add(n2);
        GraphElements.add(n3);
        GraphElements.add(n4);
        
        // Edge creation
        Edge e0=new Edge();
        e0.setNode(n1);
        Edge e1=new Edge();
        e1.setNode(n0);

        Edge e2=new Edge();
        e2.setNode(n2);
        Edge e3=new Edge();
        e3.setNode(n0);

        Edge e4=new Edge();
        e4.setNode(n3);
        Edge e5=new Edge();
        e5.setNode(n1);

        Edge e8=new Edge();
        e8.setNode(n4); 
        Edge e9=new Edge();
        e9.setNode(n2);
        
       

        // fill node's associate edge
        n0.addEdge(e0);
        n0.addEdge(e2);

        n1.addEdge(e1);
        n1.addEdge(e4);

        n2.addEdge(e3);
        n2.addEdge(e8);

        n3.addEdge(e5);
    
        n4.addEdge(e9);

        dfs(n0);

        System.out.println("");
        System.out.println("inside dfsOrder");
        for(int i=0;i<dfsOrder.size();i++) {
            System.out.println(dfsOrder.get(i).getID());
            System.out.println(dfsOrder.get(i).getState());
        }

        System.out.println("");
        System.out.println("graph state");
        System.out.println(checkGraph());

    }

}