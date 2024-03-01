public class Fraction {
    int m; // Числитель
    int n; // Знаменатель

    Fraction() {
        m = 1;
        n = 1;
    }
    Fraction(int denominator) {
        m = 1;
        n = denominator;
    }
    Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }

    // Сложение дробей
    public void plus(Fraction other) {
        this.m = this.m * other.n + this.n * other.m;
        this.n *= other.n;
    }

    // Вычитание дробей
    public void minus(Fraction other) {
        this.m = this.m * other.n - this.n * other.m;
        this.n *= other.n;
    }

    // Умножение дробей
    public void multiply(Fraction other) {
        this.m *= other.m;
        this.n *= other.n;
    }

    // Деление дробей
    public void divide(Fraction other) {
        this.m *= other.n;
        this.n *= other.m;
    }
}