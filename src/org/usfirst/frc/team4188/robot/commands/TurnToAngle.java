package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.PIDRobotDrive;
import org.usfirst.frc.team4188.robot.Robot;
import org.usfirst.frc.team4188.robot.RobotMap;
import org.usfirst.frc.team4188.robot.PIDRobotDrive.PIDType;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToAngle extends Command {
	double finalAngle;

	public PIDController gyroPIDController;

	//PID tuned for practice bot
	private  double KP = 0.0;
	private  double KI = 0.0;
	private  double KD = 0.0;

	private long start = 0l;
	private static final double tolerance = 0.5; // to within 1.0 degree
	// private static final int ONE = 1;
	// private static final int TWO = 2;
	// private static final int THREE = 3;

	private int initCount = 0, executeCount = 0;

	public TurnToAngle(double setPoint) {
		// Use requires() here to declare subsystem dependencies
		if (Robot.drivetrain == null) {
			throw new NullPointerException("Robot.drivetrain is null, Vineeth.");
		}
		requires(Robot.drivetrain);
		this.finalAngle = setPoint;

			KP = 0.02;
			KI = 0.002;
			KD = 0.002;


	}

	// Called just before this Command runs the first time
	protected void initialize() {

		this.start = System.currentTimeMillis();

		SmartDashboard.putString("Aim Status", "Initializing");
		

		Robot.drivetrain.gyroReset();
		PIDRobotDrive.setPIDType(PIDType.turnToAngle);

		gyroPIDController = new PIDController(KP, KI, KD, RobotMap.gyro, RobotMap.talonDriveBase);
		gyroPIDController.setAbsoluteTolerance(tolerance);

		gyroPIDController.setSetpoint(this.finalAngle);

		//gyroPIDController.setSetpoint(10);

		gyroPIDController.enable();

		initCount++;
		SmartDashboard.putNumber("Init Count", initCount);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		boolean onTarget = gyroPIDController.onTarget();
		SmartDashboard.putString("Aim Status", "On Target =" + onTarget) ;
		return onTarget;
	}

	// Called once after isFinished returns true
	protected void end() {
		gyroPIDController.disable();
		gyroPIDController.free();

		long elapsed = System.currentTimeMillis()-start; //time that the PID has been running
		SmartDashboard.putNumber("Turn to Angle", elapsed);
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
