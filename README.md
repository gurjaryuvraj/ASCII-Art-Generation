# ASCII Art Generator

This project is a Java application that converts an image into ASCII art. The program reads an image file, resizes it to fit a smaller canvas, and then generates a text-based ASCII representation of the image using different characters to represent various levels of brightness.

## Features
- Image upload through a file chooser.
- Resizing of the image to fit within a specified width while maintaining aspect ratio.
- Conversion of the image into a 2D pixel array for processing.
- ASCII art generation using a custom set of characters.
  
## Getting Started

### Prerequisites
To run this project, you'll need:
- [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (JDK 11 or later) installed on your system.
- A suitable IDE (e.g., IntelliJ IDEA, Eclipse) or a simple text editor and command line to compile and run Java code.

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/gurjaryuvraj/ASCII-Art-Generation.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Java_Source_File
   ```
3. Compile the `ASCIIArt.java` file:
   ```bash
   javac ASCIIArt.java
   ```
4. Run the program:
   ```bash
   java ASCIIArt
   ```
5. Use the file chooser dialog to select an image file from your computer.

The program will display the ASCII art representation of the selected image in the console.

### Customization
- You can modify the characters in the `pixel_ascii_map` string to change the style of the generated ASCII art.
- Adjust the target image width in the `resizeImage` method to control the resolution of the ASCII art.

## Example Output

Here is an example of what the output might look like for a simple image:



## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Thanks to [ImageIO](https://docs.oracle.com/javase/7/docs/api/javax/imageio/package-summary.html) for image handling in Java.
- The ASCII character set used is custom, but can be modified to suit your needs.
```

