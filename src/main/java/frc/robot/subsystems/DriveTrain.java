package frc.robot.subsystems;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{

    private final DifferentialDrive m_differentialDrive;

    private final MotorControllerGroup m_leftMotorControllerGroup;
    private final MotorControllerGroup m_rightMotorControllerGroup;

    public DriveTrain(){

        Spark frontLeftDriveMotor = new Spark(3);
        Spark frontRightDriveMotor = new Spark(0);
        Spark backLeftDriveMotor = new Spark(2);
        Spark backRightDriveMotor = new Spark(1);

        m_leftMotorControllerGroup = new MotorControllerGroup(frontLeftDriveMotor, backLeftDriveMotor);
        m_rightMotorControllerGroup = new MotorControllerGroup(frontRightDriveMotor, backRightDriveMotor);

        m_differentialDrive = new DifferentialDrive(m_leftMotorControllerGroup, m_rightMotorControllerGroup);

        m_leftMotorControllerGroup.setInverted(true);
        m_rightMotorControllerGroup.setInverted(false);

        m_differentialDrive.setSafetyEnabled(false);

    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs){

        m_differentialDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);

    }

    
}
