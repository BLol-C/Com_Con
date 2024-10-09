package exam1;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student(97000,"A",3.51);
		Student st2 = new Student(98000, 3.22);
		Undergrad u1 = new Undergrad(98000,"B",2.91,"Junior");
		Graduate g1 = new Graduate(200000,"C",3.57,"Algorithms and Complexity");
		
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(u1);
		System.out.println(g1);
	}

}
