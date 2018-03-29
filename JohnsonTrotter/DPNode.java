import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DPNode {  //doubly permutating node

	public static PNode Head;			//starting point
	
	ArrayList<PNode> element = new ArrayList<PNode>();   //Alist
	
	Boolean mobe=true;
	static Boolean alpha=false;

	
	DPNode(){}			//constructor
	
	public void insert(int k,char v,char d){		//insertion in doubly linklist
		
		PNode newNode = new PNode(k,v,d);		//new node 
		PNode temp = newNode;					//temp for searching and putting newNode at the next empty place
		
		if(Head==null){							//initially head will be empty
		
			Head=temp;							// head is replaced by temp which is the new Node
	
			
		}
		
		else{
			
			temp =Head;					//looks for empty place in the while loop
			
			while(temp.next!=null){
				temp=temp.next;				//keep on moving next for empty place
				
			}
			
			if(temp==Head && temp.next==null){
				temp.next=newNode;				//placing in second position
				newNode.prev=temp;
				
			}
			else {
				newNode.prev=temp;
				temp.next = newNode;			//placing in nth position
				
			}
			
			
		}
		
	}
	
public void Permutations(){
		
		PNode mobile;
		int v=2;
		
		while(mobe==true){
			mobile = findlm();
			
			if(mobe){
				System.out.println(" Permutaion number: " + v);
//			System.out.println("6");
			if(mobile.dir=='<'){
			swap(mobile,mobile.prev);
			}
			else{
				swap(mobile.next,mobile);
			}
			ChngDir(mobile);
			display();
			System.out.println();
			element.removeAll(element);
			v++;
			}
			else
				break;
			
		}
		
		
	}

	
	public PNode findlm(){
	
		int lm;
		PNode lmob;
		boolean once=false;
		PNode temp;
		temp=Head;
		while(temp!=null){
			
			switch (temp.dir){
				case '<':
					
			if(temp==Head){
				
			}		
			else{
			if(temp.key>temp.prev.key){   //points towards smaller no. 2<-3
				element.add(temp);					//mob_element=3
//				System.out.println("add" + temp.key);
				mobe=true;							//for the stopping cond.
				once=true;							//found a mob_el
			}
			}
			break;
				case '>':
					
			if(temp.next==null){
			
			}
			else if(temp.key>temp.next.key){  //mobility 3->2
				element.add(temp);
//				System.out.println("add" + temp.key);
				mobe=true;
				once=true;
			}
		
			break;
			}
//			System.out.println("here");
			temp=temp.next;
			
		}
		
		if(once==false){				//no mob_e
			mobe=false;
		}
		else{
		for(int i=0;i<element.size();i++){
//			System.out.print("    Eleme  " +element.get(i).key  );
		}
//		System.out.println("E.key "+ element.key+" mobe "+mobe);
		lm=element.get(0).key;
		lmob=element.get(0);
		for(int i=1;i<element.size();i++){
			if(element.get(i).key>lm){
				lm=element.get(i).key;
				lmob=element.get(i);
				
			}
			else
				continue;
		}
//		System.out.println(" E " + lmob.key);
		return lmob;
		}

		return null;
		
	}
	

	
	public void swap(PNode element,PNode Prev){
		//PNode temp = element;
		
	
//		System.out.println("elP " + element.prev.key);
		
		
//		System.out.println("SW"+ element.key + " " + Prev.key);
		if(mobe==true){
			//System.out.println("Prevnext "+ Prev.next.key+" Enext "+element.next.key);
			
			
			if(element.next==null){				// replacing 2,3 in 1,2,3 elem=3  Prev=2
//				System.out.println("IF ");		//1,3,2
				
				element.next=Prev;				//3.next= 2
				element.prev=Prev.prev;			//3.prev=2
				Prev.prev.next=element;			//1.next=3
				Prev.prev=element;				//2.prev=3
				Prev.next=null;					//2.next={};
//				System.out.println("99 ");
			}
			
			else if(element.prev==null){
//				System.out.println("55 ");
				element.prev=element.next;
				element.next=Prev.next;
				Prev.next.prev=element;
				Prev.next=element;
				Head=Prev;
				
				
				
			}
			
			else if(element.prev.prev==null) {   //1,3,2 prev.prev=null
//				System.out.println("22");
//				System.out.println("pppp" + element.prev.key);
//				System.out.println("ELSE ");	//1,3,2 ---> 3,1,2
				Prev.next=element.next;     	//1.prev=2
				element.next.prev=Prev;			//2.prev=1
				element.next=Prev;				//3.next=1
				Prev.prev=element;				//1.prev=3
				Head=element;					//3 is new Head
				element.prev=null;
				
		
			}
			
			else{			//swapping in between
				
				element.next.prev=Prev;
				Prev.next = element.next;
				element.next=Prev;
				element.prev=Prev.prev;
				Prev.prev.next=element;
				Prev.prev=element;
				
			}
			
			
			
		//System.out.println("Prevnext "+ Prev.next.key+" Enext "+element.next.key);
		
		}

	}
	
	public void ChngDir(PNode Node){
		
		PNode temp=Head;
		while(temp!=null){
			if(temp.key>Node.key){
				
				if(temp.dir=='>'){
	
					temp.dir='<';
				}
				else{
				
					temp.dir='>';
				}
			}
			
			else{
				
			}
			
			
			temp=temp.next;
		}
	
}
	
	
	public void display(){
		
		PNode temp = Head;
		while(temp!=null && mobe==true){
			if(alpha==false){
		System.out.print(temp.key+"  ");
			}
			else{
				System.out.print(temp.value+"  ");	
			}
		/*
			else{
			System.out.print(" "+temp.key + " "+temp.dir+" ");
			}
					
				if(temp.next==null){
				
					System.out.println(" tempkey "+temp.key +" "+" tempprev "+temp.prev.key );
					
				}
				
				
			else if(temp.prev!=null){
				System.out.println(" tempkey "+temp.key +" "+" tempnext "+temp.next.key +" tempprev "+temp.prev.key );
					
			}
			else{
			System.out.println("tempkey "+temp.key +" "+" tempnext "+temp.next.key);
	*/
			
			temp=temp.next;
			
		}
	}
	
	
}
