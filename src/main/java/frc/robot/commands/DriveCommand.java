// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */
  private final DriveSubsystem driveSubsystem;
  private final Joystick leftJoystick;
  private final Joystick rightJoystick;


  public DriveCommand(DriveSubsystem driveSubsystem, Joystick leftJoystick, Joystick rightJoystick) 
  {
    this.driveSubsystem = driveSubsystem;
    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rightSpeed = rightJoystick.getY();
    double leftSpeed = leftJoystick.getY();
    
    driveSubsystem.set(rightSpeed, leftSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
