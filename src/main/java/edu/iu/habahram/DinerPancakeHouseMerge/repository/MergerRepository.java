package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@Repository
public class MergerRepository {
    public  List<MenuItemRecord> getTheMenuItems() {
        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(), x.getDescription(), x.isVegetarian(), x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getVegetarian() {
        List<MenuItemRecord> records = new ArrayList<>();
        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        CompositeIterator compositeIterator = new CompositeIterator(allMenus.createIterator());
        while (compositeIterator.hasNext()) {
            MenuComponent menuComponent = compositeIterator.next();
            if (menuComponent instanceof MenuItem) {
                if (menuComponent.isVegetarian()) {
                    records.add(new MenuItemRecord(menuComponent.getName(), menuComponent.getDescription(), menuComponent.isVegetarian(), menuComponent.getPrice()));
                }
            }
        }
        return records;
    }
    public List<MenuItemRecord> getBreakfast(){
        List<MenuItemRecord> records = new ArrayList<>();
        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        CompositeIterator compositeIterator = new CompositeIterator(allMenus.createIterator());
        while (compositeIterator.hasNext()) {
            MenuComponent menuComponent = compositeIterator.next();
            if (menuComponent instanceof PancakeHouseMenu) {
                CompositeIterator pancakeHouseIterator = new CompositeIterator(menuComponent.createIterator());
                while (pancakeHouseIterator.hasNext()) {
                    MenuComponent pancakeHouseMenuComponent = pancakeHouseIterator.next();
                    records.add(new MenuItemRecord(pancakeHouseMenuComponent.getName(), pancakeHouseMenuComponent.getDescription(), pancakeHouseMenuComponent.isVegetarian(), pancakeHouseMenuComponent.getPrice()));
                }
            }
        }
        return records;
    }
    public List<MenuItemRecord> getLunch(){
        List<MenuItemRecord> records = new ArrayList<>();
        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        CompositeIterator compositeIterator = new CompositeIterator(allMenus.createIterator());
        while (compositeIterator.hasNext()) {
            MenuComponent menuComponent = compositeIterator.next();
            if (menuComponent instanceof DinerMenu) {
                CompositeIterator lunchMenuIterator = new CompositeIterator(menuComponent.createIterator());
                while (lunchMenuIterator.hasNext()) {
                    MenuComponent lunchMenuComponent = lunchMenuIterator.next();
                    records.add(new MenuItemRecord(lunchMenuComponent.getName(), lunchMenuComponent.getDescription(), lunchMenuComponent.isVegetarian(), lunchMenuComponent.getPrice()));
                }
            }
        }
        return records;
    }
    public List<MenuItemRecord> getDinner(){
        List<MenuItemRecord> records = new ArrayList<>();
        Menu allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        CompositeIterator compositeIterator = new CompositeIterator(allMenus.createIterator());
        while (compositeIterator.hasNext()) {
            MenuComponent menuComponent = compositeIterator.next();
            if (menuComponent instanceof CafeMenu) {
                CompositeIterator cafeMenuIterator = new CompositeIterator(menuComponent.createIterator());
                while (cafeMenuIterator.hasNext()) {
                    MenuComponent cafeMenuComponent = cafeMenuIterator.next();
                    records.add(new MenuItemRecord(cafeMenuComponent.getName(), cafeMenuComponent.getDescription(), cafeMenuComponent.isVegetarian(), cafeMenuComponent.getPrice()));
                }
            }
        }
        return records;
    }

}