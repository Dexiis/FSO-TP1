public interface IMovement {
	
	void calculateStraighLineDelay(int distance);
	void calculateRightCurveDelay(int radius, int angle);
	void calculateLeftCurveDelay(int radius, int angle);
	void stopRobot(boolean asynchronous);
	
}
