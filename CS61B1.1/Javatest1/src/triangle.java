
public class triangle {

	public static String draw(int x){
		String s ;
		s="";
		while(x>0){
			int y ;
			y = x;
			while(y>0){
			s+="*";
			y-=1;
			}
			s+="\n";
			x-=1;
	}
		return s;}
	
	public static int max(int[] m) {
		int maxN,n;
		maxN=0;
		n = m.length;
		while(n-1>0){
			if (m[n-1]>maxN)
				maxN = m[n-1];
			n-=1;
		}
		
	       return maxN;
	   }
	
	public static void main(String[] args) {
		
		System.out.println("jj");
		System.out.println(draw(5));
		
		int[] nums= new int[]{9,23,20};
		System.out.println(max(nums));

	}

}
