package mfteam.com.et2.interfaces;

/**
 * @author GorkemKarayel on 22.06.2017.
 */

public interface DrawableClickListener {

    void onClick(DrawablePosition target);

    enum DrawablePosition{TOP,BOTTOM,LEFT,RIGHT}
}
