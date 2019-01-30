
public class LinkedPolynomial implements Polynomial{ 
	
	public class Polynomial{
		public double coefficient;
		public int exponent;
		public Polynomial next;
		public Polynomial previous;
		
		public Polynomial(double coefficient, int exponent, Polynomial next, Polynomial previous){
			this.coefficient = coefficient; 
			this.exponent = exponent;
			this.next = next;
			this.previous = previous;
		}
		
		public Polynomial getNext() {
			return this.next;
		}
		
		public void setNext(Polynomial next) {
			this.next = next;
		}
	
	}
	
	Polynomial head;
	Polynomial tail;
	Polynomial next;
	int degree;
	int size;
	
	public LinkedPolynomial(String expression) {
		head = new Polynomial(0,0, tail, null);
		tail = new Polynomial(0, 0, null, head);
		this.degree = 0;
		this.size = 0;
		
		String coefficient = null;
		String exponenet = null;
		
		//expression.replaceAll("\\s+", "");
		String[] list = expression.split(",");
		
		int count = 0;
		Polynomial current = null;
		for(int j = 0; j < list.length; j+=2) {
			coefficient = list[j].trim();
			exponenet = list[j+1].trim();
			
			if(current == null) {
				Polynomial newP = new Polynomial(Double.parseDouble(coefficient), Integer.parseInt(exponenet), tail, head);
				head.next = newP;
				current = newP;
				size = size++;
			}
			else {
				Polynomial newP = new Polynomial(Double.parseDouble(coefficient), Integer.parseInt(exponenet), tail, current);
				current.next = newP;
				current = newP;
				size = size++;
			}
		}
	}
	
	public LinkedPolynomial() {
		head = new Polynomial(0,0,tail,null);
		tail = new Polynomial(0,0,null,head);
		this.size=0;
		this.degree=0;
	}
	
	public void addLast(Polynomial p) {
		Polynomial temp = p;
		while(temp.next !=null) {
			temp=temp.next;
		}
	}
	
	@Override
	public double getCoefficient(int argument) {
		Polynomial current = head;
		while(current.next != null) {
			current = current.next; 
			if(current.exponent == argument) {
				return current.coefficient; 
			}
		}
		return 0;
	}

	@Override
	public int value(double argument) {
		Polynomial current = head;
		while(current.next != null) {
			current = current.next;
			if(current.coefficient == argument) {
				return (int) current.coefficient + 1;
			}
		}
		return 0;
	}
	
	public LinkedPolynomial negate() {
		LinkedPolynomial finalResult = new LinkedPolynomial();
		for(int i = 0; i <= size; i++) {
			double newCo = this.getCoefficient(i) * -1;
			int newExp = this.value(i * -1);
			Polynomial current = new Polynomial(newCo, newExp, null, null);
			finalResult.addLast(current);
		}
		return finalResult;
	}
	
	@Override
	public LinkedPolynomial add(LinkedPolynomial argument) {
		LinkedPolynomial temp = new LinkedPolynomial(); 
		int degreeMax = argument.degree; 
		if(degree > argument.degree) {
			degreeMax = degree;
		}
		for(int i = 0; i <= degreeMax; i++) {
			Polynomial current = new Polynomial(i, (int) (this.getCoefficient(i) + argument.getCoefficient(i)), null, null);
			if(current.coefficient != 0) {
				temp.addLast(current);
			}
		}
		return temp;
	}

	@Override
	public LinkedPolynomial subtract(LinkedPolynomial argument) {
		return this.add(argument.negate());
	}
	

	@Override
	public boolean equals(LinkedPolynomial obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        LinkedPolynomial p = (LinkedPolynomial) obj;
        return this.getCoefficient(1) == p.getCoefficient(1);
    }
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + head.hashCode();
        hash = 31 * hash + tail.hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
	 StringBuilder sb = new StringBuilder("");
	 Polynomial current = head.next;
	 while(current != tail) {
		 sb.append("[" + current.coefficient + ", " + current.exponent + "]");
		 current = current.next;
	 }
	 return sb.toString();
	}
	
	public static void main(String[] args) {
		LinkedPolynomial a = new LinkedPolynomial("1.0, 2, 3.2, 4, 2.0, 3");
		LinkedPolynomial b = new LinkedPolynomial("1.0, 2, 3.2, 4, 2.0, 3");
		LinkedPolynomial c = new LinkedPolynomial("2.0, 3, 2.0, 1, 4.0, 5");
		
		
		System.out.println("LinkedPolynomial a : " + a);
		System.out.println("LinkedPolynomial b : " + b);
		System.out.println("LinkedPolynomial c : " + c);
		System.out.println();
		System.out.println("First Coefficient at a: " + a.getCoefficient(2));
		System.out.println("First Coefficient at b: " + a.getCoefficient(2));
		System.out.println("First Coefficient at c: " + a.getCoefficient(3));
		System.out.println();
		System.out.println("First exponent at a: " + b.value(1.0));
		System.out.println("First exponent at b: " + b.value(1.0));
		System.out.println("First exponent at c: " + b.value(2.0));
		System.out.println();
		System.out.println("a = b: " + a.equals(b));
		System.out.println("a = c: " + a.equals(c));
		System.out.println();	
		System.out.println("Hash code of a: " + a.hashCode());
		System.out.println("Hash code of b: " + b.hashCode());
		System.out.println("Hash code of c: " + c.hashCode());
		System.out.println(); 
		//System.out.println(a.add(b));
		
		a.negate();
		System.out.println("negative" + a);
		
		/*
		//testing getters for polynomials
		Polynomial p = new Polynomial(2.0, 2, null, null);
		Polynomial q = new Polynomial(5.0, 2, null, null);
		System.out.println(p.coefficient());
		System.out.println(p.exponenet());
		*/
	}



}
