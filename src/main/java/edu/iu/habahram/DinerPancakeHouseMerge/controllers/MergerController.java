package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }
    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarian(){
        List<MenuItemRecord> items = mergerRepository.getVegetarian();
        return items;
    }
    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast(){
        List<MenuItemRecord> breakfast = mergerRepository.getBreakfast();
        return breakfast;
    }
    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch(){
        return mergerRepository.getLunch();
    }
    @GetMapping("/supper")
    public List<MenuItemRecord> getSupper(){
        List<MenuItemRecord> supper = mergerRepository.getDinner();
        return supper;
    }
}