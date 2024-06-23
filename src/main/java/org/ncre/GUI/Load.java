package org.ncre.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Load {
    private JPanel Load,LoadTitleJP,LoadJP1,LoadJP2,LoadJP3,LoadJP4,LoadJP5;
    private JLabel LoadTitleJL;
    private JButton AdLogin,UserLogin;
    private Styles styles;
    Load(Styles styles){
        this.styles = styles;
        Load = new JPanel();
        LoadTitleJP = new JPanel();

        LoadJP1 = new JPanel();
        LoadJP2 = new JPanel();
        LoadJP3 = new JPanel();
        LoadJP4 = new JPanel();

        LoadTitleJL = new JLabel("计算机等级考试报名管理系统");
        AdLogin = new JButton("管理员登录");
        UserLogin = new JButton("用户登录");
    }
    public JPanel Init(ActionListener actionListener){

        Load.setLayout(null);
        LoadTitleJL.setFont(styles.TitleFont);
        AdLogin.setFont(styles.ButtonFont);
        UserLogin.setFont(styles.ButtonFont);

        AdLogin.addActionListener(actionListener);
        UserLogin.addActionListener(actionListener);
        AdLogin.setActionCommand("ADLOGIN");
        UserLogin.setActionCommand("USERLOGIN");

        Load.setBounds(0,0,styles.MaxWidth,styles.MaxHeight);
        LoadTitleJP.setBounds(0,0,styles.MaxWidth,styles.MaxHeight/10*2);
        LoadJP1.setBounds(0,styles.MaxHeight/10*2,styles.MaxWidth,styles.MaxHeight/10*5);
        LoadJP2.setBounds(0,styles.MaxHeight/10*7,styles.MaxWidth,styles.MaxHeight/10*3);


//        LoadTitleJP.setBackground(Color.blue);
//        LoadJP1.setBackground(Color.blue);
//        LoadJP2.setBackground(Color.red);


        FlowLayout DeleteButtonHgap=new FlowLayout();
        DeleteButtonHgap.setHgap(200);//水平间距
        LoadJP2.setLayout(DeleteButtonHgap);

        LoadTitleJP.add(LoadTitleJL);
        LoadJP2.add(AdLogin);
        LoadJP2.add(UserLogin);


        Load.add(LoadTitleJP);
        Load.add(LoadJP1);
        Load.add(LoadJP2);


        return Load;
    }

}
