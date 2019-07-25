// The "ImageLoader" class.
package img;
import java.awt.*;
import hsa.Console;
import javax.imageio.*;
import java.io.*;


public class ImageLoader
{

    /*   public void getConsole(Console c)
       {
	    this.Console =  Console;
       } */ // 'getter for console


    // c = new Console();


    /* private int width = c.getWidth(), height = c.getWidth();

     public int getWidth()
     {
	 //width = c.getWidth();
	 return this.width;
     }

     public int getHeight()
     {
	 //height = c.getWidth();
	 return this.height;
     } */

    public static Image loadImage (String name)  //Loads image from file
    {
	Image img = null;
	try
	{
	    img = ImageIO.read (new File (name));
	}
	catch (IOException e)
	{

	}
	return img;
    }



} // ImageLoader class
