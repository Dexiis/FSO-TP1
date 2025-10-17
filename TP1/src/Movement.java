
public class Movement {

	private RobotLegoEV3 robot;

	private MovementEnum movement;
	private int distance;
	private int radius;
	private int angle;

	public Movement(RobotLegoEV3 robot, MovementEnum movement, int distance) {
		this.movement = movement;
		this.distance = distance;
	}

	public Movement(RobotLegoEV3 robot, MovementEnum movement, int radius, int angle) {
		this.movement = movement;
		this.radius = radius;
		this.angle = angle;
		this.robot = robot;
	}

	public MovementEnum getMovement() {
		return movement;
	}

	public void setMovement(MovementEnum movement) {
		this.movement = movement;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public void doMovement() {
		switch (this.movement) {
		case FORWARD:
			robot.Reta(this.distance);
			break;
		case BACKWARDS:
			robot.Reta(-this.distance);
			break;
		case RIGHT:
			robot.CurvarDireita(this.radius, this.angle);
			break;
		case LEFT:
			robot.CurvarEsquerda(this.radius, this.angle);
			break;
		}
	}
}
