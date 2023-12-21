package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {
    private ShoppingListService shoppingList;
    private List<Item> itemList;

    @BeforeEach
    void setup() {
        shoppingList = new ShoppingListServiceImpl();
        itemList = new LinkedList<>();
    }

    @Test
    void should_check_if_item_names_are_not_null_or_empty() {
        itemList = new LinkedList<>();
        itemList.add(new Item("Banana", 5));
        itemList.add(new Item("Orange", 2));

        shoppingList.saveItems(itemList);

        assertDoesNotThrow(() -> shoppingList.saveItems(itemList));
    }

    @Test
    void should_throw_item_name_exception_when_an_item_with_null_name_exist() {
        itemList = new LinkedList<>();
        itemList.add(new Item("Banana", 5));
        itemList.add(new Item(null, 2));

        assertThrows(ItemNameException.class, () -> shoppingList.saveItems(itemList));
    }

    @Test
    void should_throw_item_name_exception_when_an_item_with_empty_name_exist() {
        itemList = new LinkedList<>();
        itemList.add(new Item("", 5));
        itemList.add(new Item("Orange", 2));

        assertThrows(ItemNameException.class, () -> shoppingList.saveItems(itemList));
    }

    @Test
    void should_throw_item_quantity_exception_when_an_item_quantity_is_less_than_1() {
        itemList = new LinkedList<>();
        itemList.add(new Item("Banana", 5));
        itemList.add(new Item("Orange", 0));

        assertThrows(ItemQuantityException.class, () -> shoppingList.saveItems(itemList));

    }

    @Test
    void should_throw_item_quantity_exception_when_an_item_quantity_is_greater_than_100() {
        itemList = new LinkedList<>();
        itemList.add(new Item("Banana", 5));
        itemList.add(new Item("Orange", 101));

        assertThrows(ItemQuantityException.class, () -> shoppingList.saveItems(itemList));

    }
}
