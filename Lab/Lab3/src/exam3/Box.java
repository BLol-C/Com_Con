package exam3;

public class Box {
	public double width;
	public double height;
	public double depth;
	
	public Box(double w, double h, double d) {
		this.width = w;
		this.height = h;
		this.depth = d;
	}
	
	public double getVolume() {
		return width*height*depth;
	}	

}
