
public class AI {
	Node root;
	Node insert(String keys,Node p) {
		String key = null;
		if(p==null) {
			return new Node(key);
		}
		int x=key.compareTo(p.data);
		if(x>0) {
			p.right=insert(key,p.right);
		}
		else if(x<0){
			p.left=insert(key,p.left);
		}
		else {
			;
		}
		return p;
	}
	void main() {
		root=insert("m",root);
		root=insert("b",root);
		root=insert("u",root);
		root=insert("p",root);
		root=insert("l",root);
		root=insert("a",root);
		root=insert("q",root);
		root=insert("t",root);
		root=insert("z",root);
		root=insert("e",root);
		root=insert("f",root);
		root=insert("o",root);
		BFS(root,"o");
	}
	void inorder(Node node) {
		if(node!=null) {
			return;
		}
		else {
			queued.add(node);
			for(int i=0;i<queued.size();i++)
			{
				if(queued.get(i).data.compareTo(ch)==0) {
					for(int j=0;j<queued.size();j++) {
						System.out.println()
					}
				}
			}
		}
	}
}
