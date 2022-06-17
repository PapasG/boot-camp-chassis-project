package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Mechanism extends SubsystemBase{

    private final DoubleSolenoid m_doubleSolenoid;

    public Mechanism(){

        m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.MechanismInfo.SOLENOID_FORWARD_CHANNEL_PORT_VAL, Constants.MechanismInfo.SOLENOID_REVERSE_CHANNEL_PORT_VAL);

    }

    public void ExtendPiston(){

        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);

    }

    public void RetractPiston(){

        m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public DoubleSolenoid getDoubleSolenoid(){

        return m_doubleSolenoid;

    }
    
}
