package autonomous;

import org.usfirst.frc.team5468.robot.Hardware;

import templates.AutoProgram;

public class CrossTheLine extends AutoProgram {

	public CrossTheLine(Hardware r) {
		super(r, "LINE OF SHAME");
		positionRelevant = false;
		switchRelevant = false;
		scaleRelevant = false;
	}

	@Override
	protected void RLL() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void RLR() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void RRL() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void RRR() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void LRR() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void LLR() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void LRL() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void LLL() {
		commands.addForwardD(144);
		commands.addSequence(0, 1);
	}

}
