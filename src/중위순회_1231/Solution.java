package 중위순회_1231;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Node{
    String data;
    Node left;
    Node right;
    Node parent;
    int order;
  
    public Node(int b){
        this.order = b;
    }
}
 
class Tree{
    int count = 0;
    Node root;
    Node parent;
    Node current;
    Queue<Node> qu = new LinkedList<Node>();
  
    public Tree (int a){
        this.count = a;
    }
    public void setRoot(Node d) {
        this.root = d;
    }
  
    public Node getRoot() {
        return this.root;
    }
    public Node inorderNode() {
        Node a = root;
        while(a.left != null) {
            a = a.left;
        }
        return a;
    }
  
    public int createTree() {
        int x = 1;
        while(count+1 != x) {
            Node n = new Node(x);
            if(this.root == null) {
                this.root = n;
                this.current = this.root;
                qu.add(n);
                x++;
                continue;
            }
    
    if(this.current.left == null) {
        this.current.left = n;
        n.parent = this.current;
        x++;
        qu.add(n);
        if(count+1 == x) {
            this.current = this.current.left;
        }
        continue;
    }
    if(this.current.right == null) {
        this.current.right = n;
        n.parent = this.current;
        x++;
        qu.add(n);
        if(count+1 == x) {
            this.current = this.current.right;
        }
        continue;
      }
    if(this.current.left != null && this.current.right != null) {
        qu.poll();
        current = qu.peek();
    }
        }
        return 0;
    }
}
 
public class Solution {
    private static Tree tr;
    private static int ans;
    private static int n;
    private static int l;
    private static String[] ar;
  
    public static void bfs(Node no) { 
        if(no != null) {
            bfs(no.left);
            System.out.print(ar[no.order - 1]);
            bfs(no.right);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int m = sc.nextInt();
            sc.nextLine();
            tr = new Tree(m);
            ar = new String[m];
            tr.createTree();
            for(int j = 0; j < m; j++) {
                String[] s = sc.nextLine().split(" ");
                switch(s.length) {
                case 4:
                    ar[Integer.parseInt(s[0]) - 1] = s[1];
                    break;
                case 3:
                    ar[Integer.parseInt(s[0]) - 1] = s[1];
                    break;
                case 2:
                    ar[Integer.parseInt(s[0]) - 1] = s[1];
                    break;
                }
                 
            }
            System.out.printf("#%d ",i);
            bfs(tr.root);
            System.out.println();
        }
    }
}
