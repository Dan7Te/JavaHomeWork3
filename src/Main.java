//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;
import java.util.Scanner;

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

//Задача 16
class Matrix {
    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix(int rows, int cols) {
        matrix = new int[rows][cols];
    }

    public void Add(Matrix sumMatrix) {
        for(int i = 0; i < sumMatrix.getMatrix().length; i++){
            for(int j = 0; j < sumMatrix.getMatrix()[0].length; j++){
                matrix[i][j] += sumMatrix.getMatrix()[i][j];
            }
        }
    }

    public void Add(int[][] sumMatrix) {
        for(int i = 0; i < sumMatrix.length; i++){
            for(int j = 0; j < sumMatrix[0].length; j++){
                matrix[i][j] += sumMatrix[i][j];
            }
        }
    }

    public void Multiply(Matrix multMatrix) {
        if(matrix.length != multMatrix.getMatrix()[0].length) {
            System.out.println("Матрицы нельзя перемножить");
            return;
        }

        Matrix result = new Matrix(matrix.length, multMatrix.getMatrix()[0].length);

        for (var i = 0; i < result.getMatrix().length; i++) {
            for (var j = 0; j < result.getMatrix()[0].length; j++) {
                result.getMatrix()[i][j] = 0;
                for (var k = 0; k < matrix[0].length; k++) {
                    result.getMatrix()[i][j] += matrix[i][k] * multMatrix.getMatrix()[k][j];
                }
            }
        }
    }

    public void Multiply(int[][] multMatrix) {
        if(matrix.length != multMatrix[0].length) {
            System.out.println("Матрицы нельзя перемножить");
            return;
        }

        Matrix result = new Matrix(matrix.length, multMatrix[0].length);

        for (var i = 0; i < result.getMatrix().length; i++) {
            for (var j = 0; j < result.getMatrix()[0].length; j++) {
                result.getMatrix()[i][j] = 0;
                for (var k = 0; k < matrix[0].length; k++) {
                    result.getMatrix()[i][j] += matrix[i][k] * multMatrix[k][j];
                }
            }
        }
    }
}

//Задача 17
class Player {
    private String name;
    private int hp;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.hp = health;
        this.weapon = weapon;
    }

    public String getName(){
        return name;
    }

    public void Attack(Enemy enemy) {
        System.out.println(name + " бъёт " + enemy.getName() +
                " при помощи " + weapon.getName() + " и наносит " +
                weapon.getDamage() + " единиц урона");
    }

    public void Heal(int hp){
        this.hp += hp;
        System.out.println("Игрок " + name + " подлечился на " + hp + "очков здоровья");
    }

    public void Hurt(Enemy enemy){
        hp -= enemy.getDamage();
        System.out.println(name + " получил " + enemy.getDamage() + " урона.");
    }
}

class Enemy {
    private String name;
    private int damage;

    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage(){
        return damage;
    }
}

class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }
}

//Задача 18

class Order{
    private ArrayList<Product1> products = new ArrayList<>();

    public Order(ArrayList<Product1> products){
        this.products = products;
    }

    public void addProduct(Product1 product) {
        products.add(product);
    }

    public void removeProduct(Product1 product) {
        products.remove(product);
    }

    public void getProductsList(){
        for(Product1 item: products) System.out.println(item.getName());
    }

    public double totalPrice() {
        double total = 0;
        for (Product1 product : products) total += product.getPrice();
        return total;
    }
}

class Customer{
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order MakeOrder(ArrayList<Product1> order){
        return new Order(order);
    }
}

class Product1{
    private String name;
    private double price;

    public Product1(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }
}

// Задача 19
class Device{
    private String brand;

    public Device(String brand){
        this.brand = brand;
    }

    public void turnOn(){
        System.out.println("Девайс включен!");
    }

    public void turnOff(){
        System.out.println("Девайс выключен!");
    }
}

class SmartPhone extends Device{

    public SmartPhone(String brand) {
        super(brand);
    }

    public void takePhoto(){
        System.out.println("Фото сделано");
    }

    public void Call(){
        System.out.println("Вы позвонили!");
    }
}

class Laptop extends Device{

    public Laptop(String brand){
        super(brand);
    }

    public void Open(){
        System.out.println("Вы открыли ноутбук");
    }

    public void Close(){
        System.out.println("Вы закрыли ноутбук");
    }
}


//Задача 20
class TicTacToePlayer {
    private String name;
    private char symbol;

    public TicTacToePlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char GetSymbol(){
        return symbol;
    }
}

class Game{
    private char[][] field;
    private TicTacToePlayer player1;
    private TicTacToePlayer player2;
    private TicTacToePlayer currentPlayer;

    public Game(TicTacToePlayer player1, TicTacToePlayer player2){
        if(player1.GetSymbol() == player2.GetSymbol()){
            System.out.println("Вы не можете играть одинаковыми символами!");
            return;
        }
        this.player1 = player1;
        this.currentPlayer = player1;
        this.player2 = player2;
        field = new char[3][3];
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                field[i][j] = ' ';
            }
        }
    }

    public boolean Step(int a, int b){
        if(a > 3 || b > 3 || a < 1 || b < 1){
            System.out.println("Вы не можете ходить вне поля!");
            return false;
        }
        if(field[a-1][b-1] != ' ') {
            System.out.println("Это поле занято!");
            return false;
        }

        field[a-1][b-1] = currentPlayer.GetSymbol();
        currentPlayer = (currentPlayer == player1 ? player1 : player2);
        return true;
    }

    public boolean IsCurrentPlayerWin(){
        char symbol = currentPlayer.GetSymbol();
        for(int i = 0; i < 3; i++){
            if(field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) return true;
            else if(field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol) return true;
        }
        if(field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol ||
            field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol)
            return true;

        return false;
    }

    public boolean IsFieldFull(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                if(field[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void showField(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                System.out.println(field[i][j] + " ");
            }
        }
    }

    public void Play(){
        Scanner in = new Scanner(System.in);
        while(true){
            showField();

            System.out.println("Введите координаты хода в формате \"xy\" где x-строка, а y-колонка;");
            int xy = in.nextInt();
            int x = xy/10;
            int y = xy%10;

            if(!Step(x,y)) continue;

            if(IsCurrentPlayerWin()){
                System.out.println(currentPlayer.getName() + " победил!");
                break;
            }
            else if(IsFieldFull()){
                System.out.println("Ничья!");
                break;
            }
        }
        in.close();
    }
}
