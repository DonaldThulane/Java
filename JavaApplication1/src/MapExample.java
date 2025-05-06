import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        // a. Add at least five elements to the HashMap
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "Apple");
        hashMap.put("B", "Banana");
        hashMap.put("C", "Cherry");
        hashMap.put("D", "Date");
        hashMap.put("E", "Elderberry");

        // b. Print out all the elements in the HashMap, including their keys
        System.out.println("HashMap Elements:");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // c. Find and print out the value of a specific key
        String keyToFind = "C";
        System.out.println("\nValue for key '" + keyToFind + "': " + hashMap.get(keyToFind));

        // d. Remove one of the elements from the HashMap
        hashMap.remove("D");

        // e. Print out the HashMap after removing the element
        System.out.println("\nHashMap after removal:");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // f. Add at least five elements to the LinkedHashMap
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("F", "Fig");
        linkedHashMap.put("G", "Grape");
        linkedHashMap.put("H", "Honeydew");
        linkedHashMap.put("I", "Indian Fig");
        linkedHashMap.put("J", "Jackfruit");

        // g. Print out all the elements in the LinkedHashMap
        System.out.println("\nLinkedHashMap Elements:");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

