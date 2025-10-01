import java.util.ArrayList;
import java.util.Random;

public class RandomMovements extends Thread{
	
	private int distance;
	private int angle;
	private int radius;
	private int direction;
	private int number;

	public RandomMovements(int number){
		this.number = number;
		generate();
		
	}
	
	public void generate() {
		
		Random random = new Random();
		ArrayList<RandomMovements> movements = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			int direction = random.nextInt(3);
			if (direction == FORWARD)
				movements.add(new RandomMovements(FORWARD, 0, 0, random.nextInt(40) + 10));
			else if (direction == BACKWARDS)
				movements.add(new RandomMovements(BACKWARDS, 0, 0, random.nextInt(40) - 50));
			else
				movements.add(new RandomMovements(direction, random.nextInt(20) + 10, random.nextInt(70) + 20, 0));
		}

		for (RandomMovements movement : movements) {
			if (movement.getDirection() == FORWARD || movement.getDirection() == BACKWARDS) {
				robot.Reta(movement.getDistance());
				try {
					Thread.sleep(movement.getDelayStraightLine());
				} catch (InterruptedException e) {
				}
			} else if (movement.getDirection() == RIGHT) {
				robot.CurvarDireita(data.getRadius(), data.getAngle());
				try {
					Thread.sleep(movement.getDelayCurve());
				} catch (InterruptedException e) {
				}
			} else if (movement.getDirection() == LEFT) {
				robot.CurvarEsquerda(data.getRadius(), data.getAngle());
				try {
					Thread.sleep(movement.getDelayCurve());
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
