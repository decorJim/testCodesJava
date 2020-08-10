import java.util.ArrayList;

public class Node {

    private int id_;
    private ArrayList<Edge> neighboors_=new ArrayList<Edge>();
    private boolean state_;

    public int getID() {
        return id_;
    }
    public ArrayList<Edge> getNeighboors() {
        return neighboors_;
    }
    public boolean getState() {
        return state_;
    }
    public void addEdge(Edge edge) {
        neighboors_.add(edge);
    }
    public void setID(int id) {
        id_=id;
    }
    public void setState(boolean state) {
        state_=state;
    }

    
}