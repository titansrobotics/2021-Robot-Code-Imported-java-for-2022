/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class WinchDrive extends CommandBase {
  /**
   * Creates a new TankDrive.
   * 
   * Asher was here
   * 
   */
  public WinchDrive() {
    addRequirements(Robot.winchTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double flightThrust = Robot.m_RC.GetShotgunRawAxis(Constants.FLIGHT_THRUST);
    //below line adds a dead zone, only the extremes of the thrust input make the motor move
    if(flightThrust > 0.9 || flightThrust < -0.9) {


//LOOK HERE ASHER
     //multiplier for speed of winch 
      Robot.winchTrain.setWinchMotor(0.6*flightThrust);
    } else {
      Robot.winchTrain.setWinchMotor(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.winchTrain.setWinchMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
