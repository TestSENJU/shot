package UIComponent;

import java.awt.Color;
/**
 * 
 * @author WYT
 * ��ɫ R108 G198 B68
��ɫ R215 G67 B27
��ɫ R77 G137 B193
��ɫ R255 G255 B255������ɫ
����R127 G102 B149�����ز���������ɫ
�ֺ� R80 G51 B51���ز���������ɫ
�Ұ� R299 G299 B299�������ɫ
 *center.setBackground(MyColor.RED.getColor());
 */
public enum MyColor{
	   GREY(229, 229, 229),
	    RED(215, 67, 27),
	    GREEN(108, 198, 68),
	    WHITE(255,255,255),
	    PURPLE(127,102,149),
	    BLACK(80,51,51),
	    DARKWHITE(220,220,220),
	    BLUE(77,137,193),
	    LIGHTBLUE(232,242,254);
	    

	    private final int r;
	    private final int g;
	    private final int b;
	    private final String rgb;

	    private MyColor(final int r,final int g,final int b) {
	        this.r = r;
	        this.g = g;
	        this.b = b;
	        this.rgb = r + ", " + g + ", " + b;
	    }

	    public String getRGB() {
	        return rgb;
	    }
	    public int getRed(){
	        return r;
	    }

	    public int getGreen(){
	        return g;
	    }

	    public int getBlue(){
	        return r;
	    }
	    public Color getColor(){
	        return new Color(r,g,b);
	    }

	    public int getARGB(){
	        return 0xFF000000 | ((r << 16) & 0x00FF0000) | ((g << 8) & 0x0000FF00) | b;
	    }

}
