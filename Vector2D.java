public class Vector2D {

    public double x;
    public double y;

    public Vector2D() { }

    public Vector2D(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }

    public Vector2D add(Vector2D _secondVector){
        return (new Vector2D(
                this.x + _secondVector.x,
                this.y + _secondVector.y
        ));
    }

    public void add2(Vector2D _secondVector){
        this.x += _secondVector.x;
        this.y += _secondVector.y;
    }

    public Vector2D sub(Vector2D _secondVector){
        return (new Vector2D(
                this.x - _secondVector.x,
                this.y - _secondVector.y
        ));
    }

    public void sub2(Vector2D _secondVector){
        this.x -= _secondVector.x;
        this.y -= _secondVector.y;
    }

    public Vector2D mult(double _d) {
        return (new Vector2D(this.x * _d, this.y * _d));
    }

    public void mult2(double _d){
        this.x *= _d;
        this.y *= _d;
    }
    public String toString(){
        return this.x +" "+this.y;
    }
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarProduct(Vector2D _secondVector){
        return x * _secondVector.x + y * _secondVector.y;
    }

    public double cos(Vector2D _secondVector){
        double mod1= Math.abs(Math.sqrt(x*x + y*y));
        double mod2= Math.abs(Math.sqrt(Math.pow(_secondVector.x, 2) + Math.pow(_secondVector.y, 2)));
        double cos= (this.x * _secondVector.x + this.y * _secondVector.y) / (mod1 * mod2);
        return cos;
    }

    public boolean equals(Vector2D _secondVector){
        if(this.x == _secondVector.x && this.y == _secondVector.y)
            return true;
        else
            return false;
    }

    public void print() {
        System.out.printf(this.x+ "  "+ this.y +"%n");
    }
}
