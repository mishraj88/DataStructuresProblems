
class Test{

	static Boolean flag;
	public static void main(String args[]){
		int a = 0;
		int b =3;
		int result = (a-b)%8 < 0 ? 8+(a-b)%8 : a-b%8;
		System.out.println("Result: "+result);
		System.out.println("flag: "+flag);
		
		
	}
}
