/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//Controller API imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ActivateBallDrive;
import frc.robot.commands.DeactivateBallDrive;
import frc.robot.commands.ActivateWinchDrive;
import frc.robot.commands.DeactivateWinchDrive;
//Commands imports
import frc.robot.commands.Move10ft;
import frc.robot.commands.TankDrive;
import frc.robot.commands.SpeedModifierDown;
import frc.robot.commands.SpeedModifierUp;

//camera server import
import edu.wpi.first.cameraserver.CameraServer;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 * 
 * Asher was here
 * 
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Joystick driverController = new Joystick(Constants.DRIVER_CONTROLLER);
  private Joystick shotgunController = new Joystick(Constants.SHOTGUN_CONTROLLER);
  Button LBButton = new JoystickButton(driverController, Constants.BUTTON_LB);
  Button RBButton = new JoystickButton(driverController, Constants.BUTTON_RB);
  Button LTButton = new JoystickButton(driverController, Constants.BUTTON_LT);
  Button RTButton = new JoystickButton(driverController, Constants.BUTTON_RT);
  Button Trigger = new JoystickButton(shotgunController, Constants.TRIGGER);
  Button TriggerTwo = new JoystickButton(shotgunController, Constants.TRIGGER_TWO);

  public double GetDriverRawAxis(int axis) {
    return driverController.getRawAxis(axis);
  }

  public double GetShotgunRawAxis(int axis){
    return shotgunController.getRawAxis(axis);
  }

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //alternate between normal and autonomous code. Not sure why this is present, but 
    //I never felt the need to remove it sooooo
    LBButton.whenPressed(new Move10ft());
    RBButton.whenPressed(new TankDrive());

    //virtual gearbox!!!
    LTButton.whenPressed(new SpeedModifierDown());
    RTButton.whenPressed(new SpeedModifierUp());

    //Only let the ball motor move when the trigger is pressed
    Trigger.whenPressed(new ActivateBallDrive());
    Trigger.whenReleased(new DeactivateBallDrive());

    
    //Only let the ball motor move when the trigger is pressed
    TriggerTwo.whenPressed(new ActivateWinchDrive());
    TriggerTwo.whenReleased(new DeactivateWinchDrive());

    //Forces the cameras to start. Dunno if we actually need this but I'm adding it
    // just to make sure we get both camera streams up and running.
    CameraServer.startAutomaticCapture("Cam0",0);
    CameraServer.startAutomaticCapture("Cam1",1);
  }

  /** 
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The command that will run in autonomous
    return(new Move10ft()); 
  }
}
