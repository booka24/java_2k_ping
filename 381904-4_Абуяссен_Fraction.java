
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0)
            throw new ArithmeticException();
    }

    public static Fraction add(Fraction fractionOne, Fraction fractionTwo) {
        int nok = lcm(fractionOne.getDenominator(), fractionTwo.getDenominator());
        Fraction fractionThree = new Fraction(1, 1);
        fractionThree.setDenominator(nok);
        fractionThree.setNumerator(fractionOne.getNumerator() * fractionTwo.getDenominator() + fractionTwo.getNumerator() * fractionOne.getDenominator());
        int nod = gcd(fractionThree.getNumerator(), fractionThree.getDenominator());
        fractionThree.setDenominator(nok / nod);
        fractionThree.setNumerator(fractionThree.getNumerator() / nod);
        return fractionThree;
    }

    public static Fraction mul(Fraction fractionOne, Fraction fractionTwo) {
        Fraction fractionThree = new Fraction((fractionOne.getNumerator() * fractionTwo.getNumerator()), fractionOne.getDenominator() * fractionTwo.getDenominator());
        int nod = gcd(fractionThree.getNumerator(), fractionThree.getDenominator());
        fractionThree.setDenominator(fractionThree.getDenominator() / nod);
        fractionThree.setNumerator(fractionThree.getNumerator() / nod);
        return fractionThree;
    }

    public static Fraction sub(Fraction fractionOne, Fraction fractionTwo) {
        int nok = lcm(fractionOne.getDenominator(), fractionTwo.getDenominator());
        Fraction fractionThree = new Fraction(1, 1);
        fractionThree.setDenominator(nok);
        fractionThree.setNumerator(fractionOne.getNumerator() * fractionTwo.getDenominator() - fractionTwo.getNumerator() * fractionOne.getDenominator());
        int nod = gcd(fractionThree.getNumerator(), fractionThree.getDenominator());
        fractionThree.setDenominator(nok / nod);
        fractionThree.setNumerator(fractionThree.getNumerator() / nod);
        return fractionThree;
    }

    public static Fraction div(Fraction fractionOne, Fraction fractionTwo) {
        Fraction fractionThree = new Fraction((fractionOne.getNumerator() * fractionTwo.getDenominator()), (fractionTwo.getNumerator() * fractionOne.getDenominator()));
        int nod = gcd(fractionThree.getNumerator(), fractionThree.getDenominator());
        fractionThree.setDenominator(fractionThree.getDenominator() / nod);
        fractionThree.setNumerator(fractionThree.getNumerator() / nod);
        return fractionThree;
    }

    static int gcd(int a, int b) {
        int c = a;
        int d = b;
        return d == 0 ? c : gcd(d, c % d);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "\n-\n" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (numerator != fraction.numerator) return false;
        return denominator == fraction.denominator;

    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }
}
