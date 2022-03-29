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

public class TankDrive extends CommandBase {
  /**
   * Creates a new TankDrive.
   * 
   * Asher was here
   * 
   */
  public TankDrive() {
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // var multiplier = 0.5;
    // double flightStickY = Robot.m_RC.GetShotgunRawAxis(Constants.FLIGHT_STICKY);
    
    double leftStickY = Robot.m_RC.GetDriverRawAxis(Constants.LEFT_STICKY);
    double rightStickY = Robot.m_RC.GetDriverRawAxis(Constants.RIGHT_STICKY);

    Robot.driveTrain.setLeftMotor(frc.robot.Constants.tankSpeed*leftStickY);
    Robot.driveTrain.setRightMotor(frc.robot.Constants.tankSpeed*rightStickY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setLeftMotor(0);
    Robot.driveTrain.setRightMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
