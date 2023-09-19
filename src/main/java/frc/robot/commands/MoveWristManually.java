// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WristJoint;

/**
 * Move the wrist up and down manually.
 */
public class MoveWristManually extends CommandBase {

  private WristJoint wristJoint;
  private double speed;
  /** 
   * Creates a new MoveWristManually. 
   * @param wristJoint the wrist joint of the robot
   * @param speed the speed at which to move the wrist. Positive indicates extension, negative
   *              indicates flexion.
   */
  public MoveWristManually(WristJoint wristJoint, double speed) {
    this.wristJoint = wristJoint;
    addRequirements(wristJoint);
    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    wristJoint.moveAtSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wristJoint.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
