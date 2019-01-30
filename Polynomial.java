
public interface Polynomial {

	/**
	 * takes an integer argument and returns the coefficient of the term that has the
	   argument as its exponent.
	 * @param argument
	 * @return the coefficient of the term that has the
	   argument as its exponent.
	 */
	public double getCoefficient(int argument);
	
	/**
	 * takes a double argument and returns the value of this polynomial at the argument
	 * @param argument
	 * @return the value of this polynomial at the argument
	 */
	public int value(double argument);
	
	/**
	 * takes a LinkedPolynomial; returns a new Polynomial that is the sum of this
		and the argument.
	 * @param argument
	 * @return polynomial that is the sum of this
		and the argument.
	 */
	public Polynomial add(LinkedPolynomial argument);
	
	/**
	 * takes a LinkedPolynomial; returns a new Polynomial that is the difference
		of this and the argument.
	 * @param argument
	 * @return new Polynomial that is the difference
		of this and the argument.
	 */
	public LinkedPolynomial subtract(LinkedPolynomial argument);
	
	/**
	 * @return the negative of the LinkedPolynomial
	 */
	public LinkedPolynomial negate();
	
	

	
	/**
	 * 
	 * @return a hash code for the Polynomial
	 */
	public int hashCode(); 
	
	/**
	 * 
	 * @return a String representation of the Polynomial
	 */
	public String toString();

	/**
	 * takes a Polynomial; returns true if the Polynomials are equal, false otherwise.
	 * @return true if the Polynomials are equal, false otherwise.
	 */
	public boolean equals(LinkedPolynomial obj);
	
}
