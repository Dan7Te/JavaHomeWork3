//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;

////public class Main {
////    public static void main(String[] args) {
////
////    }
//}

//Задача 1
class Person {
    public String name;
    public  int age;
    public char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void getInfo() {
        System.out.println("Имя: " + name + ", Возвраст: " + age + ", Пол: " + gender);
    }

    public void incrementAge() {
        age++;
    }

    public void changeName(String newName) {
        name = newName;
    }
}

//Задача 2
class Worker extends Person{
    public int salary;
    public Worker(String name, int age, char gender, int salary) {
        super(name, age, gender);
        this.salary = salary;
    }
}

class Manager extends Worker{
    public int[] workers;
    public Manager(String name, int age, char gender, int salary, int[]workers) {
        super(name, age, gender, salary);
        this.workers = workers;
    }
}

//Задача 3
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Му-у-у-у-у!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) animal.makeSound();
    }
}


//Задача 4
abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    void move() {
        System.out.println("Брум-брум!!!");
    }
}

class Bike extends Transport {
    void move() {
        System.out.println("Трынь-Трынь!!!");
    }
}

//Задача 5

class Book {
    public String title;
    public String author;
    public int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Library {
    public ArrayList<Book> books;

    public Library(ArrayList<Book> books){
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void findByAuthor(String author) {
        for (Book book : books)
            if (book.author.equals(author))
                System.out.println("Эту книгу написал: " + book.author);
    }

    public void findByYear(int year) {
        for (Book book : books)
            if (book.year == year)
                System.out.println("Эта книга была написана в : " + book.year);
    }
}

//Задача 6
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void replenishment(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        if (sum <= balance) balance -= sum;
        else System.out.println("Недостаточно средств для списания");
    }

    public double getBalance() {
        return balance;
    }
}

//Задача 7
class Counter {
    private static int i = 0;

    public Counter() {
        i++;
    }

    public static int getCount() {
        return i;
    }
}

//Задача 8
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return width * height;
    }
}

//Задача 9
class Animal1 {
    void move() {
        System.out.println("Животное движется.");
    }
}

class Fish extends Animal1 {
    void move() {
        System.out.println("Рыба плавает");
    }
}

class Bird extends Animal1 {
    void move() {
        System.out.println("Птица летает");
    }
}

class Dog1 extends Animal1 {
    void move() {
        System.out.println("Собака бегает");
    }
}

//Задача 10

class Student {
    public String name;
    public String group;
    public double grade;

    public Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public String getName(){
        return name;
    }
}

class University {
    public ArrayList<Student> students;

    public University(ArrayList<Student> students){
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sort() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public void filter(double minGrade) {
        for (Student student : students)
            if (student.grade >= minGrade)
                System.out.println(student.name);
    }
}

//Задача 11

class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Store {
    public ArrayList<Product> products = new ArrayList<>();

    public Store(ArrayList<Product> products){
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product findByName(String name) {
        for (Product product : products)
            if (product.name.equals(name)) return product;

        return null;
    }
}

//Задача 12
interface PaymentSystem {
    void pay();
    void refund();
}

class CreditCard implements PaymentSystem {
    public void pay() {
        System.out.println("Вы влезли в долги");
    }

    public void refund() {
        System.out.println("Ладно, деньги пришли");
    }
}

class PayPal implements PaymentSystem {
    public void pay() {
        System.out.println("А почему не Pulpy?");
    }

    public void refund() {
        System.out.println("О, вернулся?");
    }
}

//Задача 13

class UniqueID {
    private static int i = 0;
    private String id;

    public UniqueID() {
        this.id = UUID.randomUUID().toString();
        i++;
    }

    public static int getCount() {
        return i;
    }

    public String getId() {
        return id;
    }
}

//Задача 14
class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle1 {
    public Point topLeft;
    public Point bottomRight;

    public Rectangle1(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getArea() {
        return (topLeft.x - bottomRight.x) * (bottomRight.y - topLeft.y);
    }
}

//Задача 15
class ComplexNumber {
    public double real;
    public double unreal;

    public ComplexNumber(double real, double unreal) {
        this.real = real;
        this.unreal = unreal;
    }

    public ComplexNumber add(ComplexNumber x) {
        return new ComplexNumber(this.real + x.real,
                this.unreal + x.unreal);
    }

    public ComplexNumber subtract(ComplexNumber x) {
        return new ComplexNumber(this.real - x.real,
                this.unreal - x.unreal);
    }

    public ComplexNumber multiply(ComplexNumber x) {
        return new ComplexNumber(this.real * x.real - this.unreal * x.unreal,
                this.real * x.unreal + this.unreal * x.real);
    }

    public ComplexNumber divide(ComplexNumber x) {
        double denominator = x.real * x.real + x.unreal * x.unreal;
        return new ComplexNumber((this.real * x.real + this.unreal * x.unreal) / denominator,
                (this.unreal * x.real - this.real * x.unreal) / denominator);
    }
}
