package org.ncre.GUI;


import org.ncre.data.domain.AdministratorAccount;
import org.ncre.service.NCREService;
import org.springframework.stereotype.Component;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

@Component
public class AdLoginTT extends JFrame implements ActionListener{
    public static void main(String[] args) {
    }
    private JButton JB1, JB2;  //按钮
    private JPanel JP1,JP2,JP3,JP4;        //面板
    private JPanel MJP;        //面板
    private JTextField JTF;   //文本框
    private JLabel JLTitle,JL1, JL2; //标签
    private JPasswordField JPF; //密码框
    private NCREService LoginCGERService;
    private NCRE AdLoginNCRE;
    public AdLoginTT(NCRE ncre, NCREService cgermService) {
        AdLoginNCRE = ncre;
        LoginCGERService = cgermService;
        JB1 = new JButton("登录");
        JB2 = new JButton("清除");
        MJP = new JPanel();
        JP1 = new JPanel();  //创建面板
        JP2 = new JPanel();
        JP3 = new JPanel();
        JP4 = new JPanel();
        JLTitle = new JLabel("管理员登录");
        JL1 = new JLabel("用户名:");  //添加标签
        JL2 = new JLabel("密  码:");
        JTF = new JTextField(20);   //创建文本框和密码框
        JPF = new JPasswordField(20);

    }

    public void Init(){
        this.setLayout(null);
        this.setTitle("计算机等级考试报名管理系统");
        this.setSize(600, 400);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)

        //设置按钮监听
        JB1.addActionListener(this);
        JB2.addActionListener(this);//设置按钮监听
        JB1.setActionCommand("Login");
        JB2.setActionCommand("Clear");
        Font TitleStyle = new Font("宋体",Font.BOLD,37);
        Font JLFont = new Font("宋体",Font.PLAIN,20);

        JLTitle.setFont(TitleStyle);
        JL1.setFont(JLFont);
        JL2.setFont(JLFont);
        JTF.setFont(JLFont);
        JPF.setFont(JLFont);

        MJP.setLayout(null);
        JP4.setLayout(null);

        MJP.setBounds(0,0,600,400);
        JP1.setBounds(0,0,600,100);
        JP2.setBounds(0,150,600,50);
        JP3.setBounds(0,200,600,50);
        JP4.setBounds(0,250,600,150);
        JB1.setBounds(200,30,60,40);
        JB2.setBounds(340,30,60,40);

        JP1.add(JLTitle);
        JP2.add(JL1);
        JP2.add(JTF);
        JP3.add(JL2);
        JP3.add(JPF);
        JP4.add(JB1);
        JP4.add(JB2);

        MJP.add(JP1);
        MJP.add(JP2);
        MJP.add(JP3);
        MJP.add(JP4);
        this.add(MJP);
        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Login"))
        {
            this.login();
        }
        else if(Objects.equals(e.getActionCommand(), "Clear"))
        {
            this.clear();
        }
    }
    //清空账号和密码框
    private void clear() {
        JTF.setText("");    //设置为空
        JPF.setText("");
    }

    //验证登录信息，并做处理
    private void login()
    {
        if(JTF.getText().isEmpty()&&JPF.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "账号密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (JTF.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "账号为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (JPF.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }else{
            AdministratorAccount account = LoginCGERService.GetADAccountByAccount(JTF.getText());
            if (account.getAccount().equals(JTF.getText())&&account.getPassword().equals(JPF.getText()))
            {
                JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                dispose();  //使文原窗体消失
                AdLoginNCRE.AdL();
            }else {
                JOptionPane.showMessageDialog(null, "账号密码错误请重新输入！","消息提示",JOptionPane.ERROR_MESSAGE);
                this.clear();  //调用清除函数
            }
        }
    }
}