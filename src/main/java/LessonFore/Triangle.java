package LessonFore;


import lombok.Data;



@Data

public class Triangle {


    private int a;
    private int b;
    private int c;


    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public int countArea() {   // (Площадь по формуле герона)
        int p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return (int) s;
    }

}

