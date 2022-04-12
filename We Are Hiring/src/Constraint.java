package temaPOO;

public class Constraint {
	double inferior;
	double superior;
	
	public Constraint() {
		this.inferior = 0;
		this.superior = 0;
	}
	
	public Constraint(float inferior, float superior) {
		this.inferior = inferior;
		this.superior = superior;
	}
	
	public double getInferior() {
		return inferior;
	}
	public void setInferior(float inferior) {
		this.inferior = inferior;
	}
	public double getSuperior() {
		return superior;
	}
	public void setSuperior(float superior) {
		this.superior = superior;
	}
}
