package Lab1;


public class Vector {
	private double x, y, z;
	
	public static Vector vdef = new Vector(0.0, 0.0 ,0.0);

	public Vector() {
		setToDefault();
	}
	
	public Vector(double d1, double d2, double d3) {
		x = d1;
		y = d2;
		z = d3;
	}
	
	public static void setDefault(Vector v) {
		vdef = v;
	}
	public void setToDefault() {
		x = vdef.x;
		y = vdef.y;
		z = vdef.z;
	}
	
	public static Vector plus(Vector arg1, Vector arg2) {
		Vector res = new Vector();
		res.x = arg1.x + arg2.x;
		res.y = arg1.y + arg2.y;
		res.z = arg1.z + arg2.z;
		return res;
	}
	public static Vector minus(Vector arg1, Vector arg2) {
		Vector res = new Vector();
		res.x = arg1.x - arg2.x;
		res.y = arg1.y - arg2.y;
		res.z = arg1.z - arg2.z;
		return res;
	}
	public Vector mult(double arg) {
		Vector res = new Vector();
		res.x = arg*this.x;
		res.y = arg*this.y;
		res.z = arg*this.z;
		return res;
	}
	public double mult(Vector arg) {
		return this.x*arg.x+
				this.y*arg.y+
				this.z*arg.z;
	}
	public double length() {
		return Math.sqrt(
				Math.pow(this.x,2)+
				Math.pow(this.y,2)+
				Math.pow(this.z,2));
	}
	public void norm() {
		double prevLength = this.length();
		this.x = this.x/prevLength;
		this.y = this.y/prevLength;
		this.z = this.z/prevLength;
	}
	public Vector matrixMult(double[][]arg) {
		final int argMat = 3;
		for(int i = 0; i < arg.length; i++) {
			if(arg[i].length != argMat) {
				return this;
			}
		}
		if(arg.length != argMat) {
			return this;
		}
		Vector res = new Vector();
		double tempRes[] = {0,0,0};
		double tempV[] = {this.x,this.y,this.z};
		for (int i = 0; i < argMat; i++) {
			for(int j = 0; j < argMat; j++) {
				tempRes[i] += tempV[j]*arg[i][j];
			}
		}
		res.x = tempRes[0];
		res.y = tempRes[1];
		res.z = tempRes[2];
		return res;
	}
	public int compareTo(Vector arg) {
		if(this.length() == arg.length()) {
			return 0;
		}else if (this.length() > arg.length()) {
			return 1;
		}else {
			return -1;
		}
	}
	public String toString () {
		return String.format("Vector = (%4.1f, %4.1f, %4.1f)", this.x, this.y, this.z);
	}
	
}
