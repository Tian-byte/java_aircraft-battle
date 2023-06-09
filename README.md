# java_aircraft-battle
一、	设计的目的<br>
（1）	掌握结构化程序设计的主体思想，以自顶向下逐步求精的方法编制程序解决一些实际的中型问题，为将来开发软件积累一些典型的案例处理经验。<br>
（2）	培养学生在项目开发中团队合作精神、创新意识及能力。<br>
（3）	复习、巩固Java语言的基础知识，进一步加深对Java语言的理解和掌握。<br>
（4）	提高学生适应实际，实践编程的能力。<br>
（5）	为后继课程的实验以及课程设计打下较扎实的基础。<br>
二、	设计内容<br>
设计题目：飞机大战小游戏开发(Swing/DOS)
设计目的：使用面向对象和Swing窗体技术实现小游戏开发。<br>
设计要求：设计图形界面，实现战机和敌机子弹的界面绘制及动态飞行。<br>
（1）	飞机大战游戏功能分析：主要包括游戏的主要功能，如玩家如何开始游戏、控制己方飞机移动、躲避敌方攻击、使用自动发射的子弹攻击敌方、查看实时得分情况、摧毁敌机获得更高分数、暂停游戏等。<br>
（2）	飞机大战游戏界面设计：包括游戏主窗口的设计，如游戏名称、游戏背景、暂停键等；左上角的得分情况和右下角的生命值。<br>
（3）	飞机大战游戏模块设计：主要包括飞机大战游戏中的各个模块，如程序主函数、子弹模块、敌机模块、本机模块、奖励模块等。具体功能包括程序主函数实现飞机大战游戏的基本功能，子弹模块实现子弹的发射和接收、敌机模块实现敌方飞机的移动和攻击、本机模块实现自身飞机的相关功能、奖励模块实现游戏的奖励机制。<br>
（4）	飞机大战游戏算法设计：主要包括游戏的核心算法，如敌方飞机的随机移动和攻击、子弹的随机弹道和碰撞检测、得分的计算和排行榜的实现等。这些算法的设计要求能够提高游戏的趣味性和挑战性，增强玩家的游戏体验。<br>
（5）	飞机大战游戏测试与优化：主要包括游戏的测试和优化，如根据玩家反馈进行游戏界面和功能的调整、优化游戏算法提高游戏性能、添加奖励模块提高玩家获得奖励的兴趣等。<br>
总之，飞机大战课程设计内容需要综合考虑游戏设计、算法设计、界面设计、测试优化等多个方面，以实现游戏的趣味性、挑战性和可玩性，提高我们的编程能力和创新意识。<br>

三、	项目简介<br>
玩家通过鼠标控制飞机发射子弹击中敌机获取积分，与敌机或者子弹相撞则飞机爆炸游戏结束，击败最终boss则游戏通关，游戏结束，玩法简单有趣，锻炼反应能力。<br>
四、	功能架构图<br>
  ![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-52-35.png)<br><br><br>
五、	面向对象设计包图、类图<br>
  ![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-52-55.png)<br><br>
    ![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-52-47.png)<br>
六、	项目运行截图<br>
1.初始界面<br>
![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-28-21.png)<br>
2.游戏运行界面<br>
 ![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-28-45.png)<br>
3.我方飞机爆炸，游戏结束<br>
 ![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-28-54.png)<br>
