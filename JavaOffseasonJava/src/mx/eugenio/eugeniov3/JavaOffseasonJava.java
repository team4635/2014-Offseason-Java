/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package mx.eugenio.eugeniov3;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class JavaOffseasonJava extends SimpleRobot {
    
    RobotDrive chassis;
    Joystick driveStick;
    Button button1;
    Victor vic;
    
    public void robotInit(){
        chassis = new RobotDrive(1, 2);
        driveStick = new Joystick(1);
        button1 = new JoystickButton(driveStick, 1);
        vic = new Victor(3);
        
        
        
    }
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while (isOperatorControl()&& isEnabled()){
            //Drive
            chassis.arcadeDrive(driveStick.getRawAxis(3), -driveStick.getRawAxis(1));
            //Captura Balls
            if (driveStick.getRawButton(2))
                vic.set(0.5);
            else if (driveStick.getRawButton(3))
                vic.set(-0.5);
            else
                vic.set(0.0);
            Timer.delay(0.01);
        }
        
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
