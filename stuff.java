import iid3rp.swing.*;
import java.awt.event.*;
public class stuff
{
	public static void main(String[] args)
	{
        Frame frame = createFrameInstance();
	}
    
    public static Frame createFrameInstance()
    {
        Frame frame = new Frame("Hello World!");
        frame.setSize(200, 400);
        frame.setCloseOperation("exit");
        frame.setCenteredLocation();
        frame.setBorder("Default");
        frame.setVisible(true);
        
        frame.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.print("Clicked!");
            }
        });
        System.out.print("This is commited through netbeans!"); // for reference..
        return frame;
    }
}