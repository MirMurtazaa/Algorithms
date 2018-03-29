
public class Permutation {

	PNode element;
	
	public PNode findlm(){
		
		PNode temp;
		PNode Head =DPNode.Head;
		temp=Head;
		while(temp.next!=null){
			
			if(temp.key<temp.next.key){
				element=temp.next;
			}
			temp=temp.next;
		}
		return element;
		
	}
	
	
}
