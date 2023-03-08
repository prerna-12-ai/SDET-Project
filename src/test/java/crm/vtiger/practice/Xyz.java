package crm.vtiger.practice;

public class Xyz {
	String a="abc";
	
	public static void main(String[] args) {
//		System.out.println(a);
		Xyz x=new Xyz();
		System.out.println(x.aa());
		System.out.println(Xyz.class);
	}
	
	
public String aa() {
	System.out.println(this);
	return this.a;
}
}
