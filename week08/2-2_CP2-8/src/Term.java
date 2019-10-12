
public class Term {
	private double coef;
	private int exp;
	public static final Term ZERO = new Term();

	private Term() {
		this.exp = -1;
	}

	public Term(double coef, int exp) {
		if (coef == 0.0 || exp < 0)
			throw new IllegalArgumentException();
		this.coef = coef;
		this.exp = exp;
	}

	public Term(Term term) {
		this(term.coef, term.exp);
	}

	public Term abs() {
		return new Term(Math.abs(coef), exp);
	}

	public boolean equlas(Object object) {
		if (object == this)
			return true;
		if (!(object instanceof Term))
			return false;
		Term other = (Term) object;
		return (this.coef == other.coef && this.exp == other.exp);
	}

	public double getCoef() {
		return coef;
	}

	public int getExp() {
		return exp;
	}

	public Term plus(Term other) {
		if (other.exp != this.exp)
			throw new IllegalArgumentException();
		double coef = this.coef + other.coef;
		if (coef == 0.0)
			return ZERO;
		return new Term(coef, this.exp);
	}

	public Term times(double factor) {
		if (factor == 0.0)
			return ZERO;
		return new Term(coef * factor, exp);
	}

	public Term times(Term term) {
		if (term.coef == 0.0)
			return ZERO;
		return new Term(coef * term.coef, exp + term.exp);
	}

	public String toString() {
		if (coef == 0.0)
			return "0";
		if (exp == 0.0)
			return Double.toString(coef);
		String str;
		if (coef == 1.0)
			str = "";
		else if (coef == -1.0)
			str = "-";
		else
			str = "" + (float) coef;
		if (exp == 0)
			return str;
		if (exp == 1)
			return str + "x";
		return str + "x^" + exp;
	}

	public double valueAt(double x) {
		return coef * Math.pow(x, exp);
	}

	public static void main(String[] arg) {
		System.out.println(Term.ZERO);
	}

}