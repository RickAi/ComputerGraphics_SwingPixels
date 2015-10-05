package GraphicsObjects;

public class Vector3f {

	public float x = 0;
	public float y = 0;
	public float z = 0;

	public Vector3f() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// vector add vector will get a new vector
	// use this vector's x, y, z add plused vector's x, y, z
	public Vector3f plusVector(Vector3f plusedVector) {
		Vector3f vector3f = new Vector3f();
		vector3f.x = this.x + plusedVector.x;
		vector3f.y = this.y + plusedVector.y;
		vector3f.z = this.z + plusedVector.z;
		return vector3f;
	}

	// vector substract vector will get a new vector
	// use this vector's x, y, z substract plused vector's x, y, z
	public Vector3f minusVector(Vector3f minusedVector) {
		Vector3f vector3f = new Vector3f();
		vector3f.x = this.x - minusedVector.x;
		vector3f.y = this.y - minusedVector.y;
		vector3f.z = this.z - minusedVector.z;
		return vector3f;
	}

	// point add vector will get a new point
	// use this point's x, y, z add point's x, y, z
	public Point3f plusPoint(Point3f plusedPoint) {
		Point3f point3f = new Point3f();
		point3f.x = this.x + plusedPoint.x;
		point3f.y = this.y + plusedPoint.y;
		point3f.z = this.z + plusedPoint.z;
		return point3f;
	}

	// Do not implement Vector minus a Point as it is undefined

	// point multiply vector will get a new vector
	// use this vector's x, y, z multiply scale
	public Vector3f byScalar(float scale) {
		Vector3f vector3f = new Vector3f();
		vector3f.x = scale * this.x;
		vector3f.y = scale * this.y;
		vector3f.z = scale * this.z;
		return vector3f;
	}

	// minus x, y, z of vector will get the negative vector
	public Vector3f negateVector() {
		Vector3f vector3f = new Vector3f();
		vector3f.x = -vector3f.x;
		vector3f.y = -vector3f.y;
		vector3f.z = -vector3f.z;
		return vector3f;
	}

	// the formula is about the same as for two dimensional vectors.
	// use the square root of the x, y, z's exponent 2
	public float length() {
		return (float) Math.sqrt(this.dot(this));
	}

	// vector's normal is a vector
	// only consider x, y right now
	public Vector3f normal() {
		Vector3f vector3f = new Vector3f();
		vector3f.x = -this.y;
		vector3f.y = this.x;
		return vector3f;
	}

	// the dot of the vector is a float value
	// use the square of vector's x, y, z
	public float dot(Vector3f dottedVector) {
		return (this.x * dottedVector.x + this.y * dottedVector.y + this.z
				* dottedVector.z);
	}

	// the cross product of two vector will get a new vector
	// the formula is in the method
	public Vector3f cross(Vector3f crossedVector) {
		Vector3f vector3f = new Vector3f();
		vector3f.x = this.y * crossedVector.z - this.z * crossedVector.y;
		vector3f.y = this.z * crossedVector.x - this.x * crossedVector.z;
		vector3f.z = this.x * crossedVector.y - this.y * crossedVector.x;
		return vector3f;
	}
	
	@Override
	public String toString() {
		return "Vector:"+"(" + x + "," + y + "," + z + ")";
	}

}

/*
 * 
 * MMMM MMMMMM MM MMMM MMI MMMM MMM MMMM MMM MMMM MM MMMMM MMM MMMMM MMM OMMMM
 * MM .MMMM MMMMMMMMMMMMMMM MMM .MMMM MM IMMMMMMMMMMMMMMMMMMMMMMMM MMM MMMM MM
 * ~MMMMMMMMMMMMMMMMMMMMM MMMM MM OMMMMM MMMMM MM MMMMM MM MMMMM MM ~MMMM MM
 * =MMMM MM MMMM MM MMMMMM MM MMMMMMMM MM :MMMMMMMM MM MMMMMMMMM MM MMMMMMMMM MM
 * ,MMMMMMMMMM MMMMMMMMM MM IMMMMMMMMMMMMMMMMMMMMMMMMM MMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM ZMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMM MM$ MMMMMMMMM MMMMMMMMMMMMMM MMM MMMMMMMMM MMM
 * MMMMMMMM MM~ IMMMMMMMM MM DMMMMMMMM MMM MMMMMMMMM MMD MMMMMMMM MMM MMMMMMMM
 * MMMMMMMMMM MMMMMMMM MMMM MM GlassGiant.com
 */