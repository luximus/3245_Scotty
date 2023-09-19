// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * Drive the robot with a tank style.
 */
public class DriveTankStyleWithMultiplier extends CommandBase {

  private Drivetrain drivetrain;
  private DoubleSupplier leftSpeedSupplier, rightSpeedSupplier;
  private double speedMultiplier;

  /** Creates a new DriveTankStyleWithMultiplier. */
  public DriveTankStyleWithMultiplier(Drivetrain drivetrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, double speedMultiplier) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    this.leftSpeedSupplier = leftSpeed;
    this.rightSpeedSupplier = rightSpeed;
    this.speedMultiplier = speedMultiplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.driveTankStyle(speedMultiplier * leftSpeedSupplier.getAsDouble(), speedMultiplier * rightSpeedSupplier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
