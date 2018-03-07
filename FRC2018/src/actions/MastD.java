package actions;

import org.usfirst.frc.team5468.robot.Hardware;
import functions.HallEncoder;
import templates.Action;

public class MastD extends Action {
	//distances
	private double target;
	private double offset;
	private double maxPower = 1;
	private double minPower = .1;
	
	private int upperCounter;
	private int lowerCounter;
	
	private HallEncoder encoder;
	
	//constructor
	public MastD(Hardware r, double distance) {
		super(r);
		target = distance;
	}

	@Override
	public void actionInit() {
		encoder = new HallEncoder(robot.hall);
		upperCounter = robot.higherMastInteraction.get();
		lowerCounter = robot.lowerMastInteraction.get();
	}

	@Override
	public void actionPeriodic() {
		if(robot.mastEnabled) {
			
		}
	}

	@Override
	public boolean actionFinished() {
		
		//if the target has been reached or some technical problems discovered
		if(Math.abs(target - robot.mast.getSelectedSensorPosition(0)) < offset || !robot.mastEnabled || checkLimits()) {
			//then finish action
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String getAction() {
		return "Distance";
	}
	
	private boolean checkLimits() {
		if(robot.higherMastInteraction.get() != upperCounter || robot.lowerMastInteraction.get() != lowerCounter || robot.lowerMastSwitch.get() || robot.higherMastSwitch.get()) {
			if(robot.higherMastSwitch.get() && robot.mast.getMotorOutputPercent() <= 0) {
				return false;
			} else {
				if(robot.lowerMastSwitch.get() && robot.mast.getMotorOutputPercent() >= 0) {
					return false;
				} else {
					return true;
				}
			}
			
		} else {
			return false;
		}
	}

}
