package org.usfirst.frc.team4188.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

	public XboxController pilotController;
	
	
	public JoystickButton pilot1;
	public JoystickButton pilot2;
	public JoystickButton pilot3;
	public JoystickButton pilot4;
	public JoystickButton pilot5;
	public JoystickButton pilot6;
	public JoystickButton pilot7;
	public JoystickButton pilot8;
	public JoystickButton pilot9;
	public JoystickButton pilot10;
	public JoystickButton pilot11;
	public JoystickButton pilot12;
	
	
	
	public OI(){
		
		
		
		pilotController = new XboxController(0);
		pilot1 = new JoystickButton(pilotController, 1);
        pilot2 = new JoystickButton(pilotController, 2);
        pilot3 = new JoystickButton(pilotController, 3);
        pilot4 = new JoystickButton(pilotController, 4);
        pilot5 = new JoystickButton(pilotController, 5);
        pilot6 = new JoystickButton(pilotController, 6);
        pilot7 = new JoystickButton(pilotController, 7);
        pilot8 = new JoystickButton(pilotController, 8);
        pilot9 = new JoystickButton(pilotController, 9);
        pilot10 = new JoystickButton(pilotController, 10);
        pilot11 = new JoystickButton(pilotController, 11);
        pilot12 = new JoystickButton(pilotController, 12);
        
		
	}

}

