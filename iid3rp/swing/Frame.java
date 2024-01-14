package iid3rp.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
public class Frame extends JFrame
{         
    public Frame(String title)
    {
        super(title);
    }
    
    public void setCloseOperation(String operation) 
    {
        switch (operation.toLowerCase()) 
        {
            case "exit":
                super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
            case "hide":
                super.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                break;
            case "dispose":
                super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                break;
            case "nothing":
                super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                break;
            default:
                throw new IllegalArgumentException("Invalid close operation: " + operation);
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
        super.setLocation(x, y);
    }
    
    public void setResizable(boolean bool)
    {
        super.setResizable(bool);
    }
    
    public void setBorder(String style) // borderless
    {
        try 
        {
            if (style.equalsIgnoreCase("none")) 
            {
                setUndecorated(true); // Use setUndecorated for borderless
            }
            else if (style.equalsIgnoreCase("default"))
            {
                setUndecorated(false);
            }
        } 
        catch (IllegalArgumentException e) 
        {
            System.err.println("Invalid border style: " + style);
        }
    } 
    
    public void setVisible(boolean bool)
    {
        super.setVisible(bool);
    }
    
    public void addMouseEvent(MouseListener listener)
    {
        super.addMouseListener(listener);
    }
    
    public void addMouseMotionEvent(MouseMotionListener listener)
    {
        super.addMouseMotionListener(listener);
    }
    
    public void addComponentListener(ComponentListener listener)
    {
        super.addComponentListener(listener);
    }
    
    public void addWindowListener(WindowListener listener)
    {
        super.addWindowListener(listener);
    }
    
    public static void main(String[] args)
    {
        Frame lets = new Frame("Hello Wrold!");
    }
}