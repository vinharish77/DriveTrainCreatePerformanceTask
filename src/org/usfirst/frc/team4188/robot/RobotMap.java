package org.usfirst.frc.team4188.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static CANTalon frontRight;
	public static CANTalon rearRight;
	public static CANTalon frontLeft;
	public static CANTalon rearLeft;
	
	public static Victor frontRightDriveMotor;
	public static Victor frontLeftDriveMotor;
	public static Victor rearRightDriveMotor;
	public static Victor rearLeftDriveMotor;
	
	public static PIDRobotDrive talonDriveBase;
	public static PIDRobotDrive victorDriveBase;
	public static ADXRS450_Gyro gyro;
	//public static AnalogGyro gyro;
	public static void init() {
		// TODO Auto-generated method stub
		
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	frontRight = new CANTalon(11);
	rearRight = new CANTalon(12);
	frontLeft = new CANTalon(13);
	rearLeft = new CANTalon(14);
	
	rearLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	rearRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	
	
	frontRightDriveMotor = new Victor(0);
	frontLeftDriveMotor = new Victor(1);
	rearRightDriveMotor = new Victor(2);
	rearLeftDriveMotor = new Victor(3);
	
	talonDriveBase = new PIDRobotDrive(frontLeft, rearLeft, frontRight,rearRight);
	talonDriveBase.setSafetyEnabled(false);
	talonDriveBase.setExpiration(0.1);
	talonDriveBase.setSensitivity(0.5);
	talonDriveBase.setMaxOutput(1.0);
	
	victorDriveBase = new PIDRobotDrive(frontLeftDriveMotor, rearLeftDriveMotor, frontRightDriveMotor,rearRightDriveMotor);
	victorDriveBase.setSafetyEnabled(false);
	victorDriveBase.setExpiration(0.1);
	victorDriveBase.setSensitivity(0.5);
	victorDriveBase.setMaxOutput(1.0);
	
	gyro = new ADXRS450_Gyro();
	//gyro = new AnalogGyro(0);
	}
}
