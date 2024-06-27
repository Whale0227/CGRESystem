package org.ncre.GUI;

import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.ncre.service.NCREService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UserMenu implements ActionListener {
    private JPanel UserMenuJP;
    private JPanel PictureJP, UserMenuAccountJP,UserMenuBarJP,UserMenuFirstJP,
            UserMenuSignUpJP,UserMenuReviseInfoJP;

    private JLabel Picture;
    private JLabel UserMenuAccountJL1,UserMenuAccountJL2;   // 展示登录账号
    private JMenuBar menuBar;// 下拉式菜单
    private JMenu menu1,menu2,menu3,menu4;  // 菜单栏选项
    private JMenuItem Menu1Item1,Menu2Item1,Menu3Item1, Menu4Item1,Menu4Item2;  //菜单栏下拉选项
    private final Icon icon;  // 资源图片
    private final Styles styles;  // 格式
    private User user;  // 用户信息
    private final NCREService ncreService;    // 服务器
    private NCRE ncre;  // 主面板
    private JButton SignUpButtonSignup,SignUpButtonClear;
    private JPanel SignUpButtonSignupJP;
    private JPanel SignUpInfoJP;
    private JPanel SignUpInfoJPOverAll,SignUpInfoJP1,SignUpInfoJP2,SignUpInfoJP3,SignUpInfoJP4,SignUpInfoJP5,SignUpInfoJP6,SignUpInfoJP7;
    private JLabel SignUpNameJL,SignUpGenderJL,SignUpAgeJL,SignUpSchoolidJL,SignUpPhoneJL,SignUpRankJL,SignUpSchoolJL;
    private JTextField SignUpNameJTF,SignUpAgeJTF,SignUpSchoolidJTF,SignUpPhoneJTF,SignUpSchoolJTF;
    private JLabel ReviseInfoNameJL,ReviseInfoGenderJL,ReviseInfoAgeJL,ReviseInfoSchoolidJL,
            ReviseInfoPhoneJL,ReviseInfoRankJL,ReviseInfoSchoolJL;
    private JTextField ReviseInfoNameJTF,ReviseInfoAgeJTF,ReviseInfoSchoolidJTF,
            ReviseInfoPhoneJTF,ReviseInfoRankJTF,ReviseInfoSchoolJTF;
   private JButton ReviseInfoButtonRevise,ReviseInfoButtonClear;

    private JPanel ReviseInfoButtonJP,ReviseInfoJP,ReviseInfoJPOverAll,ReviseInfoJP1,
            ReviseInfoJP2,ReviseInfoJP3,ReviseInfoJP4,ReviseInfoJP5,ReviseInfoJP6,ReviseInfoJP7;
    private JComboBox<String> ReviseInfoGender = new JComboBox<>();
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
        Menu4Item1 = new JMenuItem("退出登录");
        Menu4Item2 = new JMenuItem("注销账户");
        UserMenuAccountJP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        UserMenuFirstJP = new JPanel(null);
        UserMenuReviseInfoJP = new JPanel();
        UserMenuSignUpJP = new JPanel();
        UserMenuAccountJL1 = new JLabel("账户：");
        UserMenuAccountJL1.setForeground(Color.white);
        UserMenuAccountJL2 = new JLabel("");
        UserMenuAccountJL2.setForeground(Color.white);
        Picture = new JLabel();
        icon = new ImageIcon("src\\main\\resources\\Pictures\\NCRE.jpg");

    }
    // 设置用户登录的账户
    public void Initialize(UserAccount userAccount){
        user.setAccount(userAccount);
        UserInfoUpdate();
        FirstJP();
    }
    public void SetNCRE(NCRE ncre){
        this.ncre = ncre;
    }
    public JPanel Init(){
        UserMenuJP.setBounds(0,0,styles.MaxWidth,styles.MaxHeight);
        UserMenuJP.setLayout(null);
        PictureJP.setLayout(null);
        UserMenuSignUpJP.setLayout(null);
        UserMenuReviseInfoJP.setLayout(null);
        PictureJP.setBounds(0,0,1200,70);
        Picture.setBounds(0,0,400,70);
        UserMenuAccountJP.setBounds(800,40,400,30); // 表头、账号
        UserMenuBarJP.setBounds(300,100,1200,40);
        UserMenuFirstJP.setBounds(0,140,1200,660);
        UserMenuSignUpJP.setBounds(0,140,1200,660);
        UserMenuReviseInfoJP.setBounds(0,140,1200,660);


        UserMenuAccountJL1.setFont(styles.SmallJLFont);
        UserMenuAccountJL2.setFont(styles.SmallJLFont);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menu1.add(Menu1Item1);
        menu2.add(Menu2Item1);
        menu3.add(Menu3Item1);
        menu4.add(Menu4Item1);
        menu4.add(Menu4Item2);
        menu1.setFont(styles.MenuBarFont);
        menu2.setFont(styles.MenuBarFont);
        menu3.setFont(styles.MenuBarFont);
        menu4.setFont(styles.MenuBarFont);
        Menu1Item1.setFont(styles.MenuBarButtonFont);
        Menu2Item1.setFont(styles.MenuBarButtonFont);
        Menu3Item1.setFont(styles.MenuBarButtonFont);
        Menu4Item1.setFont(styles.MenuBarButtonFont);
        Menu4Item2.setFont(styles.MenuBarButtonFont);

        Menu1Item1.addActionListener(this);
        Menu2Item1.addActionListener(this);
        Menu3Item1.addActionListener(this);
        Menu4Item1.addActionListener(this);
        Menu4Item2.addActionListener(this);
        Menu1Item1.setActionCommand("FirstJP");
        Menu2Item1.setActionCommand("SignUpJP");
        Menu3Item1.setActionCommand("ReviseInfoJP");
        Menu4Item1.setActionCommand("LogOffJP");
        Menu4Item2.setActionCommand("LogOutJP");

        PictureJP.setBackground(Color.white);
        UserMenuAccountJP.setBackground(new Color(65,91,128));
        UserMenuBarJP.setBackground(Color.red);
        UserMenuSignUpJP.setBackground(Color.yellow);
        UserMenuReviseInfoJP.setBackground(Color.yellow);

        Picture.setIcon(icon);
        UserMenuJP.add(PictureJP);
        UserMenuBarJP.add(menuBar);
        PictureJP.add(UserMenuAccountJP);
        UserMenuJP.add(UserMenuBarJP);

        UserMenuJP.add(UserMenuFirstJP);
        UserMenuJP.add(UserMenuSignUpJP);
        UserMenuJP.add(UserMenuReviseInfoJP);

        UserMenuFirstJP.setVisible(true);
        UserMenuSignUpJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);

        UserMenuAccountJP.add(UserMenuAccountJL1);
        UserMenuAccountJP.add(UserMenuAccountJL2);

        PictureJP.add(Picture);
        this.SignUpJPInit();
        this.ReviseInfoJPInit();
        this.FirstJPInit();
        UserInfoUpdate();
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
        SignUpButtonSignupJP.setBackground(Color.blue);

        SignUpInfoJP.setBounds(240,0,740,450);
        SignUpInfoJPOverAll.setBounds(200,0,500,800);
        SignUpInfoJP1.setBounds(0,70,500,70);
        SignUpInfoJP2.setBounds(0,140,500,70);
        SignUpInfoJP3.setBounds(0,210,500,70);
        SignUpInfoJP4.setBounds(0,280,500,70);
        SignUpInfoJP5.setBounds(0,350,500,70);
        SignUpInfoJP6.setBounds(0,420,500,70);
        SignUpInfoJP7.setBounds(0,490,500,70);


        JScrollBar SignUpInfoScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0,20);
        SignUpInfoScrollBar.setBounds(720,0,20,450);
        // 监听滚动条的数值变化事件
        SignUpInfoScrollBar.addAdjustmentListener(e -> {
            int value = e.getValue();
            SignUpInfoJPOverAll.setLocation(SignUpInfoJPOverAll.getX(), -value * 20); // 以标签高度为单位滚动
        });



        SignUpInfoJP.add(SignUpInfoJPOverAll);
        SignUpInfoJP.add(SignUpInfoScrollBar);

        SignUpInfoJPOverAll.add(SignUpInfoJP1);
        SignUpInfoJPOverAll.add(SignUpInfoJP2);
        SignUpInfoJPOverAll.add(SignUpInfoJP3);
        SignUpInfoJPOverAll.add(SignUpInfoJP4);
        SignUpInfoJPOverAll.add(SignUpInfoJP5);
        SignUpInfoJPOverAll.add(SignUpInfoJP6);
        SignUpInfoJPOverAll.add(SignUpInfoJP7);

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
    public void ReviseInfoJPInit(){
        ReviseInfoGender.addItem("-请选择-");
        ReviseInfoGender.addItem("男");
        ReviseInfoGender.addItem("女");

        ReviseInfoJP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ReviseInfoJP2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ReviseInfoJP3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ReviseInfoJP4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ReviseInfoJP5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ReviseInfoJP6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ReviseInfoJP7 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ReviseInfoNameJL = new JLabel("姓    名：");
        ReviseInfoGenderJL = new JLabel("性    别：");
        ReviseInfoAgeJL = new JLabel("年    龄：");
        ReviseInfoSchoolidJL = new JLabel("学    号：");
        ReviseInfoPhoneJL = new JLabel("电    话：");
        ReviseInfoRankJL = new JLabel("考试等级：");
        ReviseInfoSchoolJL = new JLabel("学    校：");
        ReviseInfoButtonRevise = new JButton("修改");
        ReviseInfoButtonClear = new JButton("复原");

        ReviseInfoNameJTF = new JTextField(20);
        ReviseInfoAgeJTF = new JTextField(20);
        ReviseInfoSchoolidJTF = new JTextField(20);
        ReviseInfoPhoneJTF = new JTextField(20);
        ReviseInfoSchoolJTF = new JTextField(20);
        ReviseInfoRankJTF = new JTextField(20);

        ReviseInfoNameJL.setFont(styles.SmallJLFont);
        ReviseInfoGenderJL.setFont(styles.SmallJLFont);
        ReviseInfoAgeJL.setFont(styles.SmallJLFont);
        ReviseInfoSchoolidJL.setFont(styles.SmallJLFont);
        ReviseInfoPhoneJL.setFont(styles.SmallJLFont);
        ReviseInfoRankJL.setFont(styles.SmallJLFont);
        ReviseInfoSchoolJL.setFont(styles.SmallJLFont);


        ReviseInfoNameJTF.setFont(styles.SmallJLFont);
        ReviseInfoGender.setFont(styles.SmallJLFont);
        ReviseInfoRankJTF.setFont(styles.SmallJLFont);
        ReviseInfoAgeJTF.setFont(styles.SmallJLFont);
        ReviseInfoSchoolidJTF.setFont(styles.SmallJLFont);
        ReviseInfoPhoneJTF.setFont(styles.SmallJLFont);
        ReviseInfoSchoolJTF.setFont(styles.SmallJLFont);
        ReviseInfoButtonRevise.setFont(styles.SmallJLFont);
        ReviseInfoButtonClear.setFont(styles.SmallJLFont);

        ReviseInfoButtonJP = new JPanel();
        ReviseInfoJP = new JPanel(null);
        ReviseInfoJPOverAll = new JPanel(null);
        ReviseInfoButtonJP.setBackground(Color.blue);
        ReviseInfoButtonJP.setBounds(300,500,600,180);
        ReviseInfoJP.setBounds(240,0,740,450);
        ReviseInfoJPOverAll.setBounds(200,0,500,800);
        ReviseInfoJP1.setBounds(0,70,500,70);
        ReviseInfoJP2.setBounds(0,140,500,70);
        ReviseInfoJP3.setBounds(0,210,500,70);
        ReviseInfoJP4.setBounds(0,280,500,70);
        ReviseInfoJP5.setBounds(0,350,500,70);
        ReviseInfoJP6.setBounds(0,420,500,70);
        ReviseInfoJP7.setBounds(0,490,500,70);

        JScrollBar ReviseInfoScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0,20);
        ReviseInfoScrollBar.setBounds(720,0,20,450);
        // 监听滚动条的数值变化事件
        ReviseInfoScrollBar.addAdjustmentListener(e -> {
            int value = e.getValue();
            ReviseInfoJPOverAll.setLocation(ReviseInfoJPOverAll.getX(), -value * 20); // 以标签高度为单位滚动
        });


        ReviseInfoJP.add(ReviseInfoJPOverAll);
        ReviseInfoJP.add(ReviseInfoScrollBar);

        ReviseInfoJPOverAll.add(ReviseInfoJP1);
        ReviseInfoJPOverAll.add(ReviseInfoJP2);
        ReviseInfoJPOverAll.add(ReviseInfoJP3);
        ReviseInfoJPOverAll.add(ReviseInfoJP4);
        ReviseInfoJPOverAll.add(ReviseInfoJP5);
        ReviseInfoJPOverAll.add(ReviseInfoJP6);
        ReviseInfoJPOverAll.add(ReviseInfoJP7);

        ReviseInfoJP1.add(ReviseInfoNameJL);
        ReviseInfoJP1.add(ReviseInfoNameJTF);
        ReviseInfoJP2.add(ReviseInfoGenderJL);
        ReviseInfoJP2.add(ReviseInfoGender);
        ReviseInfoJP3.add(ReviseInfoAgeJL);
        ReviseInfoJP3.add(ReviseInfoAgeJTF);
        ReviseInfoJP4.add(ReviseInfoSchoolidJL);
        ReviseInfoJP4.add(ReviseInfoSchoolidJTF);
        ReviseInfoJP5.add(ReviseInfoPhoneJL);
        ReviseInfoJP5.add(ReviseInfoPhoneJTF);
        ReviseInfoJP6.add(ReviseInfoRankJL);
        ReviseInfoJP6.add(ReviseInfoRankJTF);
        ReviseInfoJP7.add(ReviseInfoSchoolJL);
        ReviseInfoJP7.add(ReviseInfoSchoolJTF);


        ReviseInfoButtonRevise.addActionListener(this);
        ReviseInfoButtonClear.addActionListener(this);
        ReviseInfoButtonRevise.setActionCommand("Revise");
        ReviseInfoButtonClear.setActionCommand("ReviseClear");


        UserMenuReviseInfoJP.add(ReviseInfoJP);
        ReviseInfoButtonJP.add(ReviseInfoButtonRevise);
        ReviseInfoButtonJP.add(ReviseInfoButtonClear);

        FlowLayout  SignUpButtonGap=new FlowLayout();
        SignUpButtonGap.setHgap(120);//水平间距
        ReviseInfoButtonJP.setLayout(SignUpButtonGap);
        UserMenuReviseInfoJP.add(ReviseInfoButtonJP);

    }
    public void  FirstJPInit(){
        JPanel FirstJP1 = new JPanel();
        FirstJP1.setBounds(0,0,1200,660);
        FirstJP1.setLayout(null);
        JLabel jLabel = new JLabel();
        Icon FirstIcon = new ImageIcon("src\\main\\resources\\Pictures\\First.png");
        jLabel.setIcon(FirstIcon);
        jLabel.setBounds(0,-40,1200,660);
        FirstJP1.add(jLabel);
        UserMenuFirstJP.add(FirstJP1);
    }
    public void FirstJP(){
        UserMenuFirstJP.setVisible(true);
        UserMenuSignUpJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);
    }
    private void UserInfoUpdate(){
        try {
            user.setUserInfo(ncreService.GetUserInfoByAccount(user.getAccount().getAccount()));
            UserMenuAccountJL2.setText(user.getAccount().getAccount());
            SignUpJPUpdate();
            ReviseInfoJPUpdate();
        }catch (NullPointerException e){
            SignUpJPUpdate();
            ReviseInfoJPUpdate();
        }
    }
    private void SignUpJPUpdate(){
        if(user.getUserInfo() != null) {
            if (user.getUserInfo().getName() != null) {
                SignUpNameJTF.setText(user.getUserInfo().getName());
                SignUpNameJTF.setEnabled(false);
            }
            if (user.getUserInfo().getAge() != null) {
                SignUpAgeJTF.setText(String.valueOf(user.getUserInfo().getAge()));
                SignUpAgeJTF.setEnabled(false);
            }
            if (user.getUserInfo().getGender() != null) {
                SignUpGender.setSelectedItem(user.getUserInfo().getGender());
                SignUpGender.setEnabled(false);
            }
            if (user.getUserInfo().getSchoolid() != null) {
                SignUpSchoolidJTF.setText(String.valueOf(user.getUserInfo().getSchoolid()));
                SignUpSchoolidJTF.setEnabled(false);
            }
            if (user.getUserInfo().getPhone() != null) {
                SignUpPhoneJTF.setText(String.valueOf(user.getUserInfo().getPhone()));
                SignUpPhoneJTF.setEnabled(false);
            }
            if (user.getUserInfo().getSchool() != null) {
                SignUpSchoolJTF.setText(String.valueOf(user.getUserInfo().getSchool()));
                SignUpSchoolJTF.setEnabled(false);
            }
            if (user.getUserInfo().getExamerank() != null) {
                if (Objects.equals(user.getUserInfo().getExamerank(), "无")) {
                } else {
                    SignUpRank.setSelectedItem(user.getUserInfo().getExamerank());
                    SignUpRank.setEnabled(false);
                }
            }
        }else {

            SignUpNameJTF.setText("");
            SignUpAgeJTF.setText("");
            SignUpGender.setSelectedItem("-请选择-");
            SignUpSchoolidJTF.setText("");
            SignUpPhoneJTF.setText("");
            SignUpSchoolJTF.setText("");
            SignUpRank.setSelectedItem("-请选择-");
            SignUpNameJTF.setEnabled(true);
            SignUpAgeJTF.setEnabled(true);
            SignUpGender.setEnabled(true);
            SignUpSchoolidJTF.setEnabled(true);
            SignUpPhoneJTF.setEnabled(true);
            SignUpSchoolJTF.setEnabled(true);
            SignUpRank.setEnabled(true);
        }
    }
    public void SignUpJP(){
        UserInfoUpdate();
        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(true);
        UserMenuReviseInfoJP.setVisible(false);
    }
    public void FindInfoJP(){
        UserInfoUpdate();
        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(false);
    }
    private void ReviseInfoJPUpdate(){
        if(user.getUserInfo() != null) {
            if (user.getUserInfo().getName() != null) {
                ReviseInfoNameJTF.setText(user.getUserInfo().getName());
            }
            if (user.getUserInfo().getAge() != null) {
                ReviseInfoAgeJTF.setText(String.valueOf(user.getUserInfo().getAge()));
            }
            if (user.getUserInfo().getGender() != null) {
                ReviseInfoGender.setSelectedItem(user.getUserInfo().getGender());
            } else {
                ReviseInfoGender.setSelectedItem("-请选择-");
            }
            if (user.getUserInfo().getSchoolid() != null) {
                ReviseInfoSchoolidJTF.setText(String.valueOf(user.getUserInfo().getSchoolid()));
            }
            if (user.getUserInfo().getPhone() != null) {
                ReviseInfoPhoneJTF.setText(String.valueOf(user.getUserInfo().getPhone()));
            }
            if (user.getUserInfo().getSchool() != null) {
                ReviseInfoSchoolJTF.setText(String.valueOf(user.getUserInfo().getSchool()));
            }
            if (user.getUserInfo().getExamerank() != null) {
                ReviseInfoRankJTF.setText(user.getUserInfo().getExamerank());
                ReviseInfoRankJTF.setEnabled(false);
            } else {
                ReviseInfoRankJTF.setText("无");
                ReviseInfoRankJTF.setEnabled(false);
            }
        }else{
            ReviseInfoNameJTF.setText("");
            ReviseInfoAgeJTF.setText("");
            ReviseInfoGender.setSelectedItem("-请选择-");
            ReviseInfoSchoolidJTF.setText("");
            ReviseInfoPhoneJTF.setText("");
            ReviseInfoSchoolJTF.setText("");
            ReviseInfoRankJTF.setText("无");
            ReviseInfoRankJTF.setEnabled(false);
        }
    }
    public void ReviseInfoJP(){
        UserInfoUpdate();
        UserMenuFirstJP.setVisible(false);
        UserMenuSignUpJP.setVisible(false);
        UserMenuReviseInfoJP.setVisible(true);
    }
    public void LogOffJP(){
        user.setAccount(null);
        user.setUserInfo(null);
        UserInfoUpdate();
        SignUpJP();
        ncre.Load();
    }
    public void LogOut(){
        int userOption =  JOptionPane.showConfirmDialog(null,"该操作无法恢复，请确认是否继续删除账户？","提示",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
        //如果用户选择的是OK
        if (userOption == JOptionPane.OK_OPTION) {
            ncreService.DeleteUserInfoAccountByAccount(user.getAccount());
            LogOffJP();
        }
    }
    public void SignUp(){
        int userOption =  JOptionPane.showConfirmDialog(null,"您要报名吗？","提示",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
        //如果用户选择的是OK
        if (userOption == JOptionPane.OK_OPTION) {
            if (Objects.equals(SignUpNameJTF.getText(), "") || Objects.equals(SignUpAgeJTF.getText(), "") ||
                    Objects.equals(SignUpSchoolidJTF.getText(), "") || Objects.equals(SignUpPhoneJTF.getText(), "") ||
                    Objects.equals(SignUpSchoolJTF.getText(), "") || SignUpGender.getSelectedItem() == "-请选择-" ||
                    SignUpRank.getSelectedItem() == "-请选择-") {
                JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
            } else {
                if (user.getUserInfo() != null && (user.getUserInfo().getExamerank() != null) && !Objects.equals(user.getUserInfo().getExamerank(), "无")) {
                    JOptionPane.showMessageDialog(null, "请勿重复报名！", "消息提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setAccount(user.getAccount().getAccount());
                    userInfo.setName(SignUpNameJTF.getText());
                    userInfo.setGender((String) SignUpGender.getSelectedItem());
                    userInfo.setAge(Integer.valueOf(SignUpAgeJTF.getText()));
                    userInfo.setSchoolid(SignUpSchoolidJTF.getText());
                    userInfo.setSchool(SignUpSchoolJTF.getText());
                    userInfo.setExamerank((String) SignUpRank.getSelectedItem());
                    userInfo.setPhone(SignUpPhoneJTF.getText());
                    if(ncreService.SaveUserInfo(userInfo)) {
                        JOptionPane.showMessageDialog(null, "报名成功！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        SignUpJP();
                    }
                }
            }
        }
    }
    public void Revise() {
        try {
            if (Objects.equals(ReviseInfoNameJTF.getText(), "") || Objects.equals(ReviseInfoAgeJTF.getText(), "") ||
                    Objects.equals(ReviseInfoSchoolidJTF.getText(), "") || Objects.equals(ReviseInfoPhoneJTF.getText(), "") ||
                    Objects.equals(ReviseInfoSchoolJTF.getText(), "") || ReviseInfoGender.getSelectedItem() == "-请选择-" ) {
                JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
            }else {
                Integer TAge = Integer.valueOf(ReviseInfoAgeJTF.getText());
                String TName = ReviseInfoNameJTF.getText();
                String TGender = (String) ReviseInfoGender.getSelectedItem();
                String TSchoolid = ReviseInfoSchoolidJTF.getText();
                String TSchool = ReviseInfoSchoolJTF.getText();
                String TRank = ReviseInfoRankJTF.getText();
                String TPhone = ReviseInfoPhoneJTF.getText();
                UserInfo userInfo = new UserInfo();
                userInfo.setAccount(user.getAccount().getAccount());
                userInfo.setName(TName);
                userInfo.setGender(TGender);
                userInfo.setAge(TAge);
                userInfo.setSchoolid(TSchoolid);
                userInfo.setSchool(TSchool);
                userInfo.setExamerank(TRank);
                userInfo.setPhone(TPhone);
                if (ncreService.SaveUserInfo(userInfo)) {
                    JOptionPane.showMessageDialog(null, "修改成功！", "消息提示", JOptionPane.WARNING_MESSAGE);
                    ReviseInfoJP();
                }
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.WARNING_MESSAGE);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "FirstJP")){
            this.FirstJP();
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
            int userOption =  JOptionPane.showConfirmDialog(null,"您要登出账户吗？","提示",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
            //如果用户选择的是OK
            if (userOption == JOptionPane.OK_OPTION) {
                LogOffJP();
            }
        }
        else if(Objects.equals(e.getActionCommand(), "LogOutJP")){
            this.LogOut();
        }
        else if(Objects.equals(e.getActionCommand(), "SignUp")){
            this.SignUp();
        }
        else if(Objects.equals(e.getActionCommand(), "SignUpClear")){
            this.SignUpJP();
        }
        else if(Objects.equals(e.getActionCommand(),"Revise")){
            this.Revise();
        }
        else if(Objects.equals(e.getActionCommand(),"ReviseClear")){
            this.ReviseInfoJP();
        }

    }
}
