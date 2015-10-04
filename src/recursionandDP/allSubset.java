package recursionandDP;

import java.util.ArrayList;
import java.util.Set;

public class allSubset {
	private ArrayList<Set> subsets;
	
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		
		//base case: when index equals to 0---create an empty set
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			//when index > 0
			allsubsets = getSubsets(set, index - 1);
			int item = set.get(index);
			
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			
			for (ArrayList<Integer> subset: allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
				
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public allSubset() {
		// TODO Auto-generated constructor stub
	}

}
