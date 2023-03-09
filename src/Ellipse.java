import java.util.Locale;

public class Ellipse extends Shape {
    private Point c;
    private double r1, r2;

    public Ellipse(Point c, double r1, double r2, Style style) {
        super(style);
        this.c = c;
        this.r1 = r1;
        this.r2 = r2;
    }

    public String toSvg(){
        return String.format(Locale.ENGLISH, "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" />",c.x,c.y,r1,r2);
    }
}
