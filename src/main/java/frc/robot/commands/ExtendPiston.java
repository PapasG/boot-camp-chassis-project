package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendPiston extends CommandBase{

    DoubleSolenoid m_doubleSolenoid;

    public ExtendPiston(DoubleSolenoid doubleSolenoid){

        m_doubleSolenoid = doubleSolenoid;

    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {

        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);

    }

    @Override
    public void end(boolean interrupted) {

        m_doubleSolenoid.set(DoubleSolenoid.Value.kOff);

    }

    @Override
    public boolean isFinished() {

        return false;
        
    }
    
}
