package iid3rp.swing;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.imageio.*;
public class Frame extends JFrame
{  
    private ImageIcon backgroundImage;
    private String backgroundStyle = "Center";
        
    public Frame(String title)
    {
        super(title);
    }
    
    protected void paintComponent(Graphics g) 
    {
        paintComponent(g);
        if (backgroundImage != null) 
        {
            // Apply different drawing techniques based on the style:
            if (backgroundStyle.equalsIgnoreCase("Stretch"))  
            {
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            } 
            else if (backgroundStyle.equalsIgnoreCase("Tile")) 
            {
                int imageWidth = backgroundImage.getIconWidth();
                int imageHeight = backgroundImage.getIconHeight();
                for (int y = 0; y < getHeight(); y += imageHeight) 
                {
                    for (int x = 0; x < getWidth(); x += imageWidth) 
                    {
                        g.drawImage(backgroundImage.getImage(), x, y, this);
                    }
                }
            } 
            else if (backgroundStyle.equalsIgnoreCase("Center")) 
            {
                int x = (getWidth() - backgroundImage.getIconWidth()) / 2;
                int y = (getHeight() - backgroundImage.getIconHeight()) / 2;
                g.drawImage(backgroundImage.getImage(), x, y, this);
            } 
            else if (backgroundStyle.equalsIgnoreCase("Zoom")) 
            {
                int imageWidth = backgroundImage.getIconWidth();
                int imageHeight = backgroundImage.getIconHeight();
                double zoomFactor = Math.max(getWidth() / (double) imageWidth, getHeight() / (double) imageHeight);
                int zoomedWidth = (int) (imageWidth * zoomFactor);
                int zoomedHeight = (int) (imageHeight * zoomFactor);
                int x = (getWidth() - zoomedWidth) / 2;
                int y = (getHeight() - zoomedHeight) / 2;
                g.drawImage(backgroundImage.getImage(), x, y, zoomedWidth, zoomedHeight, this);
            } 
            else if (backgroundStyle.equalsIgnoreCase("ZoomX")) 
            {
                int imageWidth = backgroundImage.getIconWidth();
                int imageHeight = backgroundImage.getIconHeight();
                double zoomFactor = getWidth() / (double) imageWidth;
                int zoomedHeight = (int) (imageHeight * zoomFactor);
                int y = (getHeight() - zoomedHeight) / 2;
                g.drawImage(backgroundImage.getImage(), 0, y, getWidth(), zoomedHeight, this);
            } 
            else if (backgroundStyle.equalsIgnoreCase("ZoomY")) 
            {
                int imageWidth = backgroundImage.getIconWidth();
                int imageHeight = backgroundImage.getIconHeight();
                double zoomFactor = getHeight() / (double) imageHeight;
                int zoomedWidth = (int) (imageWidth * zoomFactor);
                int x = (getWidth() - zoomedWidth) / 2;
                g.drawImage(backgroundImage.getImage(), x, 0, zoomedWidth, getHeight(), this);
            } 
            else if (backgroundStyle.equalsIgnoreCase("Default")) 
            {
                g.drawImage(backgroundImage.getImage(), 0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), this);
            }
        }
    }

    
    public void setSize(int width, int height)
    {
        super.setSize(width, height);
    }
    
    public void setLocation(int x, int y)
    {
        super.setLocation(x, y);
    }
    
    public void setCenteredLocation()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public void setBackgroundImage(ImageIcon imageIcon) 
    {
        this.backgroundImage = imageIcon;
        repaint(); // Trigger a repaint to display the new image
    }
    
    public void setBackgroundStyle(String style) 
    {
        this.backgroundStyle = style;
        repaint();
    }
    
    public void setVisible(boolean bool)
    {
        super.setVisible(bool);
    }
    
    public static void main(String[] args)
    {
        Frame lets = new Frame("Hello Wrold!");
    }
}