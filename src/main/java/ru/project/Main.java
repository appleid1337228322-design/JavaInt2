package ru.project;

import ru.project.dao.UserDao;
import ru.project.dao.UserDaoImpl;
import ru.project.entity.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserDao dao = new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Создать пользователя");
            System.out.println("2 - Показать всех пользователей");
            System.out.println("3 - Удалить пользователя");
            System.out.println("4 - Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Возраст: ");
                    int age = scanner.nextInt();

                    dao.save(new User(name, email, age));
                }

                case 2 -> dao.findAll().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID: ");
                    Long id = scanner.nextLong();
                    dao.delete(id);
                }

                case 4 -> System.exit(0);
            }
        }
    }
}
