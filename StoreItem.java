package assignment1.items;

public abstract class StoreItem {
    private double price;
    private int happiness_index;

    public StoreItem(double price, int happiness_index) {
        if ((price < 0) || (happiness_index < 0)) {
            throw new IllegalArgumentException("Wrong input!");
        }

        else {
            this.price = price;
            this.happiness_index = happiness_index;
        }

    }

    public final double getPrice() {
        return this.price;
    }

    public int getHappinessIndex() {
        return this.happiness_index;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof StoreItem)) {
            return false;
        }

        if ( Math.abs(this.getPrice() - ((StoreItem) o).getPrice()) < 0.001 ) {
            if (this.getHappinessIndex() == ((StoreItem) o).getHappinessIndex()) {
                return true;
            }

        }

        return false;

    }

}







