package com.just.demo19.game;


import com.just.demo19.domain.Poker;
import org.omg.PortableServer.POA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GameJFrame extends JFrame implements ActionListener {

    //获取界面中的隐藏容器
    //现在统一获取了，后面直接用就可以了
    public Container container = null;

    //管理抢地主和不抢两个按钮
    JButton landlord[] = new JButton[2];

    //管理出牌和不要两个按钮
    JButton publishCard[] = new JButton[2];

    int dizhuFlag;
    int turn;

    //游戏界面中地主的图标
    JLabel dizhu;


    //集合嵌套集合
    //大集合中有三个小集合
    //小集合中装着每一个玩家当前要出的牌
    //0索引：左边的电脑玩家
    //1索引：中间的自己
    //2索引：右边的电脑玩家
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    //集合嵌套集合
    //大集合中有三个小集合
    //小集合中装着每一个玩家的牌
    //0索引：左边的电脑玩家
    //1索引：中间的自己
    //2索引：右边的电脑玩家
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    //底牌
    ArrayList<Poker> lordList = new ArrayList<>();

    //牌盒，装所有的牌
    ArrayList<Poker> pokerList = new ArrayList();

    //三个玩家前方的文本提示
    //0索引：左边的电脑玩家
    //1索引：中间的自己
    //2索引：右边的电脑玩家
    JTextField time[] = new JTextField[3];

    boolean nextPlayer = false;

    public GameJFrame() {
        //设置图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo19\\image\\dizhu.png"));
        //设置界面
        initJframe();
        //添加组件
        initView();
        //界面显示出来
        //先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);

        initCard();

    }

    private void initCard() {

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if (i == 5 && j > 2) {
                    break;
                }
                Poker poker = new Poker(i + "-" + j, false);
                poker.setLocation(350,150);
                pokerList.add(poker);
                container.add(poker);
            }
        }

        Collections.shuffle(pokerList);

        ArrayList<Poker> player01 = new ArrayList<>();
        ArrayList<Poker> player02 = new ArrayList<>();
        ArrayList<Poker> player03 = new ArrayList<>();

        for (int i = 0; i < pokerList.size(); i++) {
            Poker poker = pokerList.get(i);
            if (i < 3) {
                lordList.add(poker);
                poker.turnFront();
                Common.move(poker, poker.getLocation(), new Point(270 + (75 * i), 10));
                continue;
            }
            if (i % 3 == 0) {
                player01.add(poker);
                Common.move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
            } else if (i % 3 == 1) {
                player02.add(poker);
                poker.turnFront();
                Common.move(poker, poker.getLocation(), new Point(180 + i * 7, 450));
            } else if (i % 3 == 2) {
                player03.add(poker);
                Common.move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
            }
            container.setComponentZOrder(poker, 0);
        }

        Collections.addAll(playerList, player01, player02, player03);

        for (int i = 0; i < 3; i++) {
            orderList(playerList.get(i));
            Common.rePosition(this, playerList.get(i), i);
        }

    }

    private void orderList(ArrayList<Poker> pokers) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 14);
        hashMap.put("2", 15);
        hashMap.put("10", 10);
        hashMap.put("11", 11);
        hashMap.put("12", 12);
        hashMap.put("13", 13);
        Collections.sort(pokers, (o1, o2) -> {
            String s1 = o1.getName();
            String s2 = o2.getName();
            String prefix1 = s1.substring(0,1);
            String prefix2 = s2.substring(0,1);
            String back1 = s1.substring(2);
            String back2 = s2.substring(2);
            int value1 = hashMap.containsKey(back1) ? hashMap.get(back1) : back1.toCharArray()[0] - '0';
            int value2 = hashMap.containsKey(back2) ? hashMap.get(back2) : back2.toCharArray()[0] - '0';
            if (prefix1.equals("5")) {
                if (back1.equals("1")){
                    value1 += 100;
                } else {
                    value1 += 200;
                }
            }
            if (prefix2.equals("5")) {
                if (back2.equals("1")){
                    value2 += 100;
                } else {
                    value2 += 200;
                }
            }
            return value1 - value2;
        });
    }

    //添加组件
    public void initView() {
        //创建抢地主的按钮
        JButton robBut = new JButton("抢地主");
        //设置位置
        robBut.setBounds(320, 400, 75, 20);
        //添加点击事件
        robBut.addActionListener(this);
        //设置隐藏
        robBut.setVisible(false);
        //添加到数组中统一管理
        landlord[0] = robBut;
        //添加到界面中
        container.add(robBut);

        //创建不抢的按钮
        JButton noBut = new JButton("不     抢");
        //设置位置
        noBut.setBounds(420, 400, 75, 20);
        //添加点击事件
        noBut.addActionListener(this);
        //设置隐藏
        noBut.setVisible(false);
        //添加到数组中统一管理
        landlord[1] = noBut;
        //添加到界面中
        container.add(noBut);

        //创建出牌的按钮
        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //创建不要的按钮
        JButton noCardBut = new JButton("不要");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);


        //创建三个玩家前方的提示文字：倒计时
        //每个玩家一个
        //左边的电脑玩家是0
        //中间的自己是1
        //右边的电脑玩家是2
        for (int i = 0; i < 3; i++) {
            time[i] = new JTextField("倒计时:");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);


        //创建地主图标
        dizhu = new JLabel(new ImageIcon("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo19\\image\\dizhu.png"));
        dizhu.setVisible(false);
        dizhu.setSize(40, 40);
        container.add(dizhu);

    }

    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
