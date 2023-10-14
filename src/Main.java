import java.util.*;

class PhoneBook {
    private static HashMap<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(phoneNumber);
            phoneBook.put(name, hashSet);
        }
    }

    public HashSet<Integer> find(String name) {
        if (phoneBook.containsKey(name)) return phoneBook.get(name);
        else return new HashSet<Integer>();
    }

    public static void getPhoneBook() {
        ArrayList<Map.Entry<String, HashSet<Integer>>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort((n1, n2) -> n2.getValue().size() - n1.getValue().size());
        for (Map.Entry<String, HashSet<Integer>> n : list) {
            System.out.println(n);

        }
    }
}

public class Main {
    public static void main(String[] args) {
//        Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать,
//        что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо
//        считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по
//        убыванию числа телефонов.
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Иванов", 9516245);
        myPhoneBook.add("Петров", 9516257);
        myPhoneBook.add("Иванов", 9516265);
        myPhoneBook.add("Сидоров", 9516277);
        myPhoneBook.add("Сидоров", 9516288);
        myPhoneBook.add("Васильев", 9516298);
        myPhoneBook.add("Иванов", 9516299);

        String name = "Сидоров";
        System.out.println(name + ": " + myPhoneBook.find(name));

        myPhoneBook.getPhoneBook();
    }
}