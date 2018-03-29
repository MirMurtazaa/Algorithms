import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[]args){
		
		DPNode P = new DPNode();
		
		
		String response;
		String a = " ";
		int n=1;
		int r=1;
		int b='a';
		
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		System.out.println("Generating Permutations:\n JohnsonTrotter Algorithm\n\n ");
		System.out.println("For numbers write n \n For alphabets write a \n\n");
		response =sc.nextLine(); 
	
		
		
		if(response.equals("a")){
//			sc.useDelimiter(" ");
			DPNode.alpha=true;
			System.out.println("Enter alpabets (place spaces,in order,After last alpha write end, "
					+ "for e.g a b c d end)");
			
			while(!a.equals("end")){
//				
				a = sc.next();
				if(!a.equals("end")){
//					System.out.println("cahr "+ a.charAt(0));
			P.insert(n,a.charAt(0),'<');
			n++;
				}
			}
		}
		else{
			DPNode.alpha=false;
//			sc.useDelimiter(" ");
			System.out.println("Enter numbers(place spaces,in ascending order,'After last number write 00')"
					+ " for e.g 1 2 3 4 00 ");
			while(r!=00){
				r=in.nextInt();
				if(r!=00){
			P.insert(r,(char)b,'<');
			b++;
				}
				
			}
		}
		
//		P.insert(1,'a','<');
//		P.insert(2,'b','<');
//		P.insert(3,'c','<');
//		P.insert(4,'d','<');
//		P.insert(5,'e','<');
//		P.insert(6,'f','<');
//		P.insert(7,'g','<');
//		P.insert(8,'h','<');
		System.out.println(" Permutaion number: " + "1");
		P.display();
		System.out.println();
		P.Permutations();
		
	}
	
	
}
