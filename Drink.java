package assignment1.items;

public abstract class Drink extends StoreItem {
    public static int MAX_PACK_SIZE = 6;
    public static int BUZZY_HAPPINESS_BOOST = 1;
    protected int bottles;
    private boolean buzziness;

    public Drink(double price, int happiness_index, int bottles, boolean buzziness) {
        super(price, happiness_index);
        this.bottles = bottles;
        this.buzziness = buzziness;
    }

    public int getNumOfBottles() {
        return this.bottles;
    }

    private boolean getBuzziness() {
        return this.buzziness;
    }

    private void setBottles(int bottles) {
        this.bottles = bottles;
    }

    public int get_HappinessIndex() {
        if (this.buzziness) {
            return (super.getHappinessIndex() + Drink.BUZZY_HAPPINESS_BOOST);
        }
        else {
            return (super.getHappinessIndex());
        }
    }

    public boolean equals(Object o) {

        if (o instanceof Drink) {
            return (super.equals(o) && (this.buzziness == ((Drink) o).buzziness));
        }
        else {
            return false;
        }
    }

    public boolean combine(Drink d) {
        if (!(this.equals(d))) {
            return false;
        }

        if (this.getNumOfBottles() >= Drink.MAX_PACK_SIZE) {
            return false;
        }

        int bottlesRemainingUntilFull = Drink.MAX_PACK_SIZE - this.getNumOfBottles();
        this.setBottles(this.getNumOfBottles() + Math.min(bottlesRemainingUntilFull, d.getNumOfBottles()));

        if ( Math.min(bottlesRemainingUntilFull, d.getNumOfBottles()) == d.getNumOfBottles() ) {
            d.setBottles(0);
        }
        else {
            d.setBottles(d.getNumOfBottles() - Math.min(bottlesRemainingUntilFull, d.getNumOfBottles()));
        }
        return true;

    }

    public abstract Drink getPortion(int i);

}



