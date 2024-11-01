package Command;

import Rest.RestTour;

public class RestCommand implements Command {
    private RestTour restTour;

    public RestCommand(RestTour restTour) {
        this.restTour = restTour;
    }

    @Override
    public void execute() {
        restTour.inputDetails();
    }
}
