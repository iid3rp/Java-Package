public class Panel
{
    frame = new JFrame(title)
        {
            protected void paintComponent(Graphics g) 
            {
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
        };

    public static void main(String[] args)
    {
    
    }
}