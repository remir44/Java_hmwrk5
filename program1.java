// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class program1 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Tom", List.of("123", "124"));
        phoneBook.put("Will", List.of("234", "235"));
        phoneBook.put("Kate", List.of("345", "346"));
        phoneBook.put("Anne", List.of("456"));
        phoneBook.put("James", List.of("567", "568"));

        Menu(phoneBook);
    }

    public static String Input() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static void Find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = Input();
        System.out.println(phoneBook.get(name));
    }

    public static void ViewAll(Map<String, List<String>> phoneBook) {
        for (var item : phoneBook.entrySet()) {
            System.out.printf("[%s: %s]\n", item.getKey(), item.getValue());
        }
    }

    public static void Delete(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = Input();
        phoneBook.remove(name);
        System.out.printf("Контакт с именем [%s] был удалён.\n", name);
    }

    public static Map<String, List<String>> Add(Map<String, List<String>> phoneBook) {
        System.out.println("Чтобы перестать вводить номера введите 'stop'.");
        System.out.println("Введите имя: ");
        String name = Input();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phone = Input();
            if (phone.equals("stop")) {
                break;
            } else {
                number.add(phone);
            }
        }
        phoneBook.put(name, number);

        return phoneBook;
    }

    public static Map<String, List<String>> Menu(Map<String, List<String>> phoneBook) {
        System.out.println(
                "Введите команду из списка:\n all - показать всю телефонную книгу,\n find - найти контакт,\n add - добавить контакт,\n delete - удалить контакт,\n exit - выйти");
        while (true) {
            String commands = Input();
            if (commands.equals("exit")) {
                break;
            } else {
                switch (commands) {
                    case "all":
                        ViewAll(phoneBook);
                        break;
                    case "find":
                        Find(phoneBook);
                        break;
                    case "add":
                        Add(phoneBook);
                        break;
                    case "delete":
                        Delete(phoneBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phoneBook;
    }
}