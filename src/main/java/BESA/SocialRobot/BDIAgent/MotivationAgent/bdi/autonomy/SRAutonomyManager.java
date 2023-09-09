package BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy;

import BESA.BDI.AgentStructuralModel.GoalBDI;
import BESA.BDI.AgentStructuralModel.AutonomyManager.AutonomyManager;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.request.RequestHandler;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.srgoal.SRGoal;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import rational.mapping.Believes;

public class SRAutonomyManager extends AutonomyManager {
    private FIS fis;
    private RequestHandler requests;

    public SRAutonomyManager(String fileName) {
        fis = FIS.load(fileName, true);
        requests = new RequestHandler();
        if (fis == null) {
            System.err.println("Cannot load FCL file: " + fileName);
        }
    }

    @Override
    public boolean performAutonomyChecks(GoalBDI goalBDI, Believes beliefs) {
        return super.performAutonomyChecks(goalBDI, beliefs) && checkAutonomyFrameworkValues(goalBDI, beliefs);
    }

    private boolean checkAutonomyFrameworkValues(GoalBDI goalBDI, Believes beliefs) {
        boolean checkIsPassed = true;
        if (goalBDI instanceof SRGoal) {
            checkIsPassed = false;
            SRGoal srGoal = (SRGoal) goalBDI;
            // Set input values
            fis.setVariable("Criticality", srGoal.calculateCriticality());
            fis.setVariable("Accountability", srGoal.getAccountability());

            // Evaluate the fuzzy rules
            fis.evaluate();
            FunctionBlock functionBlock = fis.getFunctionBlock("autonomy_system");
            double autonomyLevelValue = functionBlock.getVariable("AutonomyLevel").getValue();
            // TODO: Update values
            if (autonomyLevelValue > 0.5 && autonomyLevelValue <= 0.75) {
                checkIsPassed = checkRequestPermission(goalBDI, beliefs);
            } else if (autonomyLevelValue > 0.75) {
                checkIsPassed = true;
            }
        }

        return checkIsPassed;
    }

    private boolean checkRequestPermission(GoalBDI goalBDI, Believes beliefs) {
        String requestName = goalBDI.getClass().getName();
        boolean isGranted = requests.isRequestGranted(requestName);
        if (!isGranted) {
            requests.addRequest(requestName);
        }
        return isGranted;
    }

    public RequestHandler getRequests() {
        return requests;
    }

    public void setRequests(RequestHandler requests) {
        this.requests = requests;
    }

}
