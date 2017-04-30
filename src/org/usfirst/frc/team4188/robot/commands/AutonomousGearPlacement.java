package org.usfirst.frc.team4188.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearPlacement extends CommandGroup {

    public AutonomousGearPlacement() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new AutoDriveToDistance((88.0/12.0), 0.6));
    	addSequential(new TurnToAngle(-56));
    	addSequential(new AutoDriveToDistance(45.0/12.0,0.6));
    	addSequential(new AutoDriveToDistance((31.0/12.0), 0.6),5);
    }
}
