public class RationalFraction {

    public int num;
    public int de;

    public RationalFraction(int _num, int _de) {
        this.num = _num;
        this.de = _de;
    }
    public RationalFraction() {
        this.num = 0;
        this.de = 0;
    }

    private int getNod(int a, int b){
        if (b == 0) {
            return a;
        }
        return getNod(b, a % b);
    }
    public void reduce(){
        var nod= getNod(this.num, this.de);
        this.num/=nod;
        this.de/=nod;
    }
    public RationalFraction reduce2(){
        var nod= getNod(this.num, this.de);
        return new RationalFraction(num/nod, de/nod);
    }
    //region +++add methods+++
    public RationalFraction add(RationalFraction _secfract){
        var result= new RationalFraction(
                num * _secfract.de + _secfract.num * de,
                de * _secfract.de);
        result.reduce();
        return result;
    }
    public void add2(RationalFraction _secfract){
        this.num = num * _secfract.de + _secfract.num * de;
        this.de = de * _secfract.de;

        this.reduce();
    }
    //endregion
    //region ---sub methods---
    public RationalFraction sub(RationalFraction _secfract){
        var result= new RationalFraction(
                num * _secfract.de - _secfract.num * de,
                de * _secfract.de);
        result.reduce();
        return result;
    }
    public void sub2(RationalFraction _secfract){
        this.num = num * _secfract.de - _secfract.num * de;
        this.de = de * _secfract.de;
        this.reduce();
    }
    //endregion

    // region ***mult methods***
    public RationalFraction mult(RationalFraction _secfract){
        var result= new RationalFraction(
                num * _secfract.num,
                de * _secfract.de);
        result.reduce();
        return result;
    }
    public void mult2(RationalFraction _secfract){
        this.num *= _secfract.num;
        this.de *= _secfract.de;

        this.reduce();
    }
    //endregion
    //region ///div methods///
    public RationalFraction div(RationalFraction _secfract){
        var result = new RationalFraction(num * _secfract.de,de*_secfract.num );
        result.reduce();
        return result;
    }
    public void div2(RationalFraction _secfract){
        num*= _secfract.de;
        de*=_secfract.num;
        this.reduce();

    }
    //endregion

    public String toString(){
        return num+"/"+de;
    }

    public double value(){
        return (double)num/de;
    }

    public boolean equals(RationalFraction _secfract){
        var _first=this.reduce2();
        var _second=_secfract.reduce2();

        return _first.num == _second.num && _first.de==_second.de;
    }

    public int numberPart(){
        int count=0;
        var _tempnum=num;
        while (_tempnum > de){
            _tempnum-=de;
            count++;
        }
        return count;
    }

    public void print(){
        System.out.println(num+"/"+de);
    }
}
