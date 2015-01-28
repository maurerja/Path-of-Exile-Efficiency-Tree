package PathFinding;

import java.util.ArrayList;

public class Group implements IGroup {
	public int groupId;
	private ArrayList<Integer> group;
	private boolean isClosed;
	
	public Group(int id){
		this.group = null;
		this.groupId = id;
		this.isClosed = false;
	}
	
	public Group(int id, ArrayList<Integer> group){
		this.group = group;
		this.groupId = id;
		this.isClosed = false;
	}

	@Override
	public ArrayList<Integer> getGroup() {
		return this.group;
	}

	@Override
	public void setGroup(ArrayList<Integer> nodeArray) {
		this.group = nodeArray;

	}

	@Override
	public void addMember(int n) {
		this.group.add(n);

	}

	@Override
	public boolean isClosed() {
		return false;
	}

}
