package arrayPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class IterativeInorderTraversal {
	static Node root;
	int parent = -1, height = 0;
	ArrayList<Integer> sortedData=new ArrayList<Integer>();
	Map<Integer, Map<Integer, Set<Integer>>> myMap = new HashMap<Integer, Map<Integer, Set<Integer>>>();
	int ans = 0;
	int ansRootToLeafSum = 0;
	int result = Integer.MIN_VALUE;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		IterativeInorderTraversal tree = new IterativeInorderTraversal();
		/*
		 * tree.root = tree.new Node(1); tree.root.left = tree.new Node(2);
		 * tree.root.right = tree.new Node(6); tree.root.left.right = tree.new Node(7);
		 * tree.root.left.right.left=tree.new Node(4); tree.root.left.right.right =
		 * tree.new Node(5); tree.root.left.right.right.left = tree.new Node(8);
		 * tree.root.right.left = tree.new Node(3);
		 */
//		tree.root = tree.new Node(10);
//		tree.root.left = tree.new Node(2);
//		tree.root.right = tree.new Node(10);
//		tree.root.left.left = tree.new Node(20);
//		tree.root.left.right = tree.new Node(1);
//		tree.root.right.right = tree.new Node(-25);
//		tree.root.right.right.left = tree.new Node(3);
//		tree.root.right.right.right = tree.new Node(4);
		tree.root = tree.new Node(10);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(12);
		tree.root.left.left = tree.new Node(1);
		// tree.preOrderTraverse();
		// tree.postOrderTraversal();
		// tree.inOrderTraversal();
		// tree.levelOrderTraversal();
		// tree.processLeftView();
		// tree.processRightView();
		// tree.processVerticalView();
		// tree.checkBST(root);
		// tree.levelOrderTraversalWithoutExtraSpace(root);
		// int size=tree.sizeOfTree(root);
		// System.out.println("size is :"+size);
		// tree.isCousins(7,3);
		//int diameter = tree.diameterOfTree(root);
		//System.out.println("diameter is--" + diameter);
		//tree.maxPathSum();
		//tree.validSequence();
		  //tree.kThSmallest(5);
		  //tree.invertBinaryTree();
		 // tree.searchBST(root,10);
		  //tree.rootToleafSum(root,0);
		  //System.out.println(tree.ansRootToLeafSum);
		int count = countCompleteTreeNodes(root);
		System.out.println(count);
	}

	private static int countCompleteTreeNodes(Node root) {
		System.out.println("here");
		if(root == null) {
			return 0;
		}
		int lLevel = 1;
		Node left = root.left;
		while(left != null) {
			left = left.left;
			lLevel++;
		}
		Node right = root.right;
		int rLevel = 1;
		while(right != null) {
			right = right.right;
			rLevel++;
		}
		if(rLevel == lLevel) {
			return (int) Math.pow(2, rLevel)-1;
		}
		int leftCount = countCompleteTreeNodes(root.left);
		int rightCount = countCompleteTreeNodes(root.right);
		return leftCount+rightCount+1;
	}

	private void rootToleafSum(Node root,int currValue) {
		if(root == null) {
			return;
		}
		currValue = currValue * 10 + root.data;
		if(root.left == null && root.right == null) {
			ansRootToLeafSum = ansRootToLeafSum + currValue;
		}
		rootToleafSum(root.left, currValue);
		rootToleafSum(root.right, currValue);
	}

	private void searchBST(Node root, int i) {
		System.out.println("here");
		boolean flag=false;
		if(root == null) {
			return;
		}
		if(root.data==i) {
			flag=true;
		}else if(i<root.data) {
			searchBST(root.left, i);
		}else {
			searchBST(root.right, i);
		}
		if(flag) {
			System.out.println("Present");
		}else {
			System.out.println(" Not Present");
		}
	}

	private void invertBinaryTree() {
		swap(root);
		//System.out.println(root.left.data);
		//System.out.println(root.right.data);
	}

	private void swap(Node root) {
		if(root==null) {
			return;
		}
		swap(root.left);
		swap(root.right);
		Node temp=null;
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		
	}

	private void kThSmallest(int i) {
		inOrderTraversal();
		System.out.println("kth smallest element-----"+sortedData.get(i-1));
		
	}

	private void validSequence() {
		int[] seq = { 10, 2, 20 };
		Boolean result = CheckValidSequence(root, seq, 0);
		System.out.println(result);
	}

	private boolean CheckValidSequence(Node root, int[] seq, int pos) {
		if(root == null) {
			return false;
		}
		if (pos == 0 && !(seq[pos] == root.data)) {
			return false;
		}
		if (pos > seq.length-1 && root.left == null && root.right == null) {
				return false;
		}
		if (root.left == null && root.right == null) {
			if (pos < seq.length - 1) {
				return false;
			}
		}
		if(pos == seq.length-1 && (root.left !=null || root.right != null)) {
			return false;
		}
		if(pos == seq.length-1 && root.left ==null && root.right == null) {
			return true;
		}
		boolean left = CheckValidSequence(root.left, seq, pos + 1);
		boolean right = CheckValidSequence(root.right, seq, pos + 1);
		if(left || right) {
			return true;
		}
		return false;
	}

	private void maxPathSum() {
		calcMaxPathSum(root);
		System.out.println("max path sum----" + result);
	}

	private int calcMaxPathSum(Node root) {
		if (root == null)
			return 0;
		int left = calcMaxPathSum(root.left);
		int right = calcMaxPathSum(root.right);
		int MS = Math.max(Math.max(left, right) + root.data, root.data);
		int M21 = Math.max(MS, left + right + root.data);
		result = Math.max(result, M21);
		return MS;

	}

	private void isCousins(int v1, int v2) {

		int height1 = findParentAndHeight(root, v1, height);
		int parent1 = parent;
		parent = -1;
		int height2 = findParentAndHeight(root, v2, height);
		if (height1 == height2 && parent1 != parent) {
			System.out.println("cousins");
		} else {
			System.out.println("they are not cousins");
		}

	}

	private int findParentAndHeight(Node curr, int v1, int height) {
		if (curr == null) {

			return 0;
		}
		if (curr.data == v1) {
			return height;
		}
		parent = curr.data;
		int left = findParentAndHeight(curr.left, v1, height + 1);
		if (left != 0)
			return left;
		int right = findParentAndHeight(curr.right, v1, height + 1);
		System.out.println();
		return right;
	}

	private void processVerticalView() {

		printVerticalView(root, 0, 0);
		for (Entry<Integer, Map<Integer, Set<Integer>>> e : myMap.entrySet()) {
			Map<Integer, Set<Integer>> data1 = e.getValue();
			for (Entry<Integer, Set<Integer>> e1 : data1.entrySet()) {
				System.out.println(e1);
			}
		}

	}

	private void printVerticalView(Node root, int row, int col) {
		if (root == null) {
			return;
		}
		HashMap<Integer, Set<Integer>> values = new HashMap<Integer, Set<Integer>>();
		Set<Integer> data = new LinkedHashSet<Integer>();
		data.add(root.data);
		values.put(col, data);
		myMap.put(row, values);
		printVerticalView(root.left, row + 1, col - 1);
		printVerticalView(root.right, row + 1, col + 1);

	}

	private void processRightView() {
		Boolean[] levels = new Boolean[201];
		for (int i = 0; i < levels.length; i++) {
			levels[i] = false;
		}
		printRightView(levels, 0, root);
	}

	private void printRightView(Boolean[] levels, int curr, Node root) {
		if (root == null) {
			return;
		}
		if (levels[curr] == false) {
			levels[curr] = true;
			System.out.println(root.data);
		}
		printRightView(levels, curr + 1, root.right);
		printRightView(levels, curr + 1, root.left);

	}

	private int sizeOfTree(Node root) {
		int left = 0, right = 0;
		if (root == null) {
			return 0;
		} else {
			left = left + sizeOfTree(root.left);
			right = right + sizeOfTree(root.right);
		}
		return left + right + 1;
	}

	private void levelOrderTraversalWithoutExtraSpace(Node root) {
		int height = heightOfTree(root);
		System.out.println("height of tree::::::" + height);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
		}

	}

	private void printGivenLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.data);
		} else {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}

	}

	private int heightOfTree(Node root) {
		int leftHeight = 0, rightHeight = 0;
		if (root == null) {
			return 0;
		} else {
			leftHeight = leftHeight + heightOfTree(root.left);
			rightHeight = rightHeight + heightOfTree(root.right);
		}
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}

	}

	private int diameterOfTree(Node root) {
		int leftHeight = 0, rightHeight = 0;
		if (root == null) {
			return 0;
		} else {
			leftHeight = leftHeight + heightOfTree(root.left);
			rightHeight = rightHeight + heightOfTree(root.right);
		}
		ans = Math.max(ans, leftHeight + rightHeight + 1);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	private void checkBST(Node root) {
		if (root == null) {
			return;
		}
		int min = 0, max = 100;
		if (isBST(root.left, min, root.data) && isBST(root.right, root.data, max)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	private boolean isBST(Node root, int min, int max) {
		// NULL is not a node to be checked. So, return true always
		if (root == null) {
			return true;
		}
		if (root.data > min && root.data < max)
			return (isBST(root.left, min, root.data) && isBST(root.right, root.data, max));
		return false;
	}

	private void processLeftView() {
		Boolean[] levels = new Boolean[201];
		for (int i = 0; i < levels.length; i++) {
			levels[i] = false;
		}
		printLeftView(levels, 0, root);

	}

	private void printLeftView(Boolean[] levels, int curr, Node root) {
		if (root == null) {
			return;
		}
		if (levels[curr] == false) {
			levels[curr] = true;
			System.out.println(root.data);
		}
		printLeftView(levels, curr + 1, root.left);
		printLeftView(levels, curr + 1, root.right);

	}

	@SuppressWarnings("unused")
	private void inOrderTraversal() {
		Stack<Node> s = new Stack<>();
		Node curr = root;
		while (!s.empty() || curr != null) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			sortedData.add(curr.data);
			System.out.println(curr.data);
			curr = curr.right;
		}
	}

	private void levelOrderTraversal() {
		Queue<Node> s = new LinkedList<>();
		s.add(root);
		while (!s.isEmpty()) {
			Node data = s.remove();
			System.out.println(data.data);
			if (data.left != null) {
				s.add(data.left);
			}
			if (data.right != null) {
				s.add(data.right);
			}
		}
	}

	@SuppressWarnings("unused")
	private void postOrderTraversal() {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while (!s1.empty()) {
			Node data = s1.pop();
			s2.push(data);
			if (data.left != null) {
				s1.push(data.left);
			}
			if (data.right != null) {
				s1.push(data.right);
			}

		}
		System.out.println();
		while (!s2.isEmpty()) {
			System.out.print(" " + s2.pop().data);
		}

	}

	@SuppressWarnings("unused")
	private void preOrderTraverse() {
		Stack<Node> s = new Stack<>();
		s.push(root);
		while (!s.empty()) {
			Node data = s.pop();
			System.out.print(" " + data.data);
			if (data.right != null) {
				s.push(data.right);
			}
			if (data.left != null) {
				s.push(data.left);
			}

		}

	}

}
