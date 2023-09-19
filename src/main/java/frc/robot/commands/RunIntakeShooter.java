// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeShooter;

/**
 * Run the intake/shooter forward.
 */
public class RunIntakeShooter extends CommandBase {

  private static final double DEFAULT_SPEED = 0.5;

  private IntakeShooter intakeShooter;
  private double speed;

  public RunIntakeShooter(IntakeShooter intakeShooter) {
    this(intakeShooter, DEFAULT_SPEED);
  }

  /** Creates a new RunIntakeShooter. */
  public RunIntakeShooter(IntakeShooter intakeShooter, double speed) {
    this.intakeShooter = intakeShooter;
    addRequirements(intakeShooter);
    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeShooter.runAtSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeShooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
