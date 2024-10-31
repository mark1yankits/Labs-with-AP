package Command;

import Excursion.ExcursionTour;

public class ExcursionCommand implements Command {
    private ExcursionTour excursionTour;

    public ExcursionCommand(ExcursionTour excursionTour) {
        this.excursionTour = excursionTour;
    }

    @Override
    public void execute() {
        excursionTour.excursionDetails();
    }
}
