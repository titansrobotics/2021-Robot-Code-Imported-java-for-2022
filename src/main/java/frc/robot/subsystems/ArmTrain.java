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
import frc.robot.commands.ArmDrive;

public class ArmTrain extends SubsystemBase {

  private CANSparkMax armMotor = new CANSparkMax(Constants.ARM_ANGLE_MOTOR_ID, MotorType.kBrushless); //note that you have to tell Spark Max what kind of motor we're using - it can drive many more types of motors than the other motor controllers
  /**
   * Creates a new Drivetrain.
   * 
   * Asher was here
   * 
   */
  public ArmTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ArmDrive());
  }

  public void setArmAngleMotor(double speed){
    armMotor.set(-speed);
    //motorLeft.setSafetyEnabled(true);
  }

  // public void setBrakeMode() {
  //   armMotor.IdleMode(kBrake);
  // }
}
