package org.ncre.GUI;

import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.ncre.service.NCREService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class UserMenu implements ActionListener {
    private JPanel UserMenuJP;
    private JPanel PictureJP, UserMenuAccountJP,UserMenuBarJP,UserMenuFirstJP,
            UserMenuSignUpJP,UserMenuFindInfoJP,UserMenuReviseInfoJP,
            UserMenuLogOffJP,UserMenuLogOutJP;

    private JLabel Picture;
    private JLabel UserMenuAccountJL1,UserMenuAccountJL2;
    private JMenuBar menuBar;// 下拉式菜单
    private JMenu menu1,menu2,menu3,menu4;
    private JMenuItem Menu1Item1,Menu2Item1,Menu3Item1, Menu3Item2, Menu4Item1,Menu4Item2;
    private Icon icon;
    private Styles styles;
    private User user;
    private NCREService ncreService;

    private NCRE ncre;

    private JButton SignUpButtonSignup,SignUpButtonClear;
    private JPanel SignUpButtonSignupJP;
    private JPanel SignUpInfoJP;
    private JPanel SignUpInfoJPOverAll,SignUpInfoJP1,SignUpInfoJP2,SignUpInfoJP3,SignUpInfoJP4,SignUpInfoJP5,SignUpInfoJP6,SignUpInfoJP7,SignUpInfoJP8;
    private JLabel SignUpNameJL,SignUpGenderJL,SignUpAgeJL,SignUpSchoolidJL,SignUpPhoneJL,SignUpRankJL,SignUpSchoolJL;
    private JTextField SignUpNameJTF,SignUpAgeJTF,SignUpSchoolidJTF,SignUpPhoneJTF,SignUpSchoolJTF;
    private JComboBox<String> SignUpGender = new JComboBox<>();
    private JComboBox<String> SignUpRank = new JComboBox<>();
    UserMenu(Styles styles,NCREService ncreService){
        this.ncreService = ncreService;
        user = new User();
        this.styles = styles;
        UserMenuJP = new JPanel();
        PictureJP = new JPanel();
        menuBar = new JMenuBar();
        UserMenuBarJP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menu1=new JMenu("首页");
        menu2=new JMenu("报名");
        menu3=new JMenu("信息");
        menu4 = new JMenu("账户");
        Menu1Item1 = new JMenuItem("首页");
        Menu2Item1 = new JMenuItem("考试报名");
        Menu3Item1 = new JMenuItem("修改个人信息");
        Menu3Item2 = new JMenuItem("查看考试信息");
        Menu4Item1 = new JMenuItem("退出登录");
        Menu4Item2 = new JMenuItem("注销账户");
        UserMenuAccountJP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        UserMenuFirstJP = new JPanel();

        UserMenuFindInfoJP = new JPanel();
        UserMenuReviseInfoJP = new JPanel();
        UserMenuLogOffJP = new JPanel();
        UserMenuLogOutJP = new JPanel();


        UserMenuSignUpJP = new JPanel();
        UserMenuAccountJL1 = new JLabel("账户：");
        UserMenuAccountJL1.setForeground(Color.white);
        UserMenuAccountJL2 = new JLabel("");
        UserMenuAccountJL2.setForeground(Color.white);

        Picture = new JLabel();
        icon = new ImageIcon("src\\main\\resources\\Pictures\\NCRE.jpg");

    }
    // 设置用户登录的账户
    public void SetUserAP(UserAccount userAccount){
        user.setAccount(userAccount);
    }
    public void SetNCRE(NCRE ncre){
        this.ncre = ncre;
    }
    public void UserMenuUpdate(){
        // 获取用户信息
        try {
            user.setUserInfo(ncreService.GetUserInfoByAccount(user.getAccount().getAccount()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"消息提示",JOptionPane.WARNING_MESSAGE);
        }
        UserMenuAccountJL2.setText(user.getAccount().getAccount());
    }
    public JPanel Init(){

        UserMenuJP.setBounds(0,0,styles.MaxWidth,styles.MaxHeight);
        UserMenuJP.setLayout(null);
        PictureJP.setLayout(null);
        UserMenuSignUpJP.setLayout(null);

        PictureJP.setBounds(0,0,1200,70);
        Picture.setBounds(0,0,400,70);
        UserMenuAccountJP.setBounds(800,40,400,30); // 表头、账号
        UserMenuBarJP.setBounds(300,100,1200,40);
        UserMenuFirstJP.setBounds(0,140,1200,660);
        UserMenuSignUpJP.setBounds(0,140,1200,660);
        UserMenuFindInfoJP.setBounds(0,140,1200,660);
        UserMenuReviseInfoJP.setBounds(0,140,1200,660);
        UserMenuLogOffJP.setBounds(0,140,1200,660);
        UserMenuLogOutJP.setBounds(0,140,1200,660);



        UserMenuAccountJL1.setFont(styles.SmallJLFont);
        UserMenuAccountJL2.setFont(styles.SmallJLFont);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menu1.add(Menu1Item1);
        menu2.add(Menu2Item1);
        menu3.add(Menu3Item1);
        menu3.add(Menu3Item2);
        menu4.add(Menu4Item1);
        menu4.add(Menu4Item2);
        menu1.setFont(styles.MenuBarFont);
        menu2.setFont(styles.MenuBarFont);
        menu3.setFont(styles.MenuBarFont);
        menu4.setFont(styles.MenuBarFont);
        Menu1Item1.setFont(styles.MenuBarButtonFont);
        Menu2Item1.setFont(styles.MenuBarButtonFont);
        Menu3Item1.setFont(styles.MenuBarButtonFont);
        Menu3Item2.setFont(styles.MenuBarButtonFont);
        Menu4Item1.setFont(styles.MenuBarButtonFont);
        Menu4Item2.setFont(styles.MenuBarButtonFont);

        Menu1Item1.addActionListener(this);
        Menu2Item1.addActionListener(this);
        Menu3Item1.addActionListener(this);
        Menu3Item2.addActionListener(this);
        Menu4Item1.addActionListener(this);
        Menu4Item2.addActionListener(this);
        Menu1Item1.setActionCommand("FirstJP");
        Menu2Item1.setActionCommand("SignUpJP");
        Menu3Item1.setActionCommand("ReviseInfoJP");
        Menu3Item2.setActionCommand("FindInfoJP");
        Menu4Item1.setActionCommand("LogOffJP");
        Menu4Item2.setActionCommand("LogOutJP");

        PictureJP.setBackground(Color.white);
        UserMenuAccountJP.setBackground(new Color(65,91,128));
        UserMenuBarJP.setBackground(Color.red);
        UserMenuFirstJP.setBackground(Color.pink);
        UserMenuSignUpJP.setBackground(Color.green);
        UserMenuFindInfoJP.setBackground(Color.yellow);
        UserMenuReviseInfoJP.setBackground(Color.magenta);
        UserMenuLogOffJP.setBackground(Color.cyan);
        UserMenuLogOutJP.setBackground(Color.orange);



        Picture.setIcon(icon);
        UserMenuJP.add(PictureJP);
        UserMenuBarJP.add(menuBar);
        PictureJP.add(UserMenuAccountJP);
        UserMenuJP.add(UserMenuBarJP);

        UserMenuJP.add(UserMenuFirstJP);
        UserMenuJP.add(UserMenuSignUpJP);
        UserMenuJP.add(UserMenuFindInfoJP);
        UserMenuJP.add(UserMenuReviseInfoJP);
        UserMenuJP.add(UserMenuLogOffJP);
        UserMenuJP.add(UserMenuLogOutJP);

        UserMenuFirstJP.setVisible(true);
        UserMenuSignUpJP.setVisible(false);
        UserMenuFindInfoJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);
        UserMenuLogOffJP.setVisible(false);
        UserMenuLogOutJP.setVisible(false);

        UserMenuAccountJP.add(UserMenuAccountJL1);
        UserMenuAccountJP.add(UserMenuAccountJL2);

        PictureJP.add(Picture);
        this.SignUpJPInit();
        return UserMenuJP;
    }
    public void SignUpJPInit(){
        SignUpGender.addItem("-请选择-");
        SignUpGender.addItem("男");
        SignUpGender.addItem("女");


        SignUpRank.addItem("-请选择-");
        SignUpRank.addItem("一级");
        SignUpRank.addItem("二级");
        SignUpRank.addItem("三级");
        SignUpRank.addItem("四级");

        SignUpInfoJP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SignUpInfoJP8 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        SignUpNameJL = new JLabel("姓    名：");
        SignUpGenderJL = new JLabel("性    别：");
        SignUpAgeJL = new JLabel("年    龄：");
        SignUpSchoolidJL = new JLabel("学    号：");
        SignUpPhoneJL = new JLabel("电    话：");
        SignUpRankJL = new JLabel("考试等级：");
        SignUpSchoolJL = new JLabel("学    校：");
        SignUpButtonSignup = new JButton("报名");
        SignUpButtonClear = new JButton("清空");

        SignUpNameJTF = new JTextField(20);
        SignUpAgeJTF = new JTextField(20);
        SignUpSchoolidJTF = new JTextField(20);
        SignUpPhoneJTF = new JTextField(20);
        SignUpSchoolJTF = new JTextField(20);

        SignUpNameJL.setFont(styles.SmallJLFont);
        SignUpGenderJL.setFont(styles.SmallJLFont);
        SignUpAgeJL.setFont(styles.SmallJLFont);
        SignUpSchoolidJL.setFont(styles.SmallJLFont);
        SignUpPhoneJL.setFont(styles.SmallJLFont);
        SignUpRankJL.setFont(styles.SmallJLFont);
        SignUpSchoolJL.setFont(styles.SmallJLFont);

        SignUpNameJTF.setFont(styles.SmallJLFont);
        SignUpGender.setFont(styles.SmallJLFont);
        SignUpRank.setFont(styles.SmallJLFont);
        SignUpAgeJTF.setFont(styles.SmallJLFont);
        SignUpSchoolidJTF.setFont(styles.SmallJLFont);
        SignUpPhoneJTF.setFont(styles.SmallJLFont);
        SignUpSchoolJTF.setFont(styles.SmallJLFont);
        SignUpButtonSignup.setFont(styles.ButtonFont);
        SignUpButtonClear.setFont(styles.ButtonFont);


        SignUpButtonSignupJP = new JPanel();
        SignUpInfoJP = new JPanel(null);
        SignUpInfoJPOverAll = new JPanel(null);

        SignUpButtonSignupJP.setBounds(300,500,600,180);
        SignUpInfoJP.setBounds(240,0,740,450);
        SignUpInfoJPOverAll.setBounds(200,0,500,800);
        SignUpInfoJP1.setBounds(0,70,500,70);
        SignUpInfoJP2.setBounds(0,140,500,70);
        SignUpInfoJP3.setBounds(0,210,500,70);
        SignUpInfoJP4.setBounds(0,280,500,70);
        SignUpInfoJP5.setBounds(0,350,500,70);
        SignUpInfoJP6.setBounds(0,420,500,70);
        SignUpInfoJP7.setBounds(0,490,500,70);


        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0,20);
        verticalScrollBar.setBounds(720,0,20,450);
        // 监听滚动条的数值变化事件
        verticalScrollBar.addAdjustmentListener(e -> {
            int value = e.getValue();
            SignUpInfoJPOverAll.setLocation(SignUpInfoJPOverAll.getX(), -value * 20); // 以标签高度为单位滚动
        });



        SignUpInfoJP.add(SignUpInfoJPOverAll);
        SignUpInfoJP.add(verticalScrollBar);

        SignUpInfoJPOverAll.add(SignUpInfoJP1);
        SignUpInfoJPOverAll.add(SignUpInfoJP2);
        SignUpInfoJPOverAll.add(SignUpInfoJP3);
        SignUpInfoJPOverAll.add(SignUpInfoJP4);
        SignUpInfoJPOverAll.add(SignUpInfoJP5);
        SignUpInfoJPOverAll.add(SignUpInfoJP6);
        SignUpInfoJPOverAll.add(SignUpInfoJP7);
        SignUpInfoJPOverAll.add(SignUpInfoJP8);

        SignUpInfoJP1.add(SignUpNameJL);
        SignUpInfoJP1.add(SignUpNameJTF);
        SignUpInfoJP2.add(SignUpGenderJL);
        SignUpInfoJP2.add(SignUpGender);
        SignUpInfoJP3.add(SignUpAgeJL);
        SignUpInfoJP3.add(SignUpAgeJTF);
        SignUpInfoJP4.add(SignUpSchoolidJL);
        SignUpInfoJP4.add(SignUpSchoolidJTF);
        SignUpInfoJP5.add(SignUpPhoneJL);
        SignUpInfoJP5.add(SignUpPhoneJTF);
        SignUpInfoJP6.add(SignUpRankJL);
        SignUpInfoJP6.add(SignUpRank);
        SignUpInfoJP7.add(SignUpSchoolJL);
        SignUpInfoJP7.add(SignUpSchoolJTF);


        SignUpButtonSignup.addActionListener(this);
        SignUpButtonClear.addActionListener(this);
        SignUpButtonSignup.setActionCommand("SignUp");
        SignUpButtonClear.setActionCommand("SignUpClear");


        UserMenuSignUpJP.add(SignUpInfoJP);
        SignUpButtonSignupJP.add(SignUpButtonSignup);
        SignUpButtonSignupJP.add(SignUpButtonClear);

        FlowLayout  SignUpButtonGap=new FlowLayout();
        SignUpButtonGap.setHgap(120);//水平间距
        SignUpButtonSignupJP.setLayout(SignUpButtonGap);

        UserMenuSignUpJP.add(SignUpButtonSignupJP);
    }
    public void First(){
        UserMenuFirstJP.setVisible(true);
        UserMenuSignUpJP.setVisible(false);
        UserMenuFindInfoJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);
        UserMenuLogOffJP.setVisible(false);
        UserMenuLogOutJP.setVisible(false);
    }
    public void SignUpJP(){
        if(user.getUserInfo() != null){
            if(user.getUserInfo().getName() != null){
                SignUpNameJTF.setText(user.getUserInfo().getName());
                SignUpNameJTF.setEnabled(false);
            }
            if(user.getUserInfo().getGender() != null){
                if(user.getUserInfo().getAge() != null){
                    SignUpAgeJTF.setText(String.valueOf(user.getUserInfo().getAge()));
                    SignUpAgeJTF.setEnabled(false);
                }
                if(user.getUserInfo().getGender() != null) {
                    if (Objects.equals(user.getUserInfo().getGender(), "男")) {
                        SignUpGender.setSelectedItem("男");
                    } else {
                        SignUpGender.setSelectedItem("女");
                    }
                    SignUpGender.setEnabled(false);
                }
                if(user.getUserInfo().getSchoolid()!=null){
                    SignUpSchoolidJTF.setText(String.valueOf(user.getUserInfo().getSchoolid()));
                    SignUpSchoolidJTF.setEnabled(false);
                }
                if(user.getUserInfo().getPhone()!=null){
                    SignUpPhoneJTF.setText(String.valueOf(user.getUserInfo().getPhone()));
                    SignUpPhoneJTF.setEnabled(false);
                }
                if(user.getUserInfo().getSchool()!=null){
                    SignUpSchoolJTF.setText(String.valueOf(user.getUserInfo().getSchool()));
                    SignUpSchoolJTF.setEnabled(false);
                }
            }


        }

        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(true);
        UserMenuFindInfoJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);
        UserMenuLogOffJP.setVisible(false);
        UserMenuLogOutJP.setVisible(false);
    }
    public void FindInfoJP(){
        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(false);
        UserMenuFindInfoJP.setVisible(true);
        UserMenuReviseInfoJP.setVisible(false);
        UserMenuLogOffJP.setVisible(false);
        UserMenuLogOutJP.setVisible(false);
    }
    public void ReviseInfoJP(){
        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(false);
        UserMenuFindInfoJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(true);
        UserMenuLogOffJP.setVisible(false);
        UserMenuLogOutJP.setVisible(false);
    }
    public void LogOffJP(){
        user.setAccount(null);
        user.setUserInfo(null);
        SignUpClear();
        ncre.Load();

    }
    public void LogOutJP(){
        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(false);
        UserMenuFindInfoJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);
        UserMenuLogOffJP.setVisible(false);
        UserMenuLogOutJP.setVisible(true);
    }

    public void SignUpClear(){
        SignUpNameJTF.setText("");
        SignUpGender.setSelectedItem("-请选择-");
        SignUpAgeJTF.setText("");
        SignUpSchoolidJTF.setText("");
        SignUpSchoolJTF.setText("");
        SignUpRank.setSelectedItem("-请选择-");
        SignUpPhoneJTF.setText("");
    }
    public void SignUp(){
        if(Objects.equals(SignUpNameJTF.getText(), "") ||Objects.equals(SignUpAgeJTF.getText(), "") ||
                Objects.equals(SignUpSchoolidJTF.getText(), "") ||Objects.equals(SignUpPhoneJTF.getText(), "") ||
                Objects.equals(SignUpSchoolJTF.getText(), "") ||SignUpGender.getSelectedItem() == "-请选择-"||
                SignUpRank.getSelectedItem() == "-请选择-"){
            JOptionPane.showMessageDialog(null, "请将信息填写完整！","消息提示",JOptionPane.WARNING_MESSAGE);
        }else {
            if(user.getUserInfo().getRank()!=null){
                JOptionPane.showMessageDialog(null, "请勿重复报名！","消息提示",JOptionPane.WARNING_MESSAGE);
            }
            else {
                String TName = SignUpNameJTF.getText();
                String TGender = (String) SignUpGender.getSelectedItem();
                Integer TAge = Integer.valueOf(SignUpAgeJTF.getText());
                String TSchoolid = SignUpSchoolidJTF.getText();
                String TSchool = SignUpSchoolJTF.getText();
                String TRank = (String) SignUpRank.getSelectedItem();
                String TPhone = SignUpPhoneJTF.getText();
                UserInfo userInfo = new UserInfo();
                userInfo.setAccount(user.getAccount().getAccount());
                userInfo.setName(TName);
                userInfo.setGender(TGender);
                userInfo.setAge(TAge);
                userInfo.setSchoolid(TSchoolid);
                userInfo.setSchool(TSchool);
                userInfo.setRank(TRank);
                userInfo.setPhone(TPhone);
                ncreService.SaveUserInfo(userInfo);
                JOptionPane.showMessageDialog(null, "报名成功！", "消息提示", JOptionPane.WARNING_MESSAGE);
                SignUpClear();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "FirstJP")){
            this.First();
        }
        else if(Objects.equals(e.getActionCommand(), "SignUpJP")){
            this.SignUpJP();
        }
        else if(Objects.equals(e.getActionCommand(), "FindInfoJP")){
            this.FindInfoJP();
        }
        else if(Objects.equals(e.getActionCommand(), "ReviseInfoJP")){
            this.ReviseInfoJP();
        }
        else if(Objects.equals(e.getActionCommand(), "LogOffJP")){
            this.LogOffJP();
        }
        else if(Objects.equals(e.getActionCommand(), "LogOutJP")){
            this.LogOutJP();
        }
        else if(Objects.equals(e.getActionCommand(), "SignUp")){
            this.SignUp();
        }
        else if(Objects.equals(e.getActionCommand(), "SignUpClear")){
            this.SignUpClear();
        }

    }
}
