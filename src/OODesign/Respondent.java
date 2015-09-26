package OODesign;

import java.util.ArrayList;

public class Respondent extends Employee{

	protected int limit = 10;
	
	public Respondent() {
		// TODO Auto-generated constructor stub
		super.id = "Respondent";
		super.list = new ArrayList<Man> ();
	}

	public void addEmployee(Man man) {
		list.add(man);
	}
	
	public boolean isFull() {
		return list.size() == limit;
	}
	
	public void goWork() {
		Man man = list.remove(list.lastIndexOf(list));
		man.goBusy();
	}
}
