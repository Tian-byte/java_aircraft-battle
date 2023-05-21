package com.tian.obj;

import com.tian.GameWin;
import com.tian.utils.GameUtils;

import java.awt.*;

/**
 * @author tian
 * 敌方飞机的类
 */
public class EnemyObj extends GameObj {
    //重写需要的方法
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //敌我飞机碰撞检测
        if (this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
        //敌机的越界消失 判断条件 y > 600 改变后的坐标（-200，-200）
        if (y > 600) {
            this.x = -200;
            this.y = 200;
            GameUtils.removeList.add(this);
        }
        //敌方消失前移动到(-200,-200) 我方子弹（-100，100）
        for (ShellObj shellObj :
                GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())){
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
              shellObj.setX(-100);
              shellObj.setY(100);
              this.x = -200;
              this.y = 200;
              GameUtils.removeList.add(shellObj);
              GameUtils.removeList.add(this);
              GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
