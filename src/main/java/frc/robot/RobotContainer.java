package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {

  private final XboxController m_controller;
  private final DriveTrain m_driveTrain;
  
  public RobotContainer() {

    m_driveTrain = new DriveTrain();
    m_controller = new XboxController(0);

    configureButtonBindings();
    setDefaultCommands();
  }

  private void configureButtonBindings() {

    

  }

  private void setDefaultCommands(){

    m_driveTrain.setDefaultCommand(new RunCommand(() -> m_driveTrain.tankDrive(m_controller.getLeftY(),
                                                                              m_controller.getRightY(),
                                                                              false), m_driveTrain));

  }

  public Command getAutonomousCommand() {
    
    return null;
  
  }

}
