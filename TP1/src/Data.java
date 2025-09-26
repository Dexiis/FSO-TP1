public class Data {

	private int distance;
	private int angle;
	private int radius;
	private int number;
	private String name;
	private boolean turnedOn;
	private boolean randomMovements;

	public Data(int radius, int angle, int distance, int number, String name, boolean turnedOn,
			boolean randomMovements) {
		this.distance = distance;
		this.angle = angle;
		this.radius = radius;
		this.number = number;
		this.name = name;
		this.turnedOn = turnedOn;
		this.randomMovements = randomMovements;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

	public boolean getRandomMovements() {
		return randomMovements;
	}

	public void setRandomMovements(boolean randomMovements) {
		this.randomMovements = randomMovements;
	}

	public double getDelayStraightLine() {
		return (distance / 0.02) + 100;
	}

	public double getDelayCurve() {
		return ((radius * angle) / 0.02) + 100;
	}

}