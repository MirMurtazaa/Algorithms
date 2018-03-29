
public class PNode {   //permutating node.

	int key;		//for comparison
	char value;		//for actual value
	char dir;		//for mobility
	PNode next;
	PNode prev;
	
	PNode(int k,char v, char d){
		this.key=k;
		this.value=v;
		this.dir=d;
		
	}
	
	
}
