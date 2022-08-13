import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int summary = 0;
        Product[] products = {new Product(40, "Хлеб"), new Product(70, "Молоко"),
                new Product(150, "Сыр"), new Product(400, "Колбаса"),
                new Product(170, "Печенье")};
        System.out.println("Добро пожаловать магазин! Обратите внимание на текущий ассортимент товаров:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i+1) + ". " + products[i].getName() + " по цене " + products[i].getPrice() + " руб.");
        }
        while (true) {
            try {
                System.out.println("Введите продукт который хотите положить в корзину в формате: номер_продукта количество. " +
                        "Для выхода наберите end.");
                String input = scanner.nextLine();
                if ("end".equals(input)) {
                    System.out.println("Программа завершена!");
                    scanner.close();
                    break;
                }
                String[] userChoice = input.split(" ");
                if (userChoice.length != 2) {
                    System.out.println("Ошибка в формате выбора продукта");
                    continue;
                }
                int prod = Integer.parseInt(userChoice[0]) - 1;
                int count = Integer.parseInt(userChoice[1]);
                if (prod >= products.length || prod < 0) {
                    System.out.println("Такого продукта нет в ассортименте");
                    continue;
                }
                if (count < 0) {
                    System.out.println("Вы ввели неправильное количество товара: " + count);
                    continue;
                }
                products[prod].addCount(count);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода, вы ввели не число");
                continue;
            }
        }
        System.out.println("Ваша корзина:");
        for (Product product : products) {
            if (product.getCount() != 0) {
                System.out.println(product.getName() + " в количестве " + product.getCount() + " шт., " + "стоимостью "
                        + product.getPrice() + " рублей. Итого = " + product.getPrice() * product.getCount() + " рублей.");
                summary += product.getPrice() * product.getCount();
            }
        }
        System.out.println("Общая сумма: " + summary + " рублей.");
        scanner.close();
    }
}
