import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Address, Integer> costPerAddress = new HashMap<>();
        int total = 0;
        Set<String> countries = new HashSet<>();

        Address delivery1 = new Address("Россия", "Санкт-Петербург");
        costPerAddress.put(delivery1, 100);

        Address delivery2 = new Address("Россия", "Москва");
        costPerAddress.put(delivery2, 150);

        Address delivery3 = new Address("Индия", "Дели");
        costPerAddress.put(delivery3, 830);

        Address delivery4 = new Address("Китай", "Пекин");
        costPerAddress.put(delivery4, 910);

        Address delivery5 = new Address("Германия", "Франкфурт");
        costPerAddress.put(delivery5, 520);

        while (true) {
            System.out.print("Заполнение нового заказа.\n" +
                    "Введите страну: ");
            String country = sc.nextLine();
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город: ");
            String city = sc.nextLine();
            if ("end".equals(city)) {
                break;
            }
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(sc.nextLine());

            Address address = new Address(country, city);
            if (costPerAddress.containsKey(address)) {
                int price = costPerAddress.get(address) * weight;
                total += price;
                countries.add(country);
                System.out.printf("Стоимость доставки составит: %d руб.\n", price);
                System.out.printf("Общая стоимость всех доставок: %d руб.\n", total);
                System.out.printf("Количество посещенных стран: %d\n", countries.size());
            } else {
                System.out.println("Доставки по такому адресу нет.");
            }
        }
    }
}