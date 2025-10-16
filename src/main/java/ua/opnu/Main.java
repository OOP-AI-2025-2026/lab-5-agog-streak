package ua.opnu;

import main.java.ua.opnu.Lecturer;
import main.java.ua.opnu.Person;
import main.java.ua.opnu.Student;

public class Main {
    public static void main(String[] args) {
            // Створюємо об'єкти Student та Lecturer
            Student s1 = new Student("Іваненко", "Олексій", 20, "АІ-241", "ST12345");
            Student s2 = new Student("Петренко", "Марія", 19, "АІ-241", "ST12346");

            Lecturer l1 = new Lecturer("Коваль", "Сергій", 45, "Кафедра ІТ", 15000.0);
            Lecturer l2 = new Lecturer("Мельник", "Олена", 38, "Кафедра Математики", 12000.0);

            // Створюємо масив типу Person
            Person[] people = {s1, s2, l1, l2, new Person("Бондар", "Ігор", 50)};

            // Виводимо інформацію за допомогою toString()
            for (Person p : people) {
                System.out.println(p.toString());
            }
        }
    }