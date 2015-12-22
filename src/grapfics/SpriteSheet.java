package grapfics;

import java.awt.image.BufferedImage;

/**
 * Created by X on 12/21/2015.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    private int spriteCount;
    private int scala;
    private int spriteInWidth;

    public SpriteSheet(BufferedImage sheet, int spriteCount, int scala){
        this.sheet       = sheet;
        this.spriteCount = spriteCount;
        this.scala       = scala;

        this.spriteInWidth = sheet.getWidth() / scala;
    }

    public BufferedImage getSprite(int index){

        index = index % spriteCount;

        int x = index % spriteInWidth * scala;
        int y = index / spriteInWidth * scala;

        return sheet.getSubimage(x, y, scala, scala);
    }
}
