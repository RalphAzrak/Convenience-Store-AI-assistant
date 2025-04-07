package assignment1.items;

public class SnoozeJuice extends Drink {
    private double temperature;
    public static int HOT_COLD_BOOST  = 2;

    public SnoozeJuice(double price, int happiness_index, int numOfBottles, double temperature) {
        super(price, happiness_index, numOfBottles, false);
        this.temperature = temperature;
    }

    public int getHappinessIndex() {
        if (this.temperature < 4 || this.temperature > 65) {
            return 0;
        }

        for (int i = 0; i < MyDate.SUMMER_MONTHS.length; i++) {
            if (MyDate.today().getMonth() == MyDate.SUMMER_MONTHS[i]) {
                if (this.temperature >= 4 && this.temperature <= 10 ) {
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
        }

        for (int i = 0; i < MyDate.WINTER_MONTHS.length; i++) {
            if (MyDate.today().getMonth() == MyDate.WINTER_MONTHS[i]) {
                if (this.temperature >= 55 && this.temperature <= 65 ) {
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
        }

        return super.getHappinessIndex();
    }

    public boolean equals(Object o) {
        if (o instanceof SnoozeJuice) {
            if (Math.abs(this.temperature - ((SnoozeJuice) o).temperature) < 0.001) {
                return super.equals(o);
            }

            else {
                return false;
            }
        }

        else {
            return false;
        }

    }

    public SnoozeJuice getPortion(int numOfBottlesRequested) {
        if (Math.abs(this.getNumOfBottles() - numOfBottlesRequested ) < 0.001) {
            SnoozeJuice portionofSnoozeJuice = new SnoozeJuice(this.getPrice(), this.getHappinessIndex(), numOfBottlesRequested, this.temperature);
            this.bottles = this.bottles - numOfBottlesRequested;
            return portionofSnoozeJuice;
        }

        else {
            return null;
        }
    }


}
