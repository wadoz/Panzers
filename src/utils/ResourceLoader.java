package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by X on 12/21/2015.
 */
public class ResourceLoader {

    public static final String PATH ="res/";

    public static BufferedImage loadImage(String fileNmae){

        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(PATH + fileNmae));

        }catch (IOException e){
            e.printStackTrace();
        }

        return image;

    }

}
