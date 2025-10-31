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

    @Test
    public void testGetCount() {
        CustomList list = new CustomList();
        assertEquals(0, list.countCities());
        list.addCity(new City("Calgary", "AB"));
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(2, list.countCities());
        list.deleteCity(new City("Calgary", "AB"));
        assertEquals(1, list.countCities());
    }
}