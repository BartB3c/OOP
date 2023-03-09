import java.util.Locale;

public class Style {
    final public String fillColor;
    final public String strokeColor;
    final public double strokeWidth;
    Style(String fillColor, String strokeColor, double strokeWidth){
        if(fillColor == null)
            this.fillColor = "transparent";
        else
            this.fillColor = fillColor;

        if(strokeColor == null)
            this.strokeColor = "black";
        else
            this.strokeColor = strokeColor;

        if(strokeWidth == 0)
            this.strokeWidth = 1;
        else
            this.strokeWidth = strokeWidth;


    }
    public String toSvg(){
        return String.format(Locale.ENGLISH, "<fill:%s;stroke:%s;stroke-width:%f\"/>",this.fillColor,this.strokeColor,this.strokeWidth);
    }

}
