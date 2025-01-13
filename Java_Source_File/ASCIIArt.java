import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.Graphics2D;


public class ASCIIArt {

    static File uploadImage() {
        
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Image File");

        // Show the open dialog and get the result
        int result = fileChooser.showOpenDialog(null);

        // If the user selects a file
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Image loaded successfully!");
            return selectedFile;

                
                
        } else {
            System.out.println("No file selected.");
            return null;
        }

        
    }





    // resize the image
    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        int imageType = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, imageType);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();
        return resizedImage;
    }





    // convert BufferedImage into array
    public static int[][][] convertTo2DArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][][] result = new int[height][width][3]; // [row][col][RGB]

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                result[y][x][0] = (rgb >> 16) & 0xFF; // Red
                result[y][x][1] = (rgb >> 8) & 0xFF;  // Green
                result[y][x][2] = rgb & 0xFF;         // Blue
            }
        }
        return result;
    }

    // converting rgb to black and white
    static double[][] brightness(int[][][] image){
        int height = image.length;
        int width = image[0].length;
        double[][] bright = new double[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                int r = image[i][j][0];
                int g = image[i][j][1];
                int b = image[i][j][2];
                bright[i][j] = (r+g+b)/3;


            }
        }
        return bright;

    }


    static void generateASCIIArt(int[][][] image){
        // Calculate Average Brightness
        double[][] bright = brightness(image);
        

        String pixel_ascii_map = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
        int mapLength =  pixel_ascii_map.length();

        // mapping the brightness with symbol
        for (int i = 0; i < bright.length; i++) {
            for (int j = 0; j < bright[0].length; j++) {
                // Normalize brightness to an index in the ASCII map
                int index = (int) Math.floor((bright[i][j] / 255) * (mapLength - 1));
                // Print the corresponding character without storing it
                System.out.print(pixel_ascii_map.charAt(index));
            }
            // Print a newline at the end of each row
            System.out.println();
        }
        


    }

    public static void main(String[] args) {


        // import image
        File selectedFile = uploadImage();
        BufferedImage image = null;
        try {
            image = ImageIO.read(selectedFile);
        } catch (IOException e) {
            System.err.println("Error reading the image: " + e.getMessage());
        }



        // Dimension change
        if (image != null) {
            int newWidth = image.getWidth();
            int newHeight = image.getHeight();
            double ratio = (double) newHeight / newWidth;

            BufferedImage resizedImage = resizeImage(image, 100, (int) (100 * ratio));

            // convert into int 2darray
            int[][][] pixelArray = convertTo2DArray(resizedImage);
            

            // converting into art
            generateASCIIArt(pixelArray);
            

            
        }

        else{
            System.out.println("image is null");
        }

        

    }
    
}
