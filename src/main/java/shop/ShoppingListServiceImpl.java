package shop;

import java.util.List;

public class ShoppingListServiceImpl implements ShoppingListService {
    final ShoppingListDAO shoppingListDAO;

    public ShoppingListServiceImpl(ShoppingListDAO shoppingListDAO) {
        this.shoppingListDAO = shoppingListDAO;
    }

    @Override
    public List<Item> findAllItems() {
        return shoppingListDAO.findAllItems();
    }

    @Override
    public void saveItems(List<Item> items) {
//        check items:
//        check that item name is not empty or null
//        check quantity to greater than 0 or less than 100
        for (Item item : items) {
            item.check();
        }

//        save all items in the database
        shoppingListDAO.saveItems(items);
    }
}
