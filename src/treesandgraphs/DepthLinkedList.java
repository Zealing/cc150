package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class DepthLinkedList {
	
	//using arraylist as the list of every level's linked list--DFS
	private void DepthLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		// TODO Auto-generated constructor stub
		if (root == null) {//----base case
			return;
		} 
		
		LinkedList<TreeNode> list = null;
		if (list.size() == level) {//if lists has no level create a new one---the size is 5 when depth is 4
			//so when the level 5 equals the size of that lists---means original depth is 4
			list = new LinkedList<TreeNode> ();
			lists.add(list);
		} else {
			list = lists.get(level);//else we could simply let the list manages the lists' level 
		}
		list.add(root);//add the node into the list
		
		DepthLinkedList(root.left, lists, level + 1);
		DepthLinkedList(root.left, lists, level + 1);
		
	}
	
	//the root of that tree should be initialized at this place
	public ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		DepthLinkedList(root, lists, 0);
		
		return lists;
	}
	
	public ArrayList<LinkedList<TreeNode>> createLinkedListBFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
			current = new LinkedList<TreeNode>();
			
			for (TreeNode parent: parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}

}
