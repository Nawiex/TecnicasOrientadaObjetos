abstract class Figura {
    public abstract double calcularArea();
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        if (radio <= 0)
            throw new IllegalArgumentException("El radio debe ser positivo.");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

class Rectangulo extends Figura {
    private double base, altura;

    public Rectangulo(double base, double altura) {
        if (base <= 0 || altura <= 0)
            throw new IllegalArgumentException("Los valores deben ser positivos.");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

class Triangulo extends Figura {
    private double base, altura;

    public Triangulo(double base, double altura) {
        if (base <= 0 || altura <= 0)
            throw new IllegalArgumentException("Los valores deben ser positivos.");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
}
