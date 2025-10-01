
public class RandomMovements {
	
	private int distance;
	private int angle;
	private int radius;
	private int direction;

	public RandomMovements(int direction, int radius, int angle, int distance){
		this.direction = direction;
		this.angle = angle;
		this.radius = radius;
		this.distance = distance;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getDelayStraightLine() {
		return (int) ((Math.abs(distance) / 0.02) + 100);
	}

	public int getDelayCurve() {
		return (int) (((radius * angle) / 0.02) + 100);
	}

}
