package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(capacity > data.size())
            data.add(pet);
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (name.equals(pet.getName())) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet: data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner))
                return pet;
        }
        return  null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        String value = "The grooming salon has the following clients:\n";
        for (Pet pet : data) {
            value += String.format("%s %s\n", pet.getName(), pet.getOwner());
        }
        return value;
    }
}
