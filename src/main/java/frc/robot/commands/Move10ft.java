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
  /**
   * Creates a new Move10ft.
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
    //enc = new Encoder(0, 1);
    //enc.setDistancePerPulse(Math.PI * whd / cpr); // distance per pulse is pi* (wheel diameter / counts per revolution)
    Drivetrain.driveReset();
  }

  /*public double driveDistance() {
    return enc.getDistance();
  }

  public void driveReset() {
    enc.reset();
    enc.setDistancePerPulse(Math.PI * whd / cpr);
  }*/

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Drivetrain.driveDistance()<5000){
      Robot.driveTrain.setLeftMotor(-0.3);
      Robot.driveTrain.setRightMotor(-0.3);
      Drivetrain.driveDistance();
    }else{
      Robot.driveTrain.setLeftMotor(0);
      Robot.driveTrain.setRightMotor(0);
    }
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
