package com.tian.utils;

import com.tian.GameWin;
import com.tian.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tian
 *
 * 工具类
 */
public class GameUtils {
    //背景图片
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    //boss图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    //获取我方战斗及图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //获取我方子弹的图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    //获取敌方子弹的图片
    public static Image BulletImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
    //获取敌方战斗机的图片
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");


    //  所有游戏物体的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //要删除元素的集合
    public static List<GameObj> removeList = new ArrayList<>();
    //我方子弹的集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //敌方飞机的集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
    //敌方子弹的集合
    public static List<BulletObj> bulletObjList = new ArrayList<>();
    //爆炸集合
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    //绘制字符串的工具类
    public static void  drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }
}
