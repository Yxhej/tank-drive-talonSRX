// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class DriveSubsystem extends SubsystemBase {
  private final TalonSRX frontLeft = new TalonSRX(Ports.FRONT_LEFT_TALON);
  private final TalonSRX frontRight = new TalonSRX(Ports.FRONT_RIGHT_TALON);
  private final TalonSRX middleLeft = new TalonSRX(Ports.MIDDLE_LEFT_TALON);
  private final TalonSRX middleRight = new TalonSRX(Ports.MIDDLE_RIGHT_TALON);
  private final TalonSRX backLeft = new TalonSRX(Ports.BACK_LEFT_TALON);
  private final TalonSRX backRight = new TalonSRX(Ports.BACK_RIGHT_TALON);
  
  public DriveSubsystem() {
    backLeft.follow(frontLeft);
    middleLeft.follow(frontLeft);

    backRight.follow(frontRight);
    middleRight.follow(frontRight);


    frontLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);

    middleLeft.setNeutralMode(NeutralMode.Brake);
    middleRight.setNeutralMode(NeutralMode.Brake);

    backLeft.setNeutralMode(NeutralMode.Brake);
    backRight.setNeutralMode(NeutralMode.Brake);
  }

  public void set(double rightSpeed, double leftSpeed) {
    if (Math.abs(rightSpeed) < 0.05) {
      rightSpeed = 0;
  } else if (Math.abs(leftSpeed) < 0.05) {
      leftSpeed = 0;
  }

    frontLeft.set(ControlMode.PercentOutput, leftSpeed);
    frontRight.set(ControlMode.PercentOutput, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
