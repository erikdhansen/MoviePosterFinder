/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.google.images;

/**
 *
 * @author ehansen
 */
public class GoogleSearchOptions {
    
    public static enum FILETYPE {
        JPG,
        PNG,
        GIF,
        BMP
    }
    
    public static enum RIGHTS {
        CC_PUBLICDOMAIN,
        CC_ATTRIBUTE,
        CC_SHAREALIKE,
        CC_NONCOMMERCIAL,
        CC_NONDERIVED
    }
    
    public static enum IMGC {
        IMGC_GRAY,
        IMGC_COLOR
    }
    
    public static enum IMGCOLOR {
        BLACK,
        BLUE,
        BROWN,
        GRAY,
        GREEN,
        ORANGE,
        PINK,
        PURPLE,
        RED,
        TEAL,
        WHITE,
        YELLOW
    }
    
    public static enum IMGSZ {
        ICON,
        SMALL,
        MEDIUM,
        LARGE,
        XLARGE,
        XXLARGE,
        HUGE
    }
    
    public static enum IMGTYPE {
        FACE,
        PHOTO,
        CLIPART,
        LINEART
    }
    
    public static enum SAFE {
        ACTIVE,
        MODERATE,
        OFF
    }
}
