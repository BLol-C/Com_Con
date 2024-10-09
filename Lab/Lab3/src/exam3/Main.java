package exam3;

public class Main {

	public static void main(String[] args) {
		Box b1 = new Box(3,4,5);
		
		System.out.println(b1.getVolume());
		resizeBox(b1,2);
		System.out.println(b1.getVolume());

	}

	public static void resizeBox(Box b,int fold) {
		b.depth *= fold;
		b.height *= fold;
		b.width *= fold;
	}
	
}
