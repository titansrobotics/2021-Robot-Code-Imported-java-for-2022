/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.BallDrive;

public class BallTrain extends SubsystemBase {

  private CANSparkMax ballMotor = new CANSparkMax(Constants.BALL_MOTOR_ID, MotorType.kBrushless);
  /**
   * Creates a new Drivetrain.
   * 
   * Asher was here
   * 
   */
  public BallTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new BallDrive());
  }

  public void setBallMotor(double speed){
    ballMotor.set(-speed);
    //motorLeft.setSafetyEnabled(true);
  }

  // public void setBrakeMode() {
  //   armMotor.IdleMode(kBrake);
  // }
}
