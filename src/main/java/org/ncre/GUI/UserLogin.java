package org.ncre.GUI;


import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.service.NCREService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Component
public class UserLogin extends JFrame implements ActionListener{
    private JButton LoginJB1, LoginJB2, LoginJB3;  //按钮
    private JButton RegisterJB1, RegisterJB2,RegisterJB3;  //按钮
    private JPanel LoginJP, LoginJP1, LoginJP2, LoginJP3, LoginJP4,LoginJP5;  //面板
    private JPanel RegisterJP, RegisterJP1, RegisterJP2, RegisterJP3, RegisterJP4,RegisterJP5,RegisterJP6,RegisterJP7;
    private JTextField LoginJTF,RegisterJTF;   //文本框
    private JLabel LoginJLTitle, LoginJL1, LoginJL2; //标签

    private Icon eye_close, eye_open;
    private JToggleButton LoginPasswordButton,RegisterPasswordButton1,RegisterPasswordButton2;

    private JLabel RegisterJLTitle, RegisterJL1,RegisterJL2,RegisterJL3; //标签
    private JPasswordField LoginJPF,RegisterJPF1,RegisterJPF2; //密码框
    private NCREService LoginCGERService;
    private NCRE ncre;
    private UserAccount userAccount;
    private Styles styles;
    public UserLogin(Styles styles,NCREService cgermService,NCRE ncre) {
        this.styles = styles;
        this.LoginCGERService = cgermService;
        this.ncre = ncre;
        userAccount = new UserAccount();
        this.setLayout(null);
        this.setTitle("计算机等级考试报名管理系统");
        this.setSize(800, 600);   //设置窗体大小


        eye_open = new ImageIcon("src/main/resources/Pictures/eye_open.png");
        eye_close = new ImageIcon("src/main/resources/Pictures/eye_close.png");
        LoginPasswordButton = new JRadioButton();
        RegisterPasswordButton1 = new JRadioButton();
        RegisterPasswordButton2 = new JRadioButton();

        LoginJP = new JPanel();
        RegisterJP = new JPanel();
        LoginJP1 = new JPanel();  //创建面板
        LoginJP2 = new JPanel();
        LoginJP3 = new JPanel();
        LoginJP4 = new JPanel();
        LoginJP5 = new JPanel();
        RegisterJP1 = new JPanel();
        RegisterJP2 = new JPanel();
        RegisterJP3 = new JPanel();
        RegisterJP4 = new JPanel();
        RegisterJP5 = new JPanel();
        RegisterJP6 = new JPanel();
        RegisterJP7 = new JPanel();
        LoginJLTitle = new JLabel("用户登录");
        RegisterJLTitle = new JLabel("用户注册");
        LoginJL1 = new JLabel("账    号:");  //添加标签
        LoginJL2 = new JLabel("密    码:");
        RegisterJL1 = new JLabel("账    号:");  //添加标签
        RegisterJL2 = new JLabel("密    码:");
        RegisterJL3 = new JLabel("确认密码:");
        LoginJTF = new JTextField(20);   //创建文本框和密码框
        LoginJPF = new JPasswordField(20);
        RegisterJPF1 = new JPasswordField(20);
        RegisterJPF2 = new JPasswordField(20);
        RegisterJTF = new JTextField(20);
        LoginJB1 = new JButton("登录");
        LoginJB2 = new JButton("清除");
        LoginJB3 = new JButton("注册");
        RegisterJB1 = new JButton("注册");
        RegisterJB2 = new JButton("清除");
        RegisterJB3 = new JButton("返回");
        this.LoginJPInit();
        this.RegisterJPInit();

    }
    private void LoginJPInit(){

        LoginJP.setLayout(null);
        LoginJP.setBounds(0,0,800,600);
        LoginJP1.setBounds(0,0,800,100);
        LoginJP2.setBounds(0,150,800,100);
        LoginJP3.setBounds(170,250,460,100);
        LoginJP5.setBounds(620,250,60,50);
        LoginJP4.setBounds(0,400,800,200);

        LoginJLTitle.setFont(styles.TitleFont);
        LoginJL1.setFont(styles.JLFont);
        LoginJL2.setFont(styles.JLFont);
        LoginJTF.setFont(styles.JLFont);
        LoginJPF.setFont(styles.JLFont);
        LoginJB1.setFont(styles.ButtonFont);
        LoginJB2.setFont(styles.ButtonFont);
        LoginJB3.setFont(styles.ButtonFont);

        LoginJP1.add(LoginJLTitle);
        LoginJP.add(LoginJP1);
        LoginJP.add(LoginJP2);
        LoginJP.add(LoginJP3);
        LoginJP.add(LoginJP4);
        LoginJP.add(LoginJP5);
        LoginJP2.add(LoginJL1);
        LoginJP2.add(LoginJTF);
        LoginJP3.add(LoginJL2);
        LoginJP3.add(LoginJPF);
        LoginJP4.add(LoginJB1);
        LoginJP4.add(LoginJB2);
        LoginJP4.add(LoginJB3);
        LoginJP5.add(LoginPasswordButton);

        LoginJB1.addActionListener(this);
        LoginJB2.addActionListener(this);
        LoginJB3.addActionListener(this);
        LoginPasswordButton.addActionListener(this);
        LoginJB1.setActionCommand("Login");
        LoginJB2.setActionCommand("LoginClear");
        LoginJB3.setActionCommand("RegisterInit");
        LoginPasswordButton.setActionCommand("LoginPBChange");
        LoginJPF.setEchoChar('*');  // 设置密码隐藏

        FlowLayout UserButtonHgap=new FlowLayout();
        UserButtonHgap.setHgap(100);//水平间距
        LoginJP4.setLayout(UserButtonHgap);
    }
    private void RegisterJPInit(){
        RegisterJP.setLayout(null);

        RegisterJP.setBounds(0,0,800,600);
        RegisterJP1.setBounds(0,0,800,100);
        RegisterJP2.setBounds(0,100,800,100);
        RegisterJP3.setBounds(170,200,460,100);
        RegisterJP6.setBounds(620,200,60,50);
        RegisterJP4.setBounds(170,300,460,100);
        RegisterJP7.setBounds(620,300,60,50);
        RegisterJP5.setBounds(0,400,800,200);

        RegisterJLTitle.setFont(styles.TitleFont);
        RegisterJB1.setFont(styles.ButtonFont);
        RegisterJB2.setFont(styles.ButtonFont);
        RegisterJB3.setFont(styles.ButtonFont);
        RegisterJL1.setFont(styles.JLFont);
        RegisterJL2.setFont(styles.JLFont);
        RegisterJL3.setFont(styles.JLFont);
        RegisterJTF.setFont(styles.JLFont);
        RegisterJPF1.setFont(styles.JLFont);
        RegisterJPF2.setFont(styles.JLFont);

//        RegisterJP1.setBackground(Color.red);
//        RegisterJP2.setBackground(Color.yellow);
//        RegisterJP3.setBackground(Color.blue);
//        RegisterJP4.setBackground(Color.cyan);
//        RegisterJP5.setBackground(Color.magenta);

        RegisterJP.add(RegisterJP1);
        RegisterJP.add(RegisterJP2);
        RegisterJP.add(RegisterJP3);
        RegisterJP.add(RegisterJP4);
        RegisterJP.add(RegisterJP5);
        RegisterJP.add(RegisterJP6);
        RegisterJP.add(RegisterJP7);


        RegisterJP1.add(RegisterJLTitle);
        RegisterJP2.add(RegisterJL1);
        RegisterJP2.add(RegisterJTF);
        RegisterJP3.add(RegisterJL2);
        RegisterJP3.add(RegisterJPF1);
        RegisterJP4.add(RegisterJL3);
        RegisterJP4.add(RegisterJPF2);
        RegisterJP5.add(RegisterJB1);
        RegisterJP5.add(RegisterJB2);
        RegisterJP5.add(RegisterJB3);
        RegisterJP6.add(RegisterPasswordButton1);
        RegisterJP7.add(RegisterPasswordButton2);

        RegisterJB1.addActionListener(this);
        RegisterJB2.addActionListener(this);
        RegisterJB3.addActionListener(this);
        RegisterPasswordButton1.addActionListener(this);
        RegisterPasswordButton2.addActionListener(this);
        RegisterJB1.setActionCommand("Register");
        RegisterJB2.setActionCommand("RegisterClear");
        RegisterJB3.setActionCommand("ReturnLogin");
        RegisterPasswordButton1.setActionCommand("RegisterPBChange1");
        RegisterPasswordButton2.setActionCommand("RegisterPBChange2");

        FlowLayout UserButtonHgap=new FlowLayout();
        UserButtonHgap.setHgap(100);//水平间距
        RegisterJP5.setLayout(UserButtonHgap);


    }
    public UserAccount Init(){
        LoginClear();
        RegisterClear();
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.add(LoginJP);
        this.add(RegisterJP);
        LoginJP.setVisible(true);
        RegisterJP.setVisible(false);
        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
        return userAccount;
    }

