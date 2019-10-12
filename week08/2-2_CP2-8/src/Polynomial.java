public class Polynomial {
	private List<Term> poly = new LinkedList<>();

	public Polynomial() {
		poly.addFirst(Term.ZERO);
	}

	public Polynomial(double coef, int exp) {
		poly.addFirst(Term.ZERO);
		poly.addFirst(new Term(coef, exp));
	}

	public Polynomial(Term term) {
		poly.addFirst(Term.ZERO);
		poly.addFirst(term);
	}

	public Polynomial(Term... terms) {
		poly.addFirst(Term.ZERO);

	}

	public void plus(Term term) {
		for (int i = 0; i < poly.size(); i++) {
			if (term.getExp() > poly.get(i).getExp()) {
				poly.add(i, term);
				break;
			} else if (term.getExp() == poly.get(i).getExp()) {
				poly.set(i, poly.get(i).plus(term));
				break;
			}
		}
	}

	public void plus(double coef, int exp) {
		Term term = new Term(coef, exp);
		for (int i = 0; i < poly.size(); i++) {
			if (term.getExp() > poly.get(i).getExp()) {
				poly.add(i, term);
				break;
			} else if (term.getExp() == poly.get(i).getExp()) {
				poly.set(i, poly.get(i).plus(term));
				break;
			}
		}
	}

	public Polynomial polyPlus(Polynomial otherPoly) { // polyPlus�� ȣ���ϰ� �ִ� ���׽İ� ���ڷο� �ٸ� ���׽��� ���� ���ο� ���׽��� ����
		Polynomial a = new Polynomial();
		int g = 0;
		int f = 0;

		while (g < this.poly.size() - 1 || f < otherPoly.poly.size() - 1) {
			if (this.poly.get(g).getExp() > otherPoly.poly.get(f).getExp()) {
				a.plus(this.poly.get(g).getCoef(), this.poly.get(g).getExp());
				g++;
			} 
			else if (this.poly.get(g).getExp() < otherPoly.poly.get(f).getExp()) {
				a.plus(otherPoly.poly.get(f).getCoef(), otherPoly.poly.get(f).getExp());
				f++;
			} 
			else if (this.poly.get(g).getExp() == otherPoly.poly.get(f).getExp()) {
				a.plus(this.poly.get(g).getCoef() + otherPoly.poly.get(f).getCoef(), otherPoly.poly.get(f).getExp());
				g++;
				f++;
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder str = new StringBuilder(poly.get(0).toString());

		for (int i = 1; i < poly.size() - 1; i++)
			if (poly.get(i).getCoef() > 0)
				str.append(" +" + poly.get(i));
			else
				str.append(poly.get(i));
		return new String(str);
	}

	public static void main(String[] arg) {
		Polynomial f = new Polynomial(new Term(1, 1)); // ���׽� f�� ����
		f.plus(new Term(3, 3)); // x Term�� 3x^3 Term�� ����
		f.plus(new Term(2, 2)); // 3x^3 + x�� 2x^2 Term�� ����
		f.plus(new Term(7, 0));

		Polynomial g = new Polynomial();
		g.plus(new Term(4, 4));
		g.plus(new Term(5, 5));
		g.plus(new Term(1, 2));
		g.plus(new Term(2, 3));

		System.out.println("f(x) = " + f);
		System.out.println("g(x) = " + g);

		Polynomial z = g.polyPlus(f);
		System.out.println("f(x) + g(x) = " + z);
	}
}