4.游戏通关<br>
 ![image](https://github.com/1474416640/java_aircraft-battle/blob/main/images/Snipaste_2023-05-21_16-29-10.png)<br>
七、	项目关键代码<br>
完整代码已上传至github-https://github.com/1474416640/java_aircraft-battle<br>

1.	鼠标事件<br>
 1. //游戏的点击启动事件
 2. this.addMouseListener(new MouseAdapter() {
 3.             @Override
 4.             public void mouseClicked(MouseEvent e) {
 5.                 if (e.getButton() == 1 && state == 0){
 6.                     state = 1;
 7.                     repaint();
 8.                 }
 9.             }
10.         });
11.  
 1.   //鼠标移动函数
 2.         this.frame.addMouseMotionListener(new MouseAdapter() {
 3.             @Override
 4.             public void mouseMoved(MouseEvent e) {
 5.                 PlaneObj.super.x = e.getX() - 11;
 6.                 PlaneObj.super.y = e.getY() - 16;
 7.             }
 8.         });

2.游戏暂停<br>
 1. //键盘监听的暂停功能，空格暂停
 2.         this.addKeyListener(new KeyAdapter() {
 3.             @Override
 4.             public void keyPressed(KeyEvent e) {
 5.                 if (e.getKeyCode() == 32){
 6.                     switch (state){
 7.                         case 1:
 8.                             state = 2;
 9.                             break;
10.                         case 2:
11.                             state = 1;
12.                             break;
13.                         default:
14.                     }
15.                 }
16.             }
17.         });
18.  

3.	碰撞检测<br>
1. public void paintSelf(Graphics gImage) {
2.         super.paintSelf(gImage);
3.         //我方飞机与敌方飞机的碰撞检测
4.         if (this.frame.bossObj != null && this.getRec().intersects(this.frame.bossObj.getRec())){
5.             GameWin.state = 3;
6.         }
7.     }
八、总结<br>
Java飞机大战项目是一个基于Java编程语言的游戏项目，旨在让用户通过控制自己的飞机来击败其他玩家的飞机，从而获得游戏胜利。下面是对该项目的总结：<br>
1.	项目背景和目标：Java飞机大战项目是为了让用户能够在Java编程语言环境下玩一款类似于“打飞机”的游戏。该项目的目标是为用户提供一个有趣、简单易上手的游戏，让他们可以通过控制自己的飞机，获得游戏的胜利。<br>
2.	技术难点和解决方案：Java飞机大战项目的技术难点主要包括以下几个方面：<br>
	游戏逻辑的实现：该游戏的核心逻辑是控制自己的飞机去攻击其他玩家的飞机，实现起来比较复杂。为了解决这个问题，我们采用了基于事件驱动的设计模式，通过定时器、线程等技术手段，实现了游戏的逻辑控制。<br>
	游戏界面的设计：为了让用户能够更好地体验游戏，我们设计了一个简单易用的游戏界面，包括飞机的移动、攻击和击落等操作。<br>
	数据存储和处理：为了保证游戏的稳定性和可扩展性，我们采用了数据库技术对游戏数据进行存储和处理，保证了游戏数据的安全性和可靠性。<br>
3.	项目的成果和价值：Java飞机大战项目的成果和价值主要表现在以下几个方面：<br><br>
	提高了Java编程语言的应用能力：通过参与该项目，用户可以更深入地了解Java编程语言的应用，提高了Java编程语言的应用能力。<br>
	锻炼了用户的编程能力：通过实现游戏逻辑和设计游戏界面，用户可以锻炼自己的编程能力，提高了用户的编程素养。<br>
	促进了游戏开发的发展：通过开发Java飞机大战项目，我们可以了解游戏开发的最新技术和趋势，促进了游戏开发的发展。<br>
4.	项目的不足和改进方向：Java飞机大战项目的不足和改进方向主要包括以下几个方面：<br>
	游戏逻辑的复杂度：随着游戏的发展，游戏逻辑可能会变得更加复杂，需要不断优化和改进游戏逻辑，提高游戏的可玩性和趣味性。<br>
	游戏界面的美观度：游戏界面的美观度对用户的体验有很大的影响，需要不断优化和改进游戏界面，提高用户的视觉体验。<br>
	游戏数据的安全性：游戏数据的安全性对游戏的稳定性和可扩展性有很大的影响，需要不断加强数据的安全性和保护用户的隐私。<br>
  Java飞机大战项目是一个非常有趣和有挑战性的项目，通过参与该项目，用户可以提高Java编程语言的应用能力，锻炼自己的编程能力，同时也可以促进游戏开发的发展。<br>

