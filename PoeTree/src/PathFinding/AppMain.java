package PathFinding;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AppMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		HashMap<Integer,INode> hm = new HashMap<>();
		BufferedReader read = new BufferedReader(new FileReader("docs\\poebuilderscript.txt"));
		String line = "";
		Boolean setMap = false;
		Boolean setData = false;
		while((line= read.readLine())!=null){
			if (line.length()>8 && line.substring(0, 7).equals("5:[func")){setMap = true;continue;}
			if (setMap){
				String[] s = line.split("],");
				for (String b : s){
					b=b.replace('[',',');
					b=b.replaceAll(":", "");
					if(b.contains("]"))b= b.substring(0,b.length()-2);
					String[] temp = b.split(",");
					int newNodeId = Integer.parseInt(temp[0]);
					ArrayList<Integer> nb = new ArrayList<Integer>();
					for(int i =1; i<temp.length;i++){
						nb.add(Integer.parseInt(temp[i]));
					}
					INode n = new Node(newNodeId,nb);
					hm.put(newNodeId, n);
				}
				setMap = false;
			}
			if(line.length()>8 && line.substring(0,7).equals("6:[func")){setData = true;continue;}
			if(setData){
				String[] s = line.split("\\},\\{");
				for(String b : s){
					int id = Integer.parseInt(b.substring(b.indexOf(":")+1,b.indexOf(",")));
					b = b.substring(b.indexOf(",")+1);
					String name = b.substring(b.indexOf("\"")+1,b.indexOf("\","));
					b = b.substring(b.indexOf("\",")+2);
					ArrayList<String> mods = new ArrayList<>();
					while(b.charAt(0)!=']'){
						b = b.substring(b.indexOf("\"")+1);
						mods.add(b.substring(0,b.indexOf("\"")));
						b = b.substring(b.indexOf("\"")+1);
					}
					b = b.substring(b.indexOf(",")+1);
					// offset data starts here
					b = b.substring(b.indexOf("},")+2);
					//location data starts here
					double xCord = Double.parseDouble(b.substring(b.indexOf("x:")+2,b.indexOf(",")));
					double yCord = Double.parseDouble(b.substring(b.indexOf("y:")+2,b.indexOf("}")));
					b = b.substring(b.indexOf("},")+2);
					//type data here
					int type = Integer.parseInt(b.substring(b.length()-1));
					INode n = hm.get(id);
					Point p = new Point();
					p.x = (int)xCord;
					p.y = (int)yCord;
					IAttributes attr = new Attributes(name,mods,p,type);
					n.setAttributes(attr);
				}
				setData = false;
			}
		}
		
		read.close();
	}

}
