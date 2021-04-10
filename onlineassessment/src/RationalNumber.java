import java.text.DecimalFormat;

/**
 * @Description:
 * @author: Jayden
 * @date:4/8/21 4:14 PM
 */
public class RationalNumber {
    public static void main(String[] args) {
        RationalNumber rn = new RationalNumber(4, 7);
        System.out.println(rn.printDecimal());
        System.out.println(rn.printFraction());
        RationalNumber r2 = new RationalNumber(4, 7);
        System.out.println(rn.add(r2).printFraction());
    }
    private int numerator, denominator;
    //-----------------------------------------------------------------
    //  Constructor: Sets up the rational number by ensuring a nonzero
    //  denominator and making only the numerator signed.
    //-----------------------------------------------------------------
    public RationalNumber (int numer, int denom)
    {
        if (denom == 0)
            denom = 1;
        // Make the numerator "store" the sign
        if (denom < 0)
        {
            numer = numer * -1;
            denom = denom * -1;
        }
        numerator = numer;
        denominator = denom;
        reduce();
    }

    //-----------------------------------------------------------------
    //  Returns the numerator of this rational number.
    //-----------------------------------------------------------------
    public int getNumerator ()
    {
        return numerator;
    }

    //-----------------------------------------------------------------
    //  Returns the denominator of this rational number.
    //-----------------------------------------------------------------
    public int getDenominator ()
    {
        return denominator;
    }

    //-----------------------------------------------------------------
    //  Returns this rational number as a string.
    //-----------------------------------------------------------------
    public String printFraction ()
    {
        String result;

        if (numerator == 0)
            result = "0";
        else
        if (denominator == 1)
            result = numerator + "";
        else
            result = numerator + "/" + denominator;

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns the decimal of this rational number.
    //-----------------------------------------------------------------
    public String printDecimal() {
        float price = (float) denominator / numerator;
        DecimalFormat decimalFormat = new DecimalFormat( ".00" );
        String p= decimalFormat.format(price);
        int index = p.indexOf(".");
        return p.substring(index + 1, p.length());
    }

    //-----------------------------------------------------------------
    //  Returns the reciprocal of this rational number.
    //-----------------------------------------------------------------
    public RationalNumber reciprocal ()
    {
        return new RationalNumber (denominator, numerator);
    }

    //-----------------------------------------------------------------
    //  Adds this rational number to the one passed as a parameter.
    //  A common denominator is found by multiplying the individual
    //  denominators.
    //-----------------------------------------------------------------
    public RationalNumber add (RationalNumber op2)
    {
        int commonDenominator = denominator * op2.getDenominator();
        int numerator1 = numerator * op2.getDenominator();
        int numerator2 = op2.getNumerator() * denominator;
        int sum = numerator1 + numerator2;

        return new RationalNumber (sum, commonDenominator);
    }

    //-----------------------------------------------------------------
    //  Subtracts the rational number passed as a parameter from this
    //  rational number.
    //-----------------------------------------------------------------
    public RationalNumber subtract (RationalNumber op2)
    {
        int commonDenominator = denominator * op2.getDenominator();
        int numerator1 = numerator * op2.getDenominator();
        int numerator2 = op2.getNumerator() * denominator;
        int difference = numerator1 - numerator2;

        return new RationalNumber (difference, commonDenominator);
    }

    //-----------------------------------------------------------------
    //  Multiplies this rational number by the one passed as a
    //  parameter.
    //-----------------------------------------------------------------
    public RationalNumber multiply (RationalNumber op2)
    {
        int numer = numerator * op2.getNumerator();
        int denom = denominator * op2.getDenominator();

        return new RationalNumber (numer, denom);
    }

    //-----------------------------------------------------------------
    //  Divides this rational number by the one passed as a parameter
    //  by multiplying by the reciprocal of the second rational.
    //-----------------------------------------------------------------
    public RationalNumber divide (RationalNumber op2)
    {
        return multiply (op2.reciprocal());
    }

    //-----------------------------------------------------------------
    //  Determines if this rational number is equal to the one passed
    //  as a parameter.  Assumes they are both reduced.
    //-----------------------------------------------------------------
    public boolean equals (RationalNumber op2)
    {
        return ( numerator == op2.getNumerator() &&
                denominator == op2.getDenominator() );
    }

    //-----------------------------------------------------------------
    //  Reduces this rational number by dividing both the numerator
    //  and the denominator by their greatest common divisor.
    //-----------------------------------------------------------------
    private void reduce ()
    {
        if (numerator != 0)
        {
            int common = gcd (Math.abs(numerator), denominator);

            numerator = numerator / common;
            denominator = denominator / common;
        }
    }

    //-----------------------------------------------------------------
    //  Computes and returns the greatest common divisor of the two
    //  positive parameters. Uses Euclid's algorithm.
    //-----------------------------------------------------------------
    private int gcd (int num1, int num2)
    {
        while (num1 != num2) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num1;
    }
}
