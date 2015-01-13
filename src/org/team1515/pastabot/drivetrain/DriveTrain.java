package org.team1515.pastabot.drivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain {
	protected MotorModule left;
	protected MotorModule right;
	protected Encoder leftEncoder;
	protected Encoder rightEncoder;
	protected Joystick joystick;

//	private boolean twisted;
//	private boolean chessy;
//	private boolean arnold;
//	private boolean isReversed;

	protected static final double DRIVING_SCALE = 1.0;
	protected static final double TURNING_SCALE = 1.0;
	protected static final double LEFT_SPEED_TRIM = 0.92;
	protected static final double RIGHT_SPEED_TRIM = 1.0;
	protected static final double DEAD_BAND = 0.1;
	
	protected double x;
	protected double y;

	
	
	public DriveTrain(int motorPortOne, int motorPortTwo, int motorPortThree,
			int motorPortFour, int encoderSlotOne, int encoderSlotTwo,
			int encoderSlotThree, int encoderSlotFour, Joystick joystick) {
		this.left = new MotorModule(motorPortTwo, motorPortFour);
		this.right = new MotorModule(motorPortOne, motorPortThree);
		this.joystick = joystick;
	}

	public double getAngle(int turnAxis) {
		return Math.atan(joystick.getRawAxis(2) / (joystick.getRawAxis(turnAxis)));
	}

	public double getThrottle() {
		return (-joystick.getRawAxis(3) + 1) / 2;
	}

//	public void drive() {
//		double reverseFactor = isReversed ? -1.0 : 1.0;
//
//		if (!arnold) {
//			if (chessy) {
//				if (twisted) {
//					y = Math.sin(getAngle(6));
//					x = Math.cos(getAngle(6));
//				} else {
//					y = Math.sin(getAngle(1));
//					x = Math.cos(getAngle(1));
//				}
//			} else {
//				y = joystick.getRawAxis(2);
//				if (twisted) {
//					x = joystick.getRawAxis(4);
//				} else {
//					x = joystick.getRawAxis(1);
//				}
//			}
//			if (Math.abs(joystick.getRawAxis(2)) <= 0.1) {
//				y = 0.0;
//			}
//			if (Math.abs(x) <= 0.1) {
//				x = 0.0;
//			}
//			if (chessy) {
//				y *= getThrottle();
//				x *= getThrottle();
//			}
//		} else {
//			y = joystick.getRawAxis(2) * getThrottle();
//			x = joystick.getRawAxis(6) * getThrottle();
//			if (Math.abs(joystick.getRawAxis(2)) <= DEAD_BAND) {
//				y = 0.0;
//			}
//			if (Math.abs(joystick.getRawAxis(6)) <= DEAD_BAND) {
//				x = 0.0;
//			}
//		}
//		y *= DRIVING_SCALE * reverseFactor;
//		x *= TURNING_SCALE;
//		left.setSpeed(LEFT_SPEED_TRIM * (-y + x));
//		right.setSpeed(RIGHT_SPEED_TRIM * (y + x));
//	}

	public void autoDrive(double leftSpeed, double rightSpeed) {
		left.setSpeed(LEFT_SPEED_TRIM * leftSpeed);
		right.setSpeed(RIGHT_SPEED_TRIM * rightSpeed);
	}

	public void stop() {
		left.stop();
		right.stop();
	}
}
