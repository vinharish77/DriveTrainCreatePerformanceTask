package org.usfirst.frc.team4188.robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Vineeth Harish
 */
public class PIDRobotDrive extends RobotDrive implements PIDOutput {
    static final int kFrontLeft_val = 0;
    static final int kFrontRight_val = 1;
    static final int kRearLeft_val = 2;
    static final int kRearRight_val = 3;
    static final double OUTPUT_MIN = 0.17;
    
    protected RobotDrive robotDrive2;
    protected RobotDrive robotDrive3;
    
    
    public PIDRobotDrive(final int leftMotorChannel, final int rightMotorChannel) {
        super(leftMotorChannel, rightMotorChannel);
    }

    public PIDRobotDrive(final int frontLeftMotor, final int rearLeftMotor,
            final int frontRightMotor, final int rearRightMotor) {
        super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }

    public PIDRobotDrive(SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);
    }

    public PIDRobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
            SpeedController frontRightMotor, SpeedController rearRightMotor) {
        super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }
    public PIDRobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,SpeedController middleLeftMotor,
            SpeedController frontRightMotor, SpeedController rearRightMotor, SpeedController middleRightMotor){
    	super(frontLeftMotor, frontRightMotor);
    	robotDrive2 = new RobotDrive(rearLeftMotor, rearRightMotor);
    	robotDrive3 = new RobotDrive (middleLeftMotor, middleRightMotor);
    }

    public enum PIDType {
    	turnToAngle,
    	driveToDistance,
    	driveToDistanceTwoEncoder
    	
    }
    
    private static PIDType driveType;
    public static void setPIDType(PIDType type) {    	
    	driveType = type;
    	switch (driveType) {
    	case turnToAngle:
        	SmartDashboard.putString("Setting PIDType =", "turnToAngle");
        	break;
    
    	case driveToDistance:
        	SmartDashboard.putString("Setting PIDType =", "driveToDistance");
        	break;
    	case driveToDistanceTwoEncoder:
    		SmartDashboard.putString("Setting PIDType =", "driveToDistance");
    		break;
    	}
    }
       
    public void pidWrite(double output){
    	if (Math.abs(output)< OUTPUT_MIN) {
    		output = OUTPUT_MIN * Math.signum(output);
    	}
    	SmartDashboard.putNumber("PID", output);
    	switch(driveType){
    	case turnToAngle:
    	
    		super.setLeftRightMotorOutputs(output,-output);
    		
        	robotDrive2.setLeftRightMotorOutputs(output, -output);
        	robotDrive3.setLeftRightMotorOutputs(output,-output);
    	break;
    	case driveToDistance:
    		
        	super.setLeftRightMotorOutputs(output,output);
       
        	robotDrive2.setLeftRightMotorOutputs(output,output);
        	robotDrive3.setLeftRightMotorOutputs(output, output);
        break;
        
    	case driveToDistanceTwoEncoder:
    		double outputConstant;
    		if(Robot.drivetrain.getLeftEncoderDistance()<Robot.drivetrain.getRightEncoderDistance()){
    			outputConstant = 1.05;
    		}
    		if(Robot.drivetrain.getLeftEncoderDistance()>Robot.drivetrain.getRightEncoderDistance()){
    			outputConstant = 0.95;
    		}
    		else{
    			outputConstant = 1.00;
    		}
    		super.setLeftRightMotorOutputs(outputConstant*output, output);
    		
    		robotDrive2.setLeftRightMotorOutputs(outputConstant*output, output);
    		robotDrive3.setLeftRightMotorOutputs(outputConstant*output, output);

    	}
    }

    private int getInverted(SpeedController motor){
    	if(motor.getInverted())
    		return -1;
    	else
    		return 1;
    
    }
}