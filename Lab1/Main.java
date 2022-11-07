package Lab1;


public class Main {

	public static void main(String[] args) {
		System.out.println("vdef: " + Vector.vdef);
		
		Vector v1 = new Vector();
		System.out.println("v1: " + v1);
		
		Vector.setDefault(new Vector(1.0, 2.0, 3.0));
		v1.setToDefault();
		System.out.println("\nv1: " + v1);
		
		Vector v2 = new Vector(1.0, 1.0, 2.0);
		System.out.println("\nv2: " + v2);
		
		System.out.println("\nv1: Length: " + v1.length());
		
		double[][] m1 = {{1.0,0.0,0.0}, {0.0,1.0,0.0}, {0.0,0.0,1.0}};
		System.out.println("\nm1 * v1: " + v1.matrixMult(m1));
		
		double[][] m2 = {{1.0,0.0}, {0.0,1.0}};
		System.out.println("\nm2 * v1: " + v1.matrixMult(m2));
		
		double[][] m3 = {{0.0,1.0,0.0}, {1.0,0.0,0.0}, {0.0,0.0,1.0}};
		System.out.println("\nm3 * v1: " + v1.matrixMult(m3));
		
		System.out.println("\nv1 + v2: " + Vector.plus(v1, v2));
		
		System.out.println("\nv1 - v2: " + Vector.minus(v1, v2));
		
		System.out.println("\n2 * v1: " + v1.mult(2));
		
		System.out.println("\nv1 * v2: " + v1.mult(v2));
		
		System.out.println("\n Length compare v1 and v2: " + v1.compareTo(v2));
		
		v1.norm();
		v2.norm();
		
		System.out.println("\nv1 * v2: " + v1.mult(v2));
		System.out.println("\nv2 * v2: " + v2.mult(v2));
		
	}
			

}
