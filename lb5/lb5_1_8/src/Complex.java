public class Complex {
    int a;
    int b;

    Complex() {
        a = 1;
        b = 0;
    }
    Complex(int imaginary) {
        a = 1;
        b = imaginary;
    }
    Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void plus(Complex other) {
        this.a += other.a;
        this.b += other.b;
    }

    public void minus(Complex other) {
        this.a -= other.a;
        this.b -= other.b;
    }

    public void multiply(Complex other) {
        this.a = this.a * other.a - this.b * other.b;
        this.b = this.a * other.b + this.b * other.a;
    }

    public void divide(Complex other) {
        try {
            this.a = (this.a * other.a + this.b * other.b) / (other.b * other.b + other.a * other.a);
            this.b = (this.a * other.b - this.b * other.a) / (other.b * other.b + other.a * other.a);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
    }

    public void setComplex(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

