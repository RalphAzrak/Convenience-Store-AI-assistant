package assignment1.items;

public class Snack extends StoreItem {
    private String type_of_snack;
    private MyDate date_of_expiration;

    public Snack(double price, int happiness_index, String type_of_snack, MyDate date_of_expiration) {
        super(price, happiness_index);
        this.type_of_snack = type_of_snack;
        this.date_of_expiration = date_of_expiration;
    }

    private String getTypeOfSnack() {
        return type_of_snack;
    }

    private MyDate getDateOfExpiration() {
        return date_of_expiration;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Snack)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(this.getTypeOfSnack().equals(((Snack) o).getTypeOfSnack()))) {
            return false;
        }

        if (!(this.date_of_expiration.equals(((Snack) o).date_of_expiration))) {
            return false;
        }

        if (!(this.getPrice() == ((Snack) o).getPrice())) {
            return false;
        }

        if (!(this.getHappinessIndex() == ((Snack) o).getHappinessIndex())) {
            return false;
        }

        return true;
    }

    public boolean isExpired() {
        if (MyDate.today().getYear() > this.date_of_expiration.getYear()) {
            return true;
        }

        else if (MyDate.today().getYear() == this.date_of_expiration.getYear()) {
            if (MyDate.today().getMonth() > this.date_of_expiration.getMonth()) {
                return true;
            }
            else if (MyDate.today().getMonth() == this.date_of_expiration.getMonth()) {
                if (MyDate.today().getDay() > this.date_of_expiration.getDay()) {
                    return true;
                }
                else if (MyDate.today().getDay() == this.date_of_expiration.getDay()) {
                    return true;
                }
                else {
                    return false;
                }
            }

            else {
                return false;
            }

        }

        else {

            return false;

        }

    }

    public int getHappinessIndex() {
        if (this.isExpired()) {
            return (super.getHappinessIndex()/ 2);
        }
        else {
            return (super.getHappinessIndex());
        }
    }


}
