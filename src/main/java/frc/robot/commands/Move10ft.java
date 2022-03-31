/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
public class Move10ft extends CommandBase {
  int phase = 1;
  
  /**
   * Creates a new Move10ft.
   * 
   * Asher was here
   * 
   */
  //Encoder enc;
  //final double cpr = 5; // if am-3314a
  //final double whd = 6; // for 6 inch wheel

  public Move10ft() {
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Drivetrain.driveReset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Drivetrain.driveDistance()<5000 && phase == 1){
      Robot.driveTrain.setLeftMotor(-0.3);
      Robot.driveTrain.setRightMotor(-0.3);
      Drivetrain.driveDistance();
    } 
    else if (phase == 1){
        phase = 2;
        
        //comment out following two to enable back
        //and forth functionality, see below
        Robot.driveTrain.setLeftMotor(0);
        Robot.driveTrain.setRightMotor(0);  
    }
    
// if you for some reason want it to go back after going forward,
//uncomment the following

    // if(Drivetrain.driveDistance()>0 && phase == 2){
    //     Robot.driveTrain.setLeftMotor(0.3);
    //     Robot.driveTrain.setRightMotor(0.3);
    //     Drivetrain.driveDistance();
    //   }
    //   else if (phase == 2){
    //     Robot.driveTrain.setLeftMotor(0);
    //     Robot.driveTrain.setRightMotor(0);     
    // }
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
