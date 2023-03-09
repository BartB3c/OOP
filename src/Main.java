public class Main {
    public static void main(String[] args) {
        Style style = new Style("red", "black", 2.0);
        Polygon rectangle = new Polygon(4, style);
        Polygon triangle = new Polygon(3, style);
        Ellipse ellipse = new Ellipse(new Point(5.0, 5.0), 5.0, 10.0, style);
        rectangle.setVertices(new Point[]{new Point(0.0, 0.0), new Point(0.0, 100.0), new Point(100.0, 100.0), new Point(100.0, 0.0)});
        triangle.setVertices(new Point[]{new Point(200.0, 200.0), new Point(200.0, 300.0), new Point(100.0, 100.0)});
        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(ellipse);
        scene.save("plik.html");
    }
}