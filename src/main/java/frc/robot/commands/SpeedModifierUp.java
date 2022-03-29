/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpeedModifierUp extends CommandBase {
  /**
   * Creates a new TankDrive.
   * 
   * Asher was here
   * 
   */
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (frc.robot.Constants.tankSpeed < 0.9) {
      frc.robot.Constants.tankSpeed += 0.2; 
    } else {
      //lol don't do anything, you're maxed out
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // this needs to be true, unlike the other commands, because we issue this command multiple
    // times when changing the virtual gearbox - this forces the scheduler to restart and rerun
    // the command.
    return true;
  }
}
