//ICS summative game-Lamar's space adventures
//Purab P.
//Tazik S.
//Praveen J.
//Rong Tao L.
//Fardin I.


import img.ImageLoader;         // imports ImageLoader class
import sndfkt.SoundEffects;     // imports SoundEffects class

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import java.util.Random;

import java.io.File;
import java.io.IOException;

import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.OverlayLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;



public class Game
{
    static Console c;
    static ImageLoader imageLoader = new ImageLoader ();        // constructs ImageLoader object
    static SoundEffects soundEffects = new SoundEffects ();     // constructs SoundEffects object

    public static final int SCALE = 3;                      // constant variable scale factor

    public static void music (String fileName)
    {
	AudioPlayer MGP = AudioPlayer.player;
	AudioStream BGM;
	AudioData MD;

	ContinuousAudioDataStream loop = null;

	try
	{
	    InputStream test = new FileInputStream (fileName);
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


    public static void sleep (int ms)                       // function that puts system to 'sleep' (aka pause)
    {
	try
	{
	    Thread.sleep (ms);
	}

	catch (InterruptedException ie)
	{
	    c.println ();
	}
    }


    public static void pauseText ()                                         // text displayed when game is PAUSED
    {
	Font pause = new Font ("Arial black", Font.BOLD, 20);
	c.setColor (Color.blue);
	c.setFont (pause);
	c.drawString ("GAME PAUSED - PRESS ANY KEY TO CONTINUE", 65, 35);
    }


    public Game ()  // change name to 'praveen'
    {
	final int width = c.getWidth ();        // constant width;
	final int height = 12 / 9 * width;      // constant height

	Image background = imageLoader.loadImage ("background.jpg");
	background = background.getScaledInstance (700, 700, Image.SCALE_DEFAULT);                      // scales image
	Image titleBanner = imageLoader.loadImage ("titleBanner.png");
	Image playButton = imageLoader.loadImage ("playButton.png");
	playButton = playButton.getScaledInstance (width / SCALE, height / 8, Image.SCALE_DEFAULT);     // scales image
	Image quitButton = imageLoader.loadImage ("quitButton.png");
	quitButton = quitButton.getScaledInstance (width / SCALE, height / 8, Image.SCALE_DEFAULT);     // scales image

	c.drawImage (background, 0, 0, null);                   // draws background
	c.drawImage (titleBanner, 200, 0, null);                // draws title banner
	c.drawImage (playButton, width / 3 - 120, 250, null);   // draws play button
	c.drawImage (quitButton, width / 3 + 150, 250, null);   // draws quit button

	music ("lamarBackgroundMusic.wav");


	c.getChar ();

	Image diffEasy = imageLoader.loadImage ("diffEasy.png");
	diffEasy = diffEasy.getScaledInstance (width / 4, height / 12, Image.SCALE_DEFAULT);            // scales image
	Image diffMeh = imageLoader.loadImage ("diffMeh.png");
	diffMeh = diffMeh.getScaledInstance (width / 4, height / 12, Image.SCALE_DEFAULT);              // scales image
	Image diffHard = imageLoader.loadImage ("diffHard.png");
	diffHard = diffHard.getScaledInstance (width / 4, height / 12, Image.SCALE_DEFAULT);            // scales image

	c.clear ();
	c.drawImage (background, 0, 0, null);                   // draws background
	c.drawImage (titleBanner, 200, 0, null);                // draws title banner
	c.drawImage (diffEasy, 60, 300, null);                  // draws easy button
	c.drawImage (diffMeh, 250, 360, null);                  // draws meh button
	c.drawImage (diffHard, 440, 300, null);                 // draws hard button

	char difficulty = 'a';
	boolean okay = false;

	while (okay != true)
	{
	    difficulty = c.getChar ();
	    if (difficulty == 'e' || difficulty == 'E' || difficulty == 'm' || difficulty == 'M' || difficulty == 'h' || difficulty == 'H')
	    {
		okay = true;
	    }
	}


	music ("lamarBackgroundMusic.wav");        // plays background music
	char infoMenu = c.getChar ();
	if (infoMenu == 'i')                                    // menu with info about game
	{
	    JFrame info = new JFrame ("Info");                  // new JFrame window
	    info.setBounds (0, 0, 250, 600);
	    JLabel infoText1 = new JLabel ("");
	    infoText1.setBounds (0, 0, 250, 100);
	    JLabel infoText2 = new JLabel ("");
	    infoText2.setBounds (0, 100, 250, 100);
	    JLabel infoText3 = new JLabel ("");
	    infoText3.setBounds (0, 200, 250, 100);
	    JLabel infoText4 = new JLabel ("");
	    infoText4.setBounds (0, 300, 250, 100);
	    JLabel infoText5 = new JLabel ("");
	    infoText5.setBounds (0, 400, 250, 100);

	    infoText1.setText ("LAMAR'S SPACE ADVENTURES");         // instructions
	    infoText2.setText ("Use W to move up");
	    infoText3.setText ("Use S to move down");
	    infoText4.setText ("Use Spacebar to fire");
	    infoText5.setText ("Use P to pause game");

	    info.add (infoText1);
	    info.add (infoText2);
	    info.add (infoText3);
	    info.add (infoText4);
	    info.add (infoText5);
	    info.setVisible (true);
	    c.getChar ();
	}

	if (infoMenu == 'q')                                       // q to QUIT
	{
	    System.exit (0);
	}

	music ("lamarBackgroundMusic.wav");            // plays background music

	BufferedImage lamarInSpace = new BufferedImage (c.getWidth (), c.getHeight (), BufferedImage.TYPE_INT_ARGB); // prevents flickering by 'buffering' image
	Graphics g = lamarInSpace.getGraphics ();                                                                    // gets graphics from buffered image

	Image nightSky = imageLoader.loadImage ("nightSky.jpg");
	Image rszNightSky = nightSky.getScaledInstance (200, 200, Image.SCALE_DEFAULT);     // scales image
	Image spaceLamar = imageLoader.loadImage ("spaceLamar.png");
	spaceLamar = spaceLamar.getScaledInstance (350, 350, Image.SCALE_DEFAULT);          // scales image
	Image goonOne = imageLoader.loadImage ("goonOne.png");
	goonOne = goonOne.getScaledInstance (200, 160, Image.SCALE_DEFAULT);                // scales image
	Image lamProjectile = imageLoader.loadImage ("lamProjectile.png");
	lamProjectile = lamProjectile.getScaledInstance (60, 10, Image.SCALE_DEFAULT);     // scales image
	Image goonProjectile = imageLoader.loadImage ("goonProjectile.png");
	goonProjectile = goonProjectile.getScaledInstance (50, 10, Image.SCALE_DEFAULT);


	int xLam = -45, yLam = 0;       // Lamar's position
	int xLamProj = 227, yLamProj = yLam + 200;       // Position of Lamar's projectile

	Random rand = new Random ();
	int xGoon = 605;                              // xPosition of Goon
	int yGoon = rand.nextInt (333);                     // yPosition of Goon, isVariable
	int xGoonProj;
	int yGoonProj;
	int probProjectile = (int) (Math.random () * 3) + 1;    // probability of Goon's projectile being generated

	int killCount = 0;                                  // # of goons spawned
	int xGoonOffset = 0;                                    // displacement from initial xPosition
	int healthBar = 0, boostBar = 0;
	int xGoonProjOffset = 0;                            // variable for displacement of Goon's projectile
	char input = 'a';


	if (difficulty == 'e' || difficulty == 'E')
	{
	    healthBar = 400;                                // EASY: 400 HP
	}
	else if (difficulty == 'm' || difficulty == 'M')
	{
	    healthBar = 200;                                // MEH: 200 HP
	}
	else if (difficulty == 'h' || difficulty == 'H')
	{
	    healthBar = 100;                                // HARD: 100 HP
	}

	do
	{
	    c.drawImage (lamarInSpace, 0, 0, null);             // draws buffered layout
	    g.drawImage (nightSky, 0, 0, null);                 // draws background
	    g.drawImage (spaceLamar, xLam, yLam, null);         // draws Lamar
	    if (xGoon - xGoonOffset < -180)                         // if Goon goes off screen, generates new Goon
	    {
		healthBar -= 20;
		yGoon = rand.nextInt (333);
		xGoonOffset = 0;
		g.drawImage (goonOne, xGoon - xGoonOffset, yGoon, null);
		probProjectile = (int) (Math.random () * 3) + 1;
		if (probProjectile == 2)
		{
		    xGoonProjOffset = 0;
		}

	    }

	    g.setColor (Color.green);
	    g.fillRect (0, 0, healthBar, 10);                   // draws health bar

	    g.setColor (Color.blue);
	    g.fillRect (0, 10, boostBar, 10);                   // draws boost bar


	    while (c.isCharAvail ())                                // if user presses any key
	    {
		input = c.getChar ();                               // checks for input

		if (input == 'w' || input == 'W')
		{
		    yLam -= 15;                                     // if w is pressed, Lamar goes UP
		    g.drawImage (nightSky, 640, 500, null);         // redraws background
		    g.drawImage (spaceLamar, xLam, yLam, null);     // redraws Lamar
		}
		if (input == 's' || input == 'S')
		{
		    yLam += 15;                                     // if s is pressed, Lamar goes DOWN
		    g.drawImage (nightSky, 640, 500, null);         // redraws background
		    g.drawImage (spaceLamar, xLam, yLam, null);     // redraws Lamar
		}
		if (input == 'p' || input == 'P')                                   // if p is pressed, game is PAUSED
		{
		    while (!c.isCharAvail ())                       // until a character is pressed,
		    {
			pauseText ();                               // game is paused
		    }
		}

		{

		    if (input == 32)    // if user presses spacebar, projectile is unleashed
		    {
			//music ("laser.wav"); //laser sound is emitted
			yLamProj = yLam + 200;                                               // position of projectile defined relative to y-coordinate of Lamar
			for (int i = xLamProj ; xLamProj < 640 ; xLamProj += 8)              // ensures projectile stays within bounds
			{
			    g.drawImage (lamProjectile, xLamProj, yLamProj, null);
			    if (xLamProj >= xGoon - xGoonOffset && xLamProj <= xGoon - xGoonOffset + 6 && yLamProj - yGoon > 1 && yLamProj - yGoon < 150) // isGoonHit?
			    {
				xGoon = 605;
				xGoonOffset = 0;
				yGoon = rand.nextInt (333);


				killCount++;
				if (difficulty == 'm')
				{
				    boostBar += 5;              // if difficulty is 'meh', boostBar is a thing
				}
				break;
			    }
			}
			xLamProj = 227;                                     // resets laser xPosition
		    }

		    xGoonOffset += 3;                                           // value by which Goon is offset horizontally ALWAYS HAPPENING
		    g.drawImage (goonOne, xGoon - xGoonOffset, yGoon, null);    // redraws Goon

		}
	    }

	    if (boostBar == 25) //&& boostBar != 0)
	    {
		healthBar += 50;
		boostBar = 0;
	    }

	    xGoonProj = 0;                  // placeholder values
	    yGoonProj = 0;                  // placeholder values

	    if (difficulty == 'e' || difficulty == 'E')          // EASY
	    {
		if (probProjectile == 1)    // 1/3 chance of projectile being generated
		{
		    xGoonProj = xGoon - xGoonOffset - 30 - xGoonProjOffset;
		    yGoonProj = yGoon + 75;
		    g.drawImage (goonProjectile, xGoonProj, yGoonProj, null);
		    sleep (3);
		    xGoonProjOffset++;

		}
	    }
	    if (difficulty == 'm' || difficulty == 'M')          // MEH
	    {
		if (probProjectile == 1 || probProjectile == 2)     // 2/3 chance of projectile being generated
		{
		    xGoonProj = xGoon - xGoonOffset - 30 - xGoonProjOffset;
		    yGoonProj = yGoon + 75;
		    g.drawImage (goonProjectile, xGoonProj, yGoonProj, null);
		    sleep (1);
		    xGoonProjOffset += 2;
		}
	    }

	    if (difficulty == 'h' || difficulty == 'H')          // HARD
	    {
		if (probProjectile == 1 || probProjectile == 2 || probProjectile == 3)  // 3/3 chance of projectile being generated
		{
		    xGoonProj = xGoon - xGoonOffset - 30 - xGoonProjOffset;
		    yGoonProj = yGoon + 75;
		    g.drawImage (goonProjectile, xGoonProj, yGoonProj, null);
		    xGoonProjOffset += 2;
		}
	    }

	    if (healthBar <= 0 || (difficulty == 'e' || difficulty == 'E' && probProjectile == 1) || (difficulty == 'm' || difficulty == 'M' && probProjectile == 1 || probProjectile == 2) || (difficulty == 'h' || difficulty == 'H' && probProjectile == 1 || probProjectile == 2 || probProjectile == 3))
	    {
		if (xGoonProj > 0)
		{
		    if (healthBar <= 0 || xLam + 190 >= xGoonProj && yGoonProj - yLam < 255 && yGoonProj - yLam > 95)  // if out of health, Lamar dies (or he touches bottom of screen)
		    {
			c.clear ();
			//g.setColor (Color.white);
			//g.fillRect (0, 0, 640, 500);
			Image deathScreen = imageLoader.loadImage ("lamarDed.png");
			deathScreen = deathScreen.getScaledInstance (640, 400, Image.SCALE_DEFAULT);
			g.drawImage (deathScreen, 0, 0, null);                                       // displays retry and quit options


			Font fKillCount = new Font ("Arial black", Font.BOLD, 30);
			g.setColor (Color.blue);
			g.setFont (fKillCount);
			g.drawString ("Total kills: " + Integer.toString (killCount), 100, 50);     // displays total kills
			sleep (250);

			char endDecision = c.getChar ();
			if (endDecision == 'q')                                 // q to QUIT
			{
			    System.exit (0);
			}
			else if (endDecision == 'r')                            // r to RETRY
			{
			    c.clear ();
			    //g.setColor (Color.white);
			    //g.fillRect (0, 0, 640, 500);
			    healthBar = 200;
			    yLam = 0;                                          // yPosition of Lamar is reset
			    g.drawImage (nightSky, 640, 500, null);            // background is redrawn
			    g.drawImage (spaceLamar, xLam, 0 + yLam, null);    // Lamar is redrawn
			}
			else
			{
			    // ISSUE: button mashing brings Lam back to life
			}
		    }
		}
	    }


	    if (difficulty == 'e' || difficulty == 'E')                  // if difficulty is EASY
	    {
		xGoonOffset += 4;
	    }
	    if (difficulty == 'm' || difficulty == 'M')                  // if difficulty is MEH
	    {
		xGoonOffset += 2 + killCount;
	    }
	    if (difficulty == 'h' || difficulty == 'H')                  // if difficulty is HARD
	    {
		yGoon = rand.nextInt (333);         // ZIGZAG GOON MODE
		sleep (2);
		xGoonOffset += 2 + killCount;
	    }
	    g.drawImage (goonOne, xGoon - xGoonOffset, yGoon, null);                         // draws goon
	    sleep (5);
	    g.drawImage (nightSky, 640, 500, null);                                      // draws background


	}
	while (input != 0);

    }


    public static void main (String[] args)
    {
	c = new Console ();
	new Game ();

    }
} // Game class


