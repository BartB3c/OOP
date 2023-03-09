import java.util.Locale;

public class Polygon extends Shape {
    private Point[] vertices;

    Polygon(int numOfVer, Style style){
        super(style);
        Point vertices[] = new Point[numOfVer];
    }


    public void setVertices(int numOfVer, Point vertex){
        vertices[numOfVer] = vertex;
    }
    public void setVertices(Point[] vertices){
        this.vertices = vertices;
    }
    public String toSvg(){
        String s = "";
        for(Point p: vertices){
            s += p.x+","+p.y+" ";
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" style=\"%s\"/>",s,style.toSvg());
    }
    /*
    public static Polygon square(Segment seg1, Style s1){
        double x1, y1, x3, y3;
        double x2, y2, x4, y4;
        x1 = seg1.getP1().x;
        y1 = seg1.getP1().y;
        x3 = seg1.getP1().x;
        y3 = seg1.getP1().y;
        x2 = (x1+x3+y1-y3)/2;
        y2 = (x3-x1+y1+y3)/2;
        x4 = (x1+x3+y3-y1)/2;
        y4 = (x1-x3+y1+y3)/2;
        Point A = new Point(x1,y1);
        Point B = new Point(x2,y2);
        Point C = new Point(x3,y3);
        Point D = new Point(x4,y4);
        Polygon finalSquare = new Polygon(4);
        finalSquare.setVertices(new Point[]{A,B,C,D});
        return finalSquare;
    }
     */

    public static Polygon square(Segment segment, Style style){
        Point p = new Point((segment.getP1().x+segment.getP2().x)/2,(segment.getP1().y+segment.getP2().y)/2);
        Segment segments[] = Segment.perpendicular(segment,p, segment.len()/2);
        Point shape[] = new Point[4];
        shape[0] = segment.getP1();
        shape[1] = segments[0].getP2();
        shape[2] = segment.getP2();
        shape[3] = segments[1].getP2();
        Polygon square = new Polygon(4,style);
        square.setVertices(shape);
        return square;
    }
}
