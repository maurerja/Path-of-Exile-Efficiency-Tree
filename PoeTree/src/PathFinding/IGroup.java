package PathFinding;

import java.util.ArrayList;

public interface IGroup {
	
	public ArrayList<Integer> getGroup();
	public void setGroup(ArrayList<Integer> ids);
	public void addMember(int n);
	public boolean isClosed();
}
