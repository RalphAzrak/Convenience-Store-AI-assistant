package assignment1.items;

public class FizzWiz extends Drink {
    public FizzWiz(double price, int happiness_index, int number_of_bottles) {
        super(price, happiness_index, number_of_bottles, true);
    }


    public boolean equals(Object o) {
        if (o instanceof FizzWiz) {
            return super.equals(o);
        }
        else {
            return false;
        }
    }

    public FizzWiz getPortion(int numBottlesRequested) {
        if (numBottlesRequested <= this.getNumOfBottles()) {
            FizzWiz portionOfFizzWiz = new FizzWiz(this.getPrice(), this.getHappinessIndex(), numBottlesRequested);

            this.bottles = this.bottles - numBottlesRequested;

            return portionOfFizzWiz;

        }

        else {
            return null;

        }

    }


}

