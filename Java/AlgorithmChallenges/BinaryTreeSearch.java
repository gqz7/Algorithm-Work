import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
public class Solution { 

	private static class Node {
		Node left, right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

	private static Node insert(Node node, int data) {
		if (node==null) {
			node = new Node(data);
		}
		else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			}
			else {
				node.right = insert(node.right, data);
			}
		}
		return(node);
	}

	public static void main(String [] args) throws Exception{ 
		Scanner in = new Scanner(System.in);
		Node _root;
		int root_i=0, root_cnt = 0, root_num = 0;
		root_cnt = in.nextInt();
 _root=null;
for(root_i = 0; root_i < root_cnt; root_i++){
        root_num = in.nextInt();
        if( root_i == 0)
          _root = new Node(root_num);
        else           
        	insert(_root, root_num);
}
	
        int q = in.nextInt();
        
        for (int i = 0; i < q; i++) {
		  int _x = in.nextInt();
		  System.out.println(isPresent(_root,_x));
        }
        
		return;
	}

private static int isPresent(Node root, int val){
/* For your reference
class Node {
		Node left, right;
		int data;
                Node(int newData) {
			left = right = null;
			data = newData;
		}
	}
*/
    //recursive solution
    if (val == root.data) return 1;
    Node searchNode = 
        val < root.data 
        ? root.left 
        : root.right;
    
    if (searchNode == null) return 0;
    return isPresent(searchNode, val);
    
    //programatic solution
    // Node searchNode = root;
    // while (true) {
    //     if (searchNode == null) return 0; 
    //     if (searchNode.data == val) return 1;
    //     if (val < searchNode.data) {
    //         searchNode = searchNode.left;
    //     } else {
    //         searchNode = searchNode.right;            
    //     }
    // }
    
    
}
}  