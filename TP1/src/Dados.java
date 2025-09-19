public class Dados implements IMovement {
	
	private int distance;
	private int angle;
	private int radius;
	
	private double movement;
	
	public Dados() {

	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void reta(int distance) {
		//robot.Reta((distance / 0.02) + 100);
	}

	@Override
	public void curvarDireita(int radius, int angle) {
		movement = ((radius * angle) / 0.02) + 100;
	}

	@Override
	public void curvarEsquerda(int radius, int angle) {
		movement = ((radius * -angle) / 0.02) + 100;
	}

	@Override
	public void parar(boolean stop) {
		movement = 100;
	}
	
	
}
