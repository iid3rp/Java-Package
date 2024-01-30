package iid3rp.AbsoluteLayout;

import java.awt.*;
import javax.swing.*;

public class AbsoluteLayout
{   
	public AbsoluteLayout(JFrame frame) 
    {
        try
        {
            Component[] components = frame.getContentPane().getComponents();
            for (Component component : components) 
            {
                component.setLayout(null);

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public AnchoredLayout(JFrame frame)
    {
        try
        {
            Component[] components = frame.getComponents();
            for(Component component  : components)
            {
                component.setLayout(null);

                // ... inside the try block ...

                int rows = 3; // Update "rows" and "cols" values based on your actual grid size
                int cols = 3;

                int cellWidth = frame.getWidth() / cols; // Calculate cell dimensions
                int cellHeight = frame.getHeight() / rows;

                for (Component component : components) 
                {
                    component.setLayout(null);

                    // ... inside the try block ...

                    int rows = 3; // Update "rows" and "cols" values based on your actual grid size
                    int cols = 3;

                    int cellWidth = frame.getWidth() / cols; // Calculate cell dimensions
                    int cellHeight = frame.getHeight() / rows;

                    for (Component component : components) {
                        component.setLayout(null);

                        // Get component's relative grid position by dividing coordinates by cell size
                        int gridX = component.getX() / cellWidth;
                        int gridY = component.getY() / cellHeight;

                        // Handle edge cases (components exceeding cell boundaries)
                        if (gridX >= cols) {
                            gridX = cols - 1; // Clamp to maximum valid column
                        }
                        if (gridY >= rows) {
                            gridY = rows - 1; // Clamp to maximum valid row
                        }

                        // Anchor based on grid position

                        if (gridX == 0) { // Left column
                            if (gridY == 0) { // Top-left
                                // Apply top-left anchoring logic
                            } else if (gridY == rows - 1) { // Bottom-left
                                // Apply bottom-left anchoring logic
                            } else { // Left-center
                                // Apply left-center anchoring logic
                            }
                        } else if (gridX == cols - 1) { // Right column
                            if (gridY == 0) { // Top-right
                                // Apply top-right anchoring logic
                            } else if (gridY == rows - 1) { // Bottom-right
                                // Apply bottom-right anchoring logic
                            } else { // Right-center
                                // Apply right-center anchoring logic
                            }
                        } else { // Center column
                            if (gridY == 0) { // Top-center
                                // Apply top-center anchoring logic
                            } else if (gridY == rows - 1) { // Bottom-center
                                // Apply bottom-center anchoring logic
                            } else { // Center-center
                                // Apply center-center anchoring logic
                            }
                        }

                        // Set component position and size based on anchoring calculations
                        // ... (your positioning logic here) ...
                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

class Anchor
{
    public static final int LEFT = 1;
    public static final int MIDDLE = 2;
    public static final int RIGHT = 3;
    public static final int TOP = 1;
    public static final int CENTER = 2;
    public static final int BOTTOM = 3;
}