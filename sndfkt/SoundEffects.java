// The "SoundEffects" class.
package sndfkt;

import java.awt.*;
import java.lang.*;
import java.io.*;
import sun.audio.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;


public class SoundEffects
{

    public static AudioStream as = null;  // Creates an AudioStream object (null is default declaration)

    public static void music (String fileName)
    {
	AudioPlayer MGP = AudioPlayer.player;
	AudioStream BGM;
	AudioData MD;

	ContinuousAudioDataStream loop = null;

	try
	{
	    InputStream test = new FileInputStream ("lamarBackgroundMusic.wav");
	    BGM = new AudioStream (test);
	    AudioPlayer.player.start (BGM);

	}
	catch (FileNotFoundException e)
	{
	    System.out.print (e.toString ());
	}
	catch (IOException error)
	{
	    System.out.print (error.toString ());
	}
	MGP.start (loop);
    }
} // SoundEffects class
