import java.util.Locale;

public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double len(){
        return Math.sqrt(Math.pow(p2.x - p1.x,2) + Math.pow(p2.y - p1.y,2));
    }

    public String toSvg(){
        return String.format(Locale.ENGLISH,"<line x1=\"&f\" y1=\"%f\" x2=\"%f\" y2=\"%f\"style=\"stroke:black\">", p1.x, p1.y, p2.x, p2.y);
    }

    static public Segment[] perpendicular(Segment segment, Point point){
        double a, b, x0, y0, x1, y1, x2, y2, sq, r;
        a = (segment.getP1().y-segment.getP2().y)/(segment.getP1().x-segment.getP2().x);
        b = point.y - a * point.x;
        x0 = point.x;
        y0 = point.y;
        r = segment.len();
        sq  = Math.sqrt(-(y0*y0)+(2*a*x0+2*b)*y0-(a*a)*(x0*x0)-2*a*b*x0+(a*a+1)*r*r-b*b);
        x1 = (-(sq)-a*y0-x0+a*b)/(a*a+1);
        y1 = -(a*sq+a*a*y0+a*x0+b)/(a*a+1);
        x2 = (sq+a*y0+x0-a*b)/(a*a+1);
        y2 = (a*sq+a*a*y0+a*x0+b)/(a*a+1);
        return new Segment[]{new Segment(point,new Point(x1,y1)), new Segment(point,new Point(x2,y2))};


    }
    static public Segment[] perpendicular(Segment segment, Point point, double r){
        double a, b, x0, y0, x1, y1, x2, y2, sq;
        a = (segment.getP1().y-segment.getP2().y)/(segment.getP1().x-segment.getP2().x);
        b = point.y - a * point.x;
        x0 = point.x;
        y0 = point.y;
        r = segment.len();
        sq  = Math.sqrt(-(y0*y0)+(2*a*x0+2*b)*y0-(a*a)*(x0*x0)-2*a*b*x0+(a*a+1)*r*r-b*b);
        x1 = (-(sq)-a*y0-x0+a*b)/(a*a+1);
        y1 = -(a*sq+a*a*y0+a*x0+b)/(a*a+1);
        x2 = (sq+a*y0+x0-a*b)/(a*a+1);
        y2 = (a*sq+a*a*y0+a*x0+b)/(a*a+1);
        return new Segment[]{new Segment(point,new Point(x1,y1)), new Segment(point,new Point(x2,y2))};


    }
}
