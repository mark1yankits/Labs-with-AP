package Command;

import Medical.MedicalTour;

public class MedicalCommand implements Command {
    private MedicalTour medicalTour;

    public MedicalCommand(MedicalTour medicalTour) {
        this.medicalTour = medicalTour;
    }

    @Override
    public void execute() {
        medicalTour.inputDetails();
    }
}
