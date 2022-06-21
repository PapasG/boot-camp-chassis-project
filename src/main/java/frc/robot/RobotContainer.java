package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ExtendPiston;
import frc.robot.commands.RetractPiston;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Mechanism;

public class RobotContainer {

  private final XboxController m_controller;
  
  private final DriveTrain m_driveTrain;
  private final Mechanism m_mechanism;

  private final ExtendPiston m_extendPiston;
  private final RetractPiston m_retractPiston;

  private final JoystickButton m_driveModeButton;
  private final JoystickButton m_mechanismButton;
  private final JoystickButton m_extendButton;
  private final JoystickButton m_retractButton;
  
  public RobotContainer() {

    m_driveTrain = new DriveTrain();
    m_mechanism = new Mechanism();
    m_controller = new XboxController(Constants.RobotInfo.CONTROLLER_PORT);

    m_driveModeButton = new JoystickButton(m_controller, Constants.RobotInfo.DRIVE_MODE_BUTTON_VALUE);
    m_mechanismButton = new JoystickButton(m_controller, Constants.RobotInfo.MECHANISM_BUTTON_VALUE);
    m_extendButton = new JoystickButton(m_controller, Constants.RobotInfo.EXTEND_MECHANISM_BUTTON_VALUE);
    m_retractButton = new JoystickButton(m_controller, Constants.RobotInfo.MECHANISM_BUTTON_VALUE);

    m_extendPiston = new ExtendPiston(m_mechanism.getDoubleSolenoid());
    m_retractPiston = new RetractPiston(m_mechanism.getDoubleSolenoid());

    configureButtonBindings();
    setDefaultCommands();
    
  }

  private void configureButtonBindings() {

    m_driveModeButton.whenPressed(new RunCommand(()-> m_driveTrain.changeDriveMode(), m_driveTrain).withTimeout(Constants.DriveInfo.MODE_CHANGE_TIME_VALUE));

    m_mechanismButton.whileHeld(m_extendPiston);
    m_mechanismButton.whenReleased(m_retractPiston);

    m_extendButton.whileHeld(m_extendPiston);
    m_retractButton.whileHeld(m_retractPiston);

  }

  private void setDefaultCommands(){

    m_driveTrain.setDefaultCommand(new RunCommand(()->
                                       m_driveTrain.modeDrive(m_controller.getRightTriggerAxis() - m_controller.getLeftTriggerAxis(), 
                                       m_controller.getLeftX(), m_controller.getRightX(), 
                                       m_controller.getLeftY(), m_controller.getRightY()), m_driveTrain));

  }

  public Command getAutonomousCommand() {
    
    return null;
  
  }

}
