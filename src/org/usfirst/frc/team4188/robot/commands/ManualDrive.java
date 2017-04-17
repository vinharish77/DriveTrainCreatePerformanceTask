package org.usfirst.frc.team4188.robot.commands;

import org.usfirst.frc.team4188.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualDrive extends Command {
	XboxController pilotController = Robot.oi.pilotController;
    public ManualDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rotateConstant = 0.85;
    	
    		
    	if(pilotController.getTriggerAxis(Hand.kRight)-0.5>0 && !((pilotController.getTriggerAxis(Hand.kLeft)-0.5)>0)){
    		rotateConstant = 0.85+(0.15*(pilotController.getTriggerAxis(Hand.kRight)-0.5)) ;
    	}
    	if((pilotController.getTriggerAxis(Hand.kLeft)-0.5>0) && !((pilotController.getTriggerAxis(Hand.kRight)-0.5)>0)){
    		rotateConstant = 0.85-(0.35*(pilotController.getTriggerAxis(Hand.kLeft)-0.5));
    	}
    	
    	
    	
    	
    	Robot.drivetrain.arcadeDrive(pilotController.getY(Hand.kLeft), -pilotController.getX(Hand.kRight)*rotateConstant, 1.0);	
   
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
