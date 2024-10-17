package Command;

import Cruise.CruiseTour;

public class CruiseCommand implements Command {
    private CruiseTour cruiseTour;

    public CruiseCommand(CruiseTour cruiseTour) {
        this.cruiseTour = cruiseTour;
    }

    @Override
    public void execute() {
        cruiseTour.inputDetails();
    }
}
