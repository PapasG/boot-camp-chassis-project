package frc.robot.subsystems;

import java.lang.constant.Constable;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Mechanism extends SubsystemBase{

    private final DoubleSolenoid m_doubleSolenoid;

    public Mechanism(){

        m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.MechanismInfo.SOLENOID_FORWARD_CHANNEL_PORT_VAL, Constants.MechanismInfo.SOLENOID_REVERSE_CHANNEL_PORT_VAL);

    }
    
}
