/*
Donny Nguyen
IB CS 1 SL
1560321

Name: Timmy
breed: Corgi
weight : 12.0
age: 5
temperament : Friendly
Name: Timmy Jr
breed: Golden Retriever
weight : 65.0
age: 6
temperament : Playful
Name: Timmy Sr
breed: Dachshund
weight : 20.0
age: 7
temperament : Independent

*/

import java.util.Scanner;
public class Dog
{
    public String breed;
    double weight;
    int age;
    String temperament;
    String name;

    // Default constructor

    public Dog()
    {
        breed = "";
        weight = 0.0;
        age = 0;
        temperament = "";
        name = "";

    }

    // 5-arg constructor
    public Dog(String breed, double weight, int age, String temperament, String name )
    {
        this.breed = breed;
        this.weight = weight;
        this.age = age;
        this.temperament = temperament;
        this.name = name;


    } // end n-arg constructor

    public void print(){
        String str;
        str = "Name: "  + name + "\n" +
                "breed: " + breed + "\n" +
                "weight : "  + weight  + "\n" +
                "age: " + age + "\n" +
                "temperament : "  + temperament;

        System.out.println(str + "\n\n");

    } // end toString

    public String toString(){
        String str;
        str = "Name: "  + name + "\n" +
                "breed: " + breed + "\n" +
                "weight : "  + weight  + "\n" +
                "age: " + age + "\n" +
                "temperament : "  + temperament;
        return str;
    } // end toString

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Dog [] dogArr = new Dog [3];

        for (int i = 0; i < dogArr.length; i++) {
            String word = "";

            System.out.println("type something");
            String breed = "";
            double weight = 0.0;
            int age = 0;
            String temperament = "";
            String name = "";

            System.out.println("Breed?");
            breed = input.nextLine();
            System.out.println("Weight?");
            weight = input.nextDouble();
            System.out.println("Age?");
            age = input.nextInt();
            input.nextLine();
            System.out.println("Temperament?");
            temperament = input.nextLine();
            System.out.println("Name?");
            name = input.nextLine();

            dogArr[i] = new Dog(breed,weight,age,temperament,name);
        }

        for (int i = 0; i < dogArr.length; i++) {
            System.out.println(dogArr[i].toString());
        }

    }

}