package PathFinding;

import java.util.ArrayList;

public class Node implements INode{
	private ArrayList<Integer> neighbors;
	private IAttributes attr;
	private int id;
	
	public Node(int id, ArrayList<Integer> nodes){
		this.setId(id);
		this.setNeighbors(nodes);
	}
	
	@Override
	public void setNeighbors(ArrayList<Integer> n){
		this.neighbors= n;
	}

	@Override
	public ArrayList<Integer> getNeighbors() {
		return this.neighbors;
	}

	@Override
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	@Override
	public IAttributes getAttributes() {
		return this.attr;
	}

	@Override
	public void setAttributes(IAttributes attr) {
		this.attr = attr;
	}

}
