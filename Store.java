package assignment1;
import assignment1.items.*;

public class Store {
    private ItemList itemList;
    private double totalRevenue;

    public Store(ItemList itemList) {
        this.itemList = itemList;
        this.totalRevenue = 0.0;
    }

    public double getRevenue() {
        return this.totalRevenue;
    }

    private void setRevenue(double revenue) {
        this.totalRevenue += revenue;
    }


    public ItemList getItems() {
        return this.itemList;
    }

    public void cleanUp() {
        StoreItem[] storeItems = itemList.getAllItems();
        StoreItem[] removedItems = new StoreItem[storeItems.length];
        int counter = 0;
        for (int i = 0; i < itemList.getAllItems().length; i++) {
            if (storeItems[i] instanceof Snack) {
                if (((Snack) storeItems[i]).isExpired()) {
                    removedItems[i] = storeItems[i];
                    counter += 1;
                }
            }
        }

        for (int i = 0; i < counter; i++) {
            this.itemList.removeItem(removedItems[i]);
        }
    }

    public int completeSale(ItemList itemList) {
        cleanUp();
        StoreItem[] storeItems = itemList.getAllItems(); // correct
        int netHappiness = 0; // correct

        for (int i = 0; i < storeItems.length; i++) {
            if (storeItems[i] instanceof Snack) {
                itemList.removeItem(storeItems[i]);
                netHappiness += ( (Snack) storeItems[i]).getHappinessIndex();
                setRevenue( ((Snack) storeItems[i]).getPrice());
            }

            else if (storeItems[i] instanceof Drink ) {
                itemList.removeItem(storeItems[i]);
                netHappiness += ((Drink) storeItems[i]).getHappinessIndex();
                setRevenue( (((Drink) storeItems[i]).getPrice()) * ((Drink) storeItems[i]).getNumOfBottles());
            }

        }
        return netHappiness;

    }

    public void refillDrinkInventory(Drink[] drinks) {
        StoreItem[] storeItems = itemList.getAllItems();
        for (int i = 0; i < drinks.length; i++) {
            for (int j = 0; j < storeItems.length; j++) {
                if (storeItems[j] instanceof Drink) {
                    if (((Drink) storeItems[j]).equals(drinks[i])) {
                        ((Drink) storeItems[j]).combine(drinks[i]);
                    }
                }
            }
        }
    }

}