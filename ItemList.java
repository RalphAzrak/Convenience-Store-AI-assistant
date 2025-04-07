package assignment1;
import assignment1.items.StoreItem;

public class ItemList {

    private StoreItem[] StoreItems;
    private int size;

    public ItemList() {
        this.StoreItems = new StoreItem[15];
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public StoreItem[] getAllItems() {
        StoreItem[] allItems = new StoreItem[this.size];
        for (int i = 0; i < this.size; i++) {
            if (!( this.StoreItems[i] == null)) {
                allItems[i] = this.StoreItems[i];
            }
        }
        return allItems;
    }

    private void resize() {
        StoreItem[] bigger = new StoreItem[this.StoreItems.length * 2];
        for (int i = 0; i < this.StoreItems.length; i++) {
            bigger[i] = this.StoreItems[i];
        }
        this.StoreItems = bigger;

    }

    private void shiftDown(int i) {
        if (i >= 0 && i < this.StoreItems.length) {
            for (int k = size; k > 1; k--) {
                this.StoreItems[k] = this.StoreItems[k - 1];
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    private void shiftUp(int i) {
        if (i >= 0 && i < this.StoreItems.length) {
            for (int k = i; k < this.StoreItems.length - 1; k++) {
                this.StoreItems[k] = this.StoreItems[k + 1];
            }
        }
    }

    public void addItem(StoreItem storeItem) {
        if (this.size >= this.StoreItems.length) {
            resize();
        }

        this.StoreItems[size] = storeItem;
        this.size = this.size + 1;

    }


    public StoreItem removeItem(StoreItem storeItem) {
        for (int i = 0; i < this.StoreItems.length; i++) {
            if (this.StoreItems[i].equals(storeItem)) {
                StoreItem temp = StoreItems[i];
                shiftUp(i);
                this.size = this.size - 1;
                return temp;
            }
        }

        return null;
    }

    public StoreItem[] findEqualItems(StoreItem storeItem) {
        int count = 0;
        StoreItem[] matchedItems = new StoreItem[this.size];
        for (int i = 0; i < this.StoreItems.length; i++) {
            if (this.StoreItems[i].equals(storeItem)) {
                matchedItems[i] = StoreItems[i];
                count += 1;
            }
        }

        StoreItem[] matchedItemsCorrectedSize = new StoreItem[count];
        for (int i = 0; i < count; i++) {
            matchedItemsCorrectedSize[i] = matchedItems[i];
        }
        return matchedItemsCorrectedSize;

        }

}





