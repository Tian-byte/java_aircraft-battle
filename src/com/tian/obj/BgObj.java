package com.tian.obj;

import java.awt.*;

/**
 * @author tian
 * 背景的移动
 */
public class BgObj extends GameObj {
    //重写需要的构造方法和paintSelf方法

    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if (y >= 0){
            y = -2000;
        }
    }
}
