package PathFinding;

import java.util.ArrayList;

public interface INode {
	public ArrayList<Integer> getNeighbors();
	public void setNeighbors(ArrayList<Integer> n);
	public int getId();
	public IAttributes getAttributes();
	public void setAttributes(IAttributes attr);
}