    private void Login(){
        if(Objects.equals(LoginJTF.getText(), "") || Objects.equals(LoginJPF.getText(), "")){
            JOptionPane.showMessageDialog(null, "账号或密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }else{
            String Taccount = LoginJTF.getText();
            String Tpassword = LoginJPF.getText();
            userAccount = LoginCGERService.GetUserAPByAccount(Taccount);
            if(Objects.equals(Tpassword, userAccount.getPassword())){
                JOptionPane.showMessageDialog(null, "登录成功！","消息提示",JOptionPane.WARNING_MESSAGE);
                LoginClear();
                dispose();  //使文原窗体消失
                ncre.UserMenu(userAccount);
            }else{
                userAccount = null;
                JOptionPane.showMessageDialog(null, "账号或密码错误，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
                LoginClear();
            }
        }
    }
    private void LoginClear() {
        LoginJTF.setText("");    //设置为空
        LoginJPF.setText("");
        LoginJPF.setEchoChar('*');//设置密码显示
        LoginPasswordButton.setIcon(eye_open);
    }
    private void RegisterInit(){
        LoginClear();
        LoginJP.setVisible(false);
        RegisterJP.setVisible(true);
    }

    private void Register(){
        if(Objects.equals(RegisterJTF.getText(), "") ||
                Objects.equals(RegisterJPF1.getText(), "") ||
                Objects.equals(RegisterJPF2.getText(), "")){
            JOptionPane.showMessageDialog(null, "账号或密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }else if(!Objects.equals(RegisterJPF1.getText(), RegisterJPF2.getText())){
            JOptionPane.showMessageDialog(null, "两次输入密码不相同，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
            RegisterJPF1.setText("");
            RegisterJPF2.setText("");
        }
        else{
            String Taccount = RegisterJTF.getText();
            String Tpassword = RegisterJPF1.getText();
            UserAccount TuserAccount = LoginCGERService.GetUserAPByAccount(Taccount);
            if(TuserAccount!=null){
                JOptionPane.showMessageDialog(null, "该账号已存在，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
                RegisterClear();
            }else{
                UserAccount userAccount = new UserAccount();
                userAccount.setAccount(Taccount);
                userAccount.setPassword(Tpassword);
                LoginCGERService.SaveUserAcPw(userAccount);
                JOptionPane.showMessageDialog(null, "注册成功！","消息提示",JOptionPane.WARNING_MESSAGE);
                this.RegisterClear();
                this.ReturnLogin();
            }
        }
    }
    private void LoginPBChange(){   // 登录时密码状态转换
        if(LoginJPF.getEchoChar() == '*'){
            LoginJPF.setEchoChar((char) 0);//设置密码显示
            LoginPasswordButton.setIcon(eye_close);
        }else{
            LoginJPF.setEchoChar('*');//设置密码显示
            LoginPasswordButton.setIcon(eye_open);
        }
    }
    private void RegisterPBChange1(){   // 注册时密码状态转换
        if(RegisterJPF1.getEchoChar() == '*'){
            RegisterJPF1.setEchoChar((char) 0);//设置密码显示
            RegisterPasswordButton1.setIcon(eye_close);
        }else{
            RegisterJPF1.setEchoChar('*');//设置密码显示
            RegisterPasswordButton1.setIcon(eye_open);
        }
    }

    private void RegisterPBChange2(){   // 注册时确认密码状态转换
        if(RegisterJPF2.getEchoChar() == '*'){
            RegisterJPF2.setEchoChar((char) 0);//设置密码显示
            RegisterPasswordButton2.setIcon(eye_close);
        }else{
            RegisterJPF2.setEchoChar('*');//设置密码显示
            RegisterPasswordButton2.setIcon(eye_open);
        }
    }

    private void RegisterClear() {
        RegisterJTF.setText("");    //设置为空
        RegisterJPF1.setText("");
        RegisterJPF2.setText("");
        RegisterJPF1.setEchoChar('*');  // 设置密码隐藏
        RegisterJPF2.setEchoChar('*');  // 设置密码隐藏
        RegisterPasswordButton1.setIcon(eye_open);
        RegisterPasswordButton2.setIcon(eye_open);
    }
    private void ReturnLogin(){
        LoginJP.setVisible(true);
        RegisterJP.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Login"))
        {
            this.Login();
        }
        else if(Objects.equals(e.getActionCommand(), "LoginClear"))
        {
            this.LoginClear();
        }
        else if(Objects.equals(e.getActionCommand(), "RegisterInit"))
        {
            this.RegisterInit();
        }else if(Objects.equals(e.getActionCommand(),"LoginPBChange")){
            this.LoginPBChange();
        }
        else if(Objects.equals(e.getActionCommand(),"RegisterPBChange1")){
            this.RegisterPBChange1();
        }
        else if(Objects.equals(e.getActionCommand(),"RegisterPBChange2")){
            this.RegisterPBChange2();
        }
        else if(Objects.equals(e.getActionCommand(), "Register"))
        {
            this.Register();
        }
        else if(Objects.equals(e.getActionCommand(), "RegisterClear"))
        {
            this.RegisterClear();
        }
        else if(Objects.equals(e.getActionCommand(), "ReturnLogin"))
        {
            this.ReturnLogin();
        }
    }

}