// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTankStyleWithMultiplier;
import frc.robot.commands.MoveWristManually;
import frc.robot.commands.RunIntakeShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeShooter;
import frc.robot.subsystems.WristJoint;

public final class RobotContainer {

  private static final int DRIVER_CONTROLLER_PORT = 0;
  private static final XboxController.Axis DRIVER_LEFT_AXIS = XboxController.Axis.kLeftTrigger;
  private static final XboxController.Axis DRIVER_RIGHT_AXIS = XboxController.Axis.kRightTrigger;
  private static final XboxController.Button DRIVER_SLOW_SPEED_BUTTON = XboxController.Button.kLeftBumper;
  private static final XboxController.Button DRIVER_FAST_SPEED_BUTTON = XboxController.Button.kRightBumper;
  private static final XboxController.Button RUN_INTAKE_BUTTON = XboxController.Button.kA;
  private static final XboxController.Button MOVE_INTAKE_UP_BUTTON = XboxController.Button.kX;
  private static final XboxController.Button MOVE_INTAKE_DOWN_BUTTON = XboxController.Button.kY;

  private static final double NORMAL_DRIVE_SPEED = 0.6;
  private static final double SLOW_DRIVE_SPEED = 0.4;
  private static final double FAST_DRIVE_SPEED = 0.8;

  private static final double INTAKE_RUN_SPEED = 0.5;
  private static final double INTAKE_UP_SPEED = 0.5;
  private static final double INTAKE_DOWN_SPEED = 0.5;

  private Drivetrain drivetrain = new Drivetrain();
  private IntakeShooter intakeShooter = new IntakeShooter();
  private WristJoint wristJoint = new WristJoint();
  private XboxController driverController = new XboxController(DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    configureBindings();

    drivetrain.setDefaultCommand(getDriveCommand(NORMAL_DRIVE_SPEED));
  }

  private void configureBindings() {
    var slowButton = new JoystickButton(driverController, DRIVER_SLOW_SPEED_BUTTON.value);
    var fastButton = new JoystickButton(driverController, DRIVER_FAST_SPEED_BUTTON.value);
    var intakeButton = new JoystickButton(driverController, RUN_INTAKE_BUTTON.value);
    var wristExtensionButton = new JoystickButton(driverController, MOVE_INTAKE_UP_BUTTON.value);
    var wristFlexionButton = new JoystickButton(driverController, MOVE_INTAKE_DOWN_BUTTON.value);

    fastButton.whileTrue(getDriveCommand(FAST_DRIVE_SPEED));
    slowButton.whileTrue(getDriveCommand(SLOW_DRIVE_SPEED));
    intakeButton.whileTrue(new RunIntakeShooter(intakeShooter, INTAKE_RUN_SPEED));
    wristExtensionButton.whileTrue(new MoveWristManually(wristJoint, INTAKE_UP_SPEED));
    wristFlexionButton.whileTrue(new MoveWristManually(wristJoint, -INTAKE_DOWN_SPEED));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  private DriveTankStyleWithMultiplier getDriveCommand(double speedMultiplier) {
    return new DriveTankStyleWithMultiplier(drivetrain,
                                            this::getLeftDriveInput,
                                            this::getRightDriveInput,
                                            speedMultiplier);
  }

  private double getLeftDriveInput() {
    return driverController.getRawAxis(DRIVER_LEFT_AXIS.value);
  }

  private double getRightDriveInput() {
    return driverController.getRawAxis(DRIVER_RIGHT_AXIS.value);
  }
}
