package org.usfirst.frc.team4188.robot.subsystems;

import org.usfirst.frc.team4188.robot.PIDRobotDrive;
import org.usfirst.frc.team4188.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon frontRight = RobotMap.frontRight;
	CANTalon frontLeft = RobotMap.frontLeft;
	CANTalon rearRight = RobotMap.rearRight;
	CANTalon rearLeft = RobotMap.rearLeft;
	PIDRobotDrive driveBase = RobotMap.talonDriveBase;
	AnalogGyro gyro = RobotMap.gyro;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void mecanumDrive(double x, double y, double twist, double throttle, double direction){
    	driveBase.mecanumDrive_Cartesian(x*throttle, y*throttle, 0.5*twist*throttle, direction);
    }
    
    public void arcadeDrive(double x, double twist, double throttle){
    	driveBase.arcadeDrive(x*throttle, twist*throttle);
    }
    
    public void tankDrive(double leftValue, double rightValue, double throttle){
    	driveBase.tankDrive(leftValue*throttle, rightValue*throttle);
    }
    public void resetEncoders(){
    	rearRight.setPosition(0);
    	rearLeft.setPosition(0);
    	
    }
    public double getRightEncoderDistance(){
		double distance = rearRight.getPosition();
		SmartDashboard.putNumber("Encoder Right Distance", distance);
		return distance;
	}
	public double getLeftEncoderDistance(){
		double distance = -rearLeft.getPosition();
		SmartDashboard.putNumber("Encoder Left Distance", distance);
		return distance;
	}
	
	public void gyroReset(){
		gyro.reset();
	}
    
}

