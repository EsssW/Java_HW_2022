public class ComplexNumber {

    public double real ;
    public double imaginary;

    public ComplexNumber(){}

    public ComplexNumber(double _real, double _imaginary){
        this.real = _real;
        this.imaginary = _imaginary;
    }

    public ComplexNumber add(ComplexNumber _cmplx){
        return new ComplexNumber(real + _cmplx.real, imaginary + _cmplx.imaginary);
    }

    public void add2(ComplexNumber _cmplx){
        this.real += _cmplx.real;
        this.imaginary +=_cmplx.imaginary;
    }

    public ComplexNumber sub(ComplexNumber _cmplx){
        return new ComplexNumber(real - _cmplx.real, imaginary - _cmplx.imaginary);
    }

    public void sub2(ComplexNumber _cmplx){
        this.real -= _cmplx.real;
        this.imaginary -=_cmplx.imaginary;
    }

    public ComplexNumber multNumber(double cf){
        return new ComplexNumber(real * cf, imaginary * cf);
    }

    public void multNumber2(double cf){
        this.real *= cf;
        this.imaginary *= cf;
    }

    public ComplexNumber mult(ComplexNumber _cmplx){
        var re = (real * _cmplx.real) - (imaginary * _cmplx.imaginary);
        var im = (imaginary * _cmplx.real) + (real * _cmplx.imaginary);
        return new ComplexNumber(re, im);
    }

    public void mult2(ComplexNumber _cmplx){
        var re = (real * _cmplx.real) - (imaginary * _cmplx.imaginary);
        var im = (imaginary * _cmplx.real) + (real * _cmplx.imaginary);
        this.real = re;
        this.imaginary = im;
    }

    public ComplexNumber div(ComplexNumber _cmplx){
        var znamenatel= Math.pow(_cmplx.real,2) + Math.pow(_cmplx.imaginary, 2);
        var re = ((real * _cmplx.real) + (imaginary * _cmplx.imaginary))/ znamenatel;
        var im =((imaginary * _cmplx.real) - (real*_cmplx.imaginary))/znamenatel;
        return new ComplexNumber(re, im);
    }

    public void div2(ComplexNumber _cmplx){
        var znamenatel= Math.pow(_cmplx.real,2) + Math.pow(_cmplx.imaginary, 2);
        this.real =((real * _cmplx.real) + (imaginary * _cmplx.imaginary))/ znamenatel ;
        this.imaginary =((imaginary * _cmplx.real) - (real*_cmplx.imaginary))/znamenatel;
    }

    //модуль комплексного числа
    public double length(){
        return Math.sqrt(Math.pow(real,2) + Math.pow(imaginary,2));
    }

    public String toString(){
        if (imaginary<0) {
            return "("+real + " - " + Math.abs(imaginary) + "i)";
        }
        return "("+real+" + "+imaginary+"i)";
    }

    // Вспомогательный метод для вычисления модуля комплексного числа
    public double abs() {
        return Math.sqrt(Math.pow(real,2) + Math.pow(imaginary,2));
    }

    // аргумент комплексного числа
    public double arg(){
        // далее использованы исловия для нахождения аргумента комлпексного числа
        // аргумент находится при помощи различных формул для соответсвтующих четвертей плоскости
        if (real > 0 && imaginary == 0){
            return 0;
        }
        else {
            if(real > 0 && imaginary > 0)
                return Math.atan(Math.abs(imaginary/real));
            else {
                if (real==0 && imaginary>0)
                    return Math.PI/2;
                else
                    if (real<0 && imaginary>0)
                        return Math.PI - Math.atan(Math.abs(imaginary/real));
                    else
                        if (real< 0 && imaginary>0)
                            return Math.PI;
                        else
                            if(real < 0 && imaginary< 0)
                                return -Math.PI + Math.atan(Math.abs(imaginary/real));
                            else
                                if (real == 0 && imaginary <0)
                                    return -Math.PI/2;
                                else
                                    return -Math.atan(Math.abs(imaginary/real));
            }
        }
    }

    // возведение в степень по формуле Муавра
    public  ComplexNumber pow(double degrees){
        var result=new ComplexNumber();

        double absInDegree= Math.pow(this.abs(), degrees);
        double argInDegree= this.arg()*degrees;

        result.real = absInDegree * Math.cos(argInDegree);
        result.imaginary = absInDegree * Math.sin(argInDegree);
        return result;
    }

    public boolean equals(ComplexNumber _cmplx){
        if (real == _cmplx.real && imaginary == _cmplx.imaginary)
            return true;
        return false;
    }
    public void  print(){
        System.out.println("( "+ real+" + "+ imaginary+"i)");
    }

}
