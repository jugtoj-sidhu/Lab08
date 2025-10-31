package com.example.lab08;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testHasCityAbsent() {
        CustomList list = new CustomList();
        list.addCity(new City("Calgary", "AB"));
        assertFalse(list.hasCity(new City("Edmonton", "AB")));
    }

    @Test
    public void testDeleteCityRemoves() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        list.deleteCity(calgary);
        assertFalse(list.hasCity(calgary));
    }

    @Test
    public void testDeleteCityMissingThrows() {
        CustomList list = new CustomList();
        assertThrows(IllegalArgumentException.class, () ->
                list.deleteCity(new City("Regina", "SK"))
        );
    }
}