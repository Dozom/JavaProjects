package calculadora;

import java.util.Scanner;
import colores.Colores;

public class Calculadora {

    Colores c = new Colores();

    private int width;
    private int height;
    private String brand;
    private String model;
    private int firstNumber;
    private int secondNumber;

    public Calculadora(){

        Scanner s = new Scanner(System.in);

        System.out.print(c.ANSI_BLUE + "introduce la anchura de la calculadora: " + c.ANSI_RESET);
        this.setWidth(s.nextInt());
        s.nextLine();

        System.out.print(c.ANSI_RED + "introduce la altura de la calculadora: " + c.ANSI_RESET);
        this.setHeight(s.nextInt());
        s.nextLine();

        System.out.print(c.ANSI_GREEN + "introduce la marca de la calculadora: " + c.ANSI_RESET);
        this.setBrand(s.nextLine());

        System.out.print(c.ANSI_CYAN + "introduce el modelo de la calculadora: " + c.ANSI_RESET);
        this.setModel(s.nextLine());

        System.out.println("¿ Qué operación deseas Ejecutar ? Escribe la letra de la operación.");
        System.out.println("\tA) Sumar");
        System.out.println("\tB) Restar");
        System.out.println("\tC) Multiplicar");
        System.out.println("\tD) Dividir");
        this.calculateOperation(s.nextLine());
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void calculateOperation(String operation){

        switch (operation){
            case "A":
                this.askForNumbers();
                System.out.println(c.ANSI_YELLOW + "El resultado de la suma es: " + this.sumar() + c.ANSI_RESET);
                break;
            case "B":
                this.askForNumbers();
                System.out.println(c.ANSI_YELLOW + "El resultado de la resta es: " + this.restar() + c.ANSI_RESET);
                break;
            case "C":
                this.askForNumbers();
                System.out.println(c.ANSI_YELLOW + "El resultado de la multiplicación es: " + this.multiplicar() + c.ANSI_RESET);
                break;
            case "D":
                this.askForNumbers();
                System.out.println(c.ANSI_YELLOW + "El resultado de la división es: " +this.dividir() + c.ANSI_RESET);
                break;
        }
    }
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public void askForNumbers(){
        Scanner s = new Scanner(System.in);

        System.out.println("Introduce el primer número para la operación.");
        this.firstNumber = s.nextInt();
        s.nextLine();

        System.out.println("Introduce el segundo número para la operación.");
        this.secondNumber = s.nextInt();
        s.nextLine();
    }

    private int sumar(){
        return firstNumber + secondNumber;
    }

    private int restar(){
        return firstNumber - secondNumber;
    }

    private int multiplicar(){
        return firstNumber * secondNumber;
    }

    private int dividir(){
        return firstNumber / secondNumber;
    }

    public void getInfo(){
        System.out.println("Los datos de tu calculadora son:");
        System.out.println("Ancho: " + this.getWidth());
        System.out.println("Alto: " + this.getHeight());
        System.out.println("Marca: " + this.getBrand());
        System.out.println("Modelo: " + this.getModel());
    }
}
