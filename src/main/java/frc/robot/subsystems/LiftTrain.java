/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.LiftMotor;

public class LiftTrain extends SubsystemBase {

  private WPI_TalonSRX liftMotor1 = new WPI_TalonSRX(Constants.LIFT_MOTOR_ID1);
  private WPI_TalonSRX liftMotor2 = new WPI_TalonSRX(Constants.LIFT_MOTOR_ID2);
  /**
   * Creates a new Drivetrain.
   */
  public LiftTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new LiftMotor(0));
  }

  public void setLiftMotor(double speed){
    liftMotor1.set(ControlMode.PercentOutput, -speed);
    liftMotor2.set(ControlMode.PercentOutput, -speed);
    //motorLeft.setSafetyEnabled(true);
  }

  public void setBrakeMode() {
    liftMotor1.setNeutralMode(NeutralMode.Brake);
    liftMotor2.setNeutralMode(NeutralMode.Brake);
  }
}
