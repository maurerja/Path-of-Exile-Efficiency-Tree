package PathFinding;

import java.awt.Point;
import java.util.ArrayList;

public class Attributes implements IAttributes {
	
	private String name;
	private ArrayList<String> mods;
	private Point position;
	private int type;

	public Attributes(String n,ArrayList<String> m,Point p,int t){
		this.name = n;
		this.mods = m;
		this.position = p;
		this.type = t;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public ArrayList<String> getMods() {
		return this.mods;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public int getType() {
		return this.type;
	}

}
