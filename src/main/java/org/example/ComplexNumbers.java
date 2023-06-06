package org.example;

public class ComplexNumbers {
    private double real;
    private double imagine;

    public ComplexNumbers(double real, double imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public ComplexNumbers add(ComplexNumbers c1){
        double realPart = c1.real + this.real;
        double imaginePart = c1.imagine + this.imagine;
        return new ComplexNumbers(realPart,imaginePart);
    }

    public ComplexNumbers subtract(ComplexNumbers c1){
        double realPart = c1.real - this.real;
        double imaginePart = c1.imagine - this.imagine;
        return new ComplexNumbers(realPart,imaginePart);
    }

    public ComplexNumbers multiply(ComplexNumbers c1){
        double realPart = this.real* c1.real - this.imagine* c1.imagine;
        double imaginePart = this.real * c1.imagine + this.imagine* c1.real;
        return new ComplexNumbers(realPart,imaginePart);

    }

    public double magnitude(){
        return (Math.sqrt(Math.pow(real,2)+Math.pow(imagine,2)));
    }

    @Override
    public String toString() {

        return String.format("""
                %.02f + %.02fi""", this.real, this.imagine);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImagine() {
        return imagine;
    }

    public void setImagine(double imagine) {
        this.imagine = imagine;
    }
}
