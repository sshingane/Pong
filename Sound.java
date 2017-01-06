import java.io.File;
import javax.sound.sampled.*;
public class Sound implements Runnable
{
    private boolean running = false;
    private Thread thread;
	String songName;
	
	/**
	 * Constructor to set the file of sound to be played and also 
	 * begins the new thread.
	 * @param fileName - the name of the file to be played.
	 */
	public Sound(String fileName){
    	songName=fileName;
    	this.start();
	}

	/**
	 * Starts the thread.
	 */
    public void start()
    {
        if(running)
            return;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    //
    private boolean playSong = false;
    private AudioInputStream inputStream;
    private String url;
    private Clip clip;

    /**
     * After starting a new thread, the run method is called playing the resulting
     * .wav file.
     */
    public void run()
    {
        while(running)
        {
    		try {

    			AudioInputStream stream;
    			AudioFormat format;
    			DataLine.Info info;
    			Clip clip;

    			stream = AudioSystem.getAudioInputStream(getClass().getResource(songName));
    			format = stream.getFormat();
    			info = new DataLine.Info(Clip.class, format);
    			clip = (Clip) AudioSystem.getLine(info);
    			clip.open(stream);
    			clip.start();
    			while (!clip.isRunning())
    			    Thread.sleep(10);
    			while (clip.isRunning())
    			    Thread.sleep(10);
    			clip.close();
    			running =false;
    		} catch (Exception e) {
    			// whatever
    		}
        }
    }

}