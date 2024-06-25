package org.ncre.GUI;

import org.ncre.data.domain.AdministratorAccount;
import org.ncre.service.NCREService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
public class AdLogin extends JFrame implements ActionListener {
    private JButton LoginJB1, LoginJB2;  //按钮
    private JPanel LoginJP, LoginJP1, LoginJP2, LoginJP3, LoginJP4,LoginJP5;  //面板
    private JTextField LoginJTF;   //文本框
    private JLabel LoginJLTitle, LoginJL1, LoginJL2; //标签
    private Icon eye_close, eye_open;
    private JToggleButton LoginPasswordButton;
    private JPasswordField LoginJPF; //密码框
    private NCREService LoginCGERService;
    private NCRE ncre;
    private AdministratorAccount administratorAccount;
    private Styles styles;
    public AdLogin(Styles styles, NCREService cgermService, NCRE ncre) {
        this.styles = styles;
        this.LoginCGERService = cgermService;
        this.ncre = ncre;
        administratorAccount = new AdministratorAccount();
        this.setLayout(null);
        this.setTitle("计算机等级考试报名管理系统");
        this.setSize(800, 600);   //设置窗体大小
        eye_open = new ImageIcon("src/main/resources/Pictures/eye_open.png");
        eye_close = new ImageIcon("src/main/resources/Pictures/eye_close.png");
        LoginPasswordButton = new JRadioButton();
        LoginJP = new JPanel();
        LoginJP1 = new JPanel();  //创建面板
        LoginJP2 = new JPanel();
        LoginJP3 = new JPanel();
        LoginJP4 = new JPanel();
        LoginJP5 = new JPanel();
        LoginJLTitle = new JLabel("管理员登录");
        LoginJL1 = new JLabel("账    号:");  //添加标签
        LoginJL2 = new JLabel("密    码:");
        LoginJTF = new JTextField(20);   //创建文本框和密码框
        LoginJPF = new JPasswordField(20);
        LoginJB1 = new JButton("登录");
        LoginJB2 = new JButton("清除");
        this.LoginJPInit();
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
        LoginJP5.add(LoginPasswordButton);

        LoginJB1.addActionListener(this);
        LoginJB2.addActionListener(this);
        LoginPasswordButton.addActionListener(this);
        LoginJB1.setActionCommand("Login");
        LoginJB2.setActionCommand("LoginClear");
        LoginPasswordButton.setActionCommand("LoginPBChange");
        LoginJPF.setEchoChar('*');  // 设置密码隐藏

        FlowLayout AdLoginButtonGap=new FlowLayout();
        AdLoginButtonGap.setHgap(100);//水平间距
        LoginJP4.setLayout(AdLoginButtonGap);
    }
    public void Init(){
        LoginClear();
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.add(LoginJP);
        LoginJP.setVisible(true);
        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
    }

    private void Login(){
        if(Objects.equals(LoginJTF.getText(), "") || Objects.equals(LoginJPF.getText(), "")){
            JOptionPane.showMessageDialog(null, "账号或密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }else{
            String Taccount = LoginJTF.getText();
            String Tpassword = LoginJPF.getText();
            administratorAccount = LoginCGERService.GetADAccountByAccount(Taccount);
            if(administratorAccount != null&&Objects.equals(Tpassword, administratorAccount.getPassword())){
                JOptionPane.showMessageDialog(null, "登录成功！","消息提示",JOptionPane.WARNING_MESSAGE);
                LoginClear();
                dispose();  //使文原窗体消失
                ncre.AdMenu();
            }else{
                administratorAccount = null;
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
    private void LoginPBChange(){   // 登录时密码状态转换
        if(LoginJPF.getEchoChar() == '*'){
            LoginJPF.setEchoChar((char) 0);//设置密码显示
            LoginPasswordButton.setIcon(eye_close);
        }else{
            LoginJPF.setEchoChar('*');//设置密码显示
            LoginPasswordButton.setIcon(eye_open);
        }
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
        else if(Objects.equals(e.getActionCommand(),"LoginPBChange")){
            this.LoginPBChange();
        }

    }

}
