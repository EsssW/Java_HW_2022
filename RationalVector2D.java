public class RationalVector2D {

    public RationalFraction a;
    public RationalFraction b;

    public RationalVector2D(){
        a= new RationalFraction(0,1);
        b= new RationalFraction(0,1);
    }
    public RationalVector2D(RationalFraction _a, RationalFraction _b){
        a= _a;
        b= _b;
    }

    public RationalVector2D add(RationalVector2D v){
        return new RationalVector2D(this.a.add(v.a), this.b.add(v.b));
    }

    public String toString(){
        return "("+a.toString()+";"+b.toString()+")";
    }

    public double length(){
        return Math.sqrt(Math.pow(a.value(),2) + Math.pow(b.value(),2));
    }

    public RationalFraction scalarProduct(RationalVector2D v){
        var _rNum= a.mult(v.a);
        var _rDe = b.mult(v.b);
        return _rNum.add(_rDe);
    }
    public boolean equals(RationalVector2D v){
        return a.equals(v.a) && b.equals(v.b);
    }
    public void print() {
        System.out.println(this.toString());
    }

}
