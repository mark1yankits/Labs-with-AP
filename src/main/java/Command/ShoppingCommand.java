package Command;

import Shopping.ShoppingTour;

public class ShoppingCommand implements Command {
    private ShoppingTour shoppingTour;

    public ShoppingCommand(ShoppingTour shoppingTour) {
        this.shoppingTour = shoppingTour;
    }

    @Override
    public void execute() {
        shoppingTour.shoppingDetails();
    }
}
