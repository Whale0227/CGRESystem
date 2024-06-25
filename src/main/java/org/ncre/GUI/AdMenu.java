package org.ncre.GUI;
import org.ncre.data.domain.User;
import org.ncre.data.domain.UserAccount;
import org.ncre.data.domain.UserInfo;
import org.ncre.service.NCREService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class AdMenu implements ActionListener {
    private JPanel AdLoginJP,PictureJP,AdLoginButtonJP,AdMenuAccountJP,
            AddUserInfoJP, DeleteUserInfoJP, ReviseUserInfoJP, FindUserInfoJP;
    private JButton AddUserInfoButton,DeleteUserInfoButton,
            ReviseUserInoButton,FindUserInfoButton,AdLogoffButton;
    private Styles styles;
    private JLabel AdMenuAccountJL1;
    private JLabel AddUserInfoTitle;
    private JPanel AddUserInfoTitleJP, AddUserInfoShowJP,AddUserInfoButtonJP;
    private JButton AddUserInfoAdd,AddUserInfoAddLine,AddUserInfoClear;
    private JTable AddUserInfoTable,DeleteUserInfoTable,ReviseUserInfoTable;
    private JPanel DeleteUserInfoTitleJP,DeleteUserInfoFindJP,DeleteUserInfoShowJP,DeleteUserInfoButtonJP;
    private JLabel DeleteUserInfoTitle,DeleteUserInfoShowAccountJL;
    private JTextField DeleteUserInfoShowAccountJTF;
    private JButton DeleteUserInfoFindButton,DeleteUserInfoDeleteButton,DeleteUserInfoClearButton;
    private JPanel ReviseUserInfoTitleJP,ReviseUserInfoFindJP,ReviseUserInfoShowJP,ReviseUserInfoButtonJP;
    private JLabel ReviseUserInfoTitle,ReviseUserInfoShowAccountJL;
    private JTextField ReviseUserInfoShowAccountJTF;
    private JButton ReviseUserInfoFindButton,ReviseUserInfoReviseButton,ReviseUserInfoClearButton;

    private DefaultTableModel AddUserInfomodel,DeleteUserInfomodel,ReviseUserInfomodel;
    private NCREService ncreService;
    private JLabel Picture;
    String[][] datas = {};
    String[] titles = { "序号","账户","密码","姓名", "性别","年龄","学号","手机号","学校" };
    private final Icon icon;  // 资源图片
    private NCRE ncre;
    private List<User> users;

    AdMenu(Styles styles, NCREService ncreService,NCRE ncre){
        this.ncreService = ncreService;
        this.ncre = ncre;
        users = new ArrayList<>();
        this.styles = styles;
        AdLoginJP = new JPanel(null);
        Picture = new JLabel();
        PictureJP = new JPanel(null);
        icon = new ImageIcon("src\\main\\resources\\Pictures\\NCRE.jpg");
        AdMenuAccountJL1 = new JLabel("账户：管理员");
        AddUserInfoButton = new JButton("添加用户信息");
        DeleteUserInfoButton = new JButton("删除用户信息");
        ReviseUserInoButton = new JButton("修改用户信息");
        FindUserInfoButton = new JButton("查找用户信息");
        AdLogoffButton = new JButton("退出登录");
        AdLoginButtonJP = new JPanel();
        AddUserInfoJP = new JPanel(null);
        DeleteUserInfoJP = new JPanel(null);
        ReviseUserInfoJP = new JPanel(null);
        FindUserInfoJP = new JPanel(null);
        AdMenuAccountJP = new JPanel(new FlowLayout(FlowLayout.LEFT));
    }

    public JPanel Init(){

        AdLoginJP.setBounds(0,0,1200,800);
        PictureJP.setBounds(0,0,1200,70);
        Picture.setBounds(0,0,400,70);
        AdLoginButtonJP.setBounds(0,150,200,650);
        AdMenuAccountJP.setBounds(800,40,400,30); // 表头、账号

        AddUserInfoJP.setBounds(200,70,1000,730);
        DeleteUserInfoJP.setBounds(200,70,1000,730);
        ReviseUserInfoJP.setBounds(200,70,1000,730);
        FindUserInfoJP.setBounds(200,70,1000,730);

        AdMenuAccountJP.setBackground(new Color(65,91,128));
        AdMenuAccountJL1.setForeground(Color.white);

        PictureJP.setBackground(Color.white);
        AdLoginJP.setBackground(Color.yellow);
        AdLoginButtonJP.setBackground(Color.red);

        AddUserInfoJP.setBackground(Color.yellow);
        DeleteUserInfoJP.setBackground(Color.blue);
        ReviseUserInfoJP.setBackground(Color.red);
        FindUserInfoJP.setBackground(Color.green);



        AdMenuAccountJP.setFont(styles.SmallJLFont);
        AdMenuAccountJL1.setFont(styles.SmallJLFont);
        AddUserInfoButton.setFont(styles.ButtonFont);
        DeleteUserInfoButton.setFont(styles.ButtonFont);
        ReviseUserInoButton.setFont(styles.ButtonFont);
        FindUserInfoButton.setFont(styles.ButtonFont);
        AdLogoffButton.setFont(styles.ButtonFont);


        AdMenuAccountJP.add(AdMenuAccountJL1);
        AdLoginButtonJP.add(AddUserInfoButton);
        AdLoginButtonJP.add(DeleteUserInfoButton);
        AdLoginButtonJP.add(ReviseUserInoButton);
        AdLoginButtonJP.add(FindUserInfoButton);
        AdLoginButtonJP.add(AdLogoffButton);

        AddUserInfoButton.addActionListener(this);
        DeleteUserInfoButton.addActionListener(this);
        ReviseUserInoButton.addActionListener(this);
        FindUserInfoButton.addActionListener(this);
        AdLogoffButton.addActionListener(this);
        AddUserInfoButton.setActionCommand("AddUserInfoJP");
        DeleteUserInfoButton.setActionCommand("DeleteUserInfoJP");
        ReviseUserInoButton.setActionCommand("ReviseUserInfoJP");
        FindUserInfoButton.setActionCommand("FindUserInfoJP");
        AdLogoffButton.setActionCommand("AdLogoffButton");

        FlowLayout AdMenuButtonGap=new FlowLayout();
        AdMenuButtonGap.setHgap(100);   // 水平间距
        AdMenuButtonGap.setVgap(80);    // 垂直间距
        AdLoginButtonJP.setLayout(AdMenuButtonGap);

        Picture.setIcon(icon);
        PictureJP.add(Picture);
        AdLoginJP.add(PictureJP);
        AdLoginJP.add(AdLoginButtonJP);
        AdLoginJP.add(AddUserInfoJP);
        AdLoginJP.add(DeleteUserInfoJP);
        AdLoginJP.add(ReviseUserInfoJP);
        AdLoginJP.add(FindUserInfoJP);
        PictureJP.add(AdMenuAccountJP);
        AddUserInfoJPInit();
        DeleteUserInfoJPInit();
        ReviseUserInfoJPInit();
        FindUserInfoJPInit();
        AddUserInfoJP();
        return AdLoginJP;
    }

    private void AddUserInfoJPInit(){

        AddUserInfomodel = new DefaultTableModel(datas, titles);
        AddUserInfoTable = new JTable(AddUserInfomodel);
        AddUserInfoTable = new JTable(AddUserInfomodel){
            public boolean isCellEditable(int row, int column)
            {   // 设置第一列不可编辑
                if(column == 0){
                    return false;
                }
                return true;
            }
        };

        AddUserInfoTitle = new JLabel("添加用户信息");
        AddUserInfoTitleJP = new JPanel();
        AddUserInfoShowJP = new JPanel();
        AddUserInfoButtonJP = new JPanel();
        AddUserInfoAdd = new JButton("添加");
        AddUserInfoAddLine = new JButton("添加一行");
        AddUserInfoClear = new JButton("清除");
        AddUserInfoShowJP.setBounds(100,100,800,450);
        AddUserInfoTitleJP.setBounds(0,0,1000,100);
        AddUserInfoButtonJP.setBounds(0,600,1000,250);

        AddUserInfoTitle.setFont(styles.TitleFont);
        AddUserInfoAdd.setFont(styles.ButtonFont);
        AddUserInfoClear.setFont(styles.ButtonFont);
        AddUserInfoAddLine.setFont(styles.ButtonFont);
        AddUserInfoTable.setFont(styles.SmallJLFont);      // 字体样式

        AddUserInfoAdd.addActionListener(this);
        AddUserInfoAddLine.addActionListener(this);
        AddUserInfoClear.addActionListener(this);
        AddUserInfoAdd.setActionCommand("AddUserInfoAdd");
        AddUserInfoAddLine.setActionCommand("AddUserInfoAddLine");
        AddUserInfoClear.setActionCommand("AddUserInfoClear");

        AddUserInfoButtonJP.add(AddUserInfoAdd);
        AddUserInfoButtonJP.add(AddUserInfoAddLine);
        AddUserInfoButtonJP.add(AddUserInfoClear);
        AddUserInfoTitleJP.add(AddUserInfoTitle);
        AddUserInfoJP.add(AddUserInfoShowJP);
        AddUserInfoJP.add(AddUserInfoTitleJP);
        AddUserInfoJP.add(AddUserInfoButtonJP);

        AddUserInfoTable.getTableHeader().setFont(styles.SmallJLFont);  // 设置表头名称字体样式
        AddUserInfoTable.setPreferredScrollableViewportSize(new Dimension(750, 400));
        AddUserInfoTable.setRowHeight(30); // 设置行高
        //AddUserInfoTable.setEnabled(false); // 设置不可编辑

        RowSorter sorter = new TableRowSorter(AddUserInfomodel);
        AddUserInfoTable.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(AddUserInfoTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 创建滚动条组件，默认滚动条始终出现，初始化列表组件
        AddUserInfoShowJP.add(scrollPane);

        FlowLayout AddUserInfoButtonGap=new FlowLayout();
        AddUserInfoButtonGap.setHgap(150);//水平间距
        AddUserInfoButtonJP.setLayout(AddUserInfoButtonGap);


    }
    private void DeleteUserInfoJPInit(){


        DeleteUserInfoTitleJP = new JPanel();
        DeleteUserInfoFindJP = new JPanel();
        DeleteUserInfoShowJP = new JPanel();
        DeleteUserInfoButtonJP = new JPanel();
        DeleteUserInfoShowAccountJL = new JLabel("账户：");
        DeleteUserInfoShowAccountJTF = new JTextField(20);
        DeleteUserInfoFindButton = new JButton("查找");
        DeleteUserInfoDeleteButton = new JButton("删除");
        DeleteUserInfoClearButton = new JButton("清除");
        DeleteUserInfoTitle = new JLabel("删除用户信息");


        DeleteUserInfoTitle.setFont(styles.TitleFont);
        DeleteUserInfoShowAccountJL.setFont(styles.JLFont);
        DeleteUserInfoShowAccountJTF.setFont(styles.JLFont);
        DeleteUserInfoFindButton.setFont(styles.ButtonFont);
        DeleteUserInfoDeleteButton.setFont(styles.ButtonFont);
        DeleteUserInfoClearButton.setFont(styles.ButtonFont);

        DeleteUserInfoTitleJP.setBounds(0,0,1000,100);
        DeleteUserInfoFindJP.setBounds(0,100,1000,80);
        DeleteUserInfoShowJP.setBounds(0,180,1000,420);
        DeleteUserInfoButtonJP.setBounds(0,600,1000,250);

        DeleteUserInfoFindButton.addActionListener(this);
        DeleteUserInfoDeleteButton.addActionListener(this);
        DeleteUserInfoClearButton.addActionListener(this);
        DeleteUserInfoFindButton.setActionCommand("DeleteUserInfoFindButton");
        DeleteUserInfoDeleteButton.setActionCommand("DeleteUserInfoDeleteButton");
        DeleteUserInfoClearButton.setActionCommand("DeleteUserInfoClearButton");

        DeleteUserInfoJP.add(DeleteUserInfoTitleJP);
        DeleteUserInfoJP.add(DeleteUserInfoShowJP);
        DeleteUserInfoJP.add(DeleteUserInfoFindJP);
        DeleteUserInfoJP.add(DeleteUserInfoButtonJP);
        DeleteUserInfoFindJP.add(DeleteUserInfoShowAccountJL);
        DeleteUserInfoFindJP.add(DeleteUserInfoShowAccountJTF);
        DeleteUserInfoFindJP.add(DeleteUserInfoFindButton);
        DeleteUserInfoButtonJP.add(DeleteUserInfoDeleteButton);
        DeleteUserInfoButtonJP.add(DeleteUserInfoClearButton);
        DeleteUserInfoTitleJP.add(DeleteUserInfoTitle);

        FlowLayout DeleteUserInfoButtonGap=new FlowLayout();
        DeleteUserInfoButtonGap.setHgap(150);//水平间距
        DeleteUserInfoButtonJP.setLayout(DeleteUserInfoButtonGap);

        DeleteUserInfomodel = new DefaultTableModel(datas, titles);
        DeleteUserInfoTable = new JTable(DeleteUserInfomodel);

        DeleteUserInfoTable.getTableHeader().setFont(styles.SmallJLFont);  // 设置表头名称字体样式
        DeleteUserInfoTable.setPreferredScrollableViewportSize(new Dimension(600, 350));
        DeleteUserInfoTable.setRowHeight(30); // 设置行高
        DeleteUserInfoTable.setEnabled(false); // 设置不可编辑

        RowSorter sorter = new TableRowSorter(DeleteUserInfomodel);
        DeleteUserInfoTable.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(DeleteUserInfoTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);// 创建滚动条组件，默认滚动条始终出现，初始化列表组件
        DeleteUserInfoShowJP.add(scrollPane);
    }
    private void ReviseUserInfoJPInit(){
        ReviseUserInfoTitleJP = new JPanel();
        ReviseUserInfoFindJP = new JPanel();
        ReviseUserInfoShowJP = new JPanel();
        ReviseUserInfoButtonJP = new JPanel();
        ReviseUserInfoTitle = new JLabel("修改用户信息");
        ReviseUserInfoShowAccountJL = new JLabel("账户：");
        ReviseUserInfoShowAccountJTF = new JTextField(20);
        ReviseUserInfoFindButton = new JButton("查找");
        ReviseUserInfoReviseButton = new JButton("修改");
        ReviseUserInfoClearButton = new JButton("清除");

        ReviseUserInfoTitleJP.setBounds(0,0,1000,100);
        ReviseUserInfoFindJP.setBounds(0,100,1000,80);
        ReviseUserInfoShowJP.setBounds(0,180,1000,420);
        ReviseUserInfoButtonJP.setBounds(0,600,1000,250);

        ReviseUserInfoTitle.setFont(styles.TitleFont);
        ReviseUserInfoShowAccountJL.setFont(styles.JLFont);
        ReviseUserInfoShowAccountJTF.setFont(styles.JLFont);
        ReviseUserInfoFindButton.setFont(styles.ButtonFont);
        ReviseUserInfoReviseButton.setFont(styles.ButtonFont);
        ReviseUserInfoClearButton.setFont(styles.ButtonFont);

        ReviseUserInfoFindButton.addActionListener(this);
        ReviseUserInfoReviseButton.addActionListener(this);
        ReviseUserInfoClearButton.addActionListener(this);
        ReviseUserInfoFindButton.setActionCommand("ReviseUserInfoFindButton");
        ReviseUserInfoReviseButton.setActionCommand("ReviseUserInfoReviseButton");
        ReviseUserInfoClearButton.setActionCommand("ReviseUserInfoClearButton");


        ReviseUserInfoJP.add(ReviseUserInfoTitleJP);
        ReviseUserInfoTitleJP.add(ReviseUserInfoTitle);

        ReviseUserInfoJP.add(ReviseUserInfoShowJP);
        ReviseUserInfoJP.add(ReviseUserInfoFindJP);
        ReviseUserInfoJP.add(ReviseUserInfoButtonJP);
        ReviseUserInfoFindJP.add(ReviseUserInfoShowAccountJL);
        ReviseUserInfoFindJP.add(ReviseUserInfoShowAccountJTF);
        ReviseUserInfoFindJP.add(ReviseUserInfoFindButton);
        ReviseUserInfoButtonJP.add(ReviseUserInfoReviseButton);
        ReviseUserInfoButtonJP.add(ReviseUserInfoClearButton);
        ReviseUserInfoTitleJP.add(ReviseUserInfoTitle);

        FlowLayout ReviseUserInfoButtonGap=new FlowLayout();
        ReviseUserInfoButtonGap.setHgap(150);//水平间距
        ReviseUserInfoButtonJP.setLayout(ReviseUserInfoButtonGap);

        ReviseUserInfomodel = new DefaultTableModel(datas, titles);
        ReviseUserInfoTable = new JTable(ReviseUserInfomodel){
            public boolean isCellEditable(int row, int column)
            {   // 设置第一列和第二列不可编辑
                if(column == 0||column == 1){
                    return false;
                }
                return true;
            }
        };
        ReviseUserInfoTable.getTableHeader().setFont(styles.SmallJLFont);  // 设置表头名称字体样式
        ReviseUserInfoTable.setPreferredScrollableViewportSize(new Dimension(600, 350));
        ReviseUserInfoTable.setRowHeight(30); // 设置行高
        //ReviseUserInfoTable.setEnabled(false); // 设置不可编辑
        RowSorter sorter = new TableRowSorter(ReviseUserInfomodel);
        ReviseUserInfoTable.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(ReviseUserInfoTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);// 创建滚动条组件
        ReviseUserInfoShowJP.add(scrollPane);

    }
    private void FindUserInfoJPInit(){}
    private void AddUserInfoJP(){
        users = new ArrayList<>();
        AddUserInfoJP.setVisible(true);
        DeleteUserInfoJP.setVisible(false);
        ReviseUserInfoJP.setVisible(false);
        FindUserInfoJP.setVisible(false);
    }
    private void DeleteUserInfoJP(){
        users = new ArrayList<>();
        AddUserInfoJP.setVisible(false);
        DeleteUserInfoJP.setVisible(true);
        ReviseUserInfoJP.setVisible(false);
        FindUserInfoJP.setVisible(false);
    }
    private void ReviseUserInfoJP(){
        users = new ArrayList<>();
        AddUserInfoJP.setVisible(false);
        DeleteUserInfoJP.setVisible(false);
        ReviseUserInfoJP.setVisible(true);
        FindUserInfoJP.setVisible(false);
    }
    private void FindUserInfoJP(){
        users = new ArrayList<>();
        AddUserInfoJP.setVisible(false);
        DeleteUserInfoJP.setVisible(false);
        ReviseUserInfoJP.setVisible(false);
        FindUserInfoJP.setVisible(true);
    }
    private void AdLogoffButton(){
        users = new ArrayList<>();
        int userOption =  JOptionPane.showConfirmDialog(null,"确定退出账户？，请确认是否继续删除账户？","提示",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
        //如果用户选择的是OK
        if (userOption == JOptionPane.OK_OPTION) {
            ncre.Load();
            // TODO 清除管理员登录状态
            users = new ArrayList<>();
        }
    }
    private void AddUserInfoAddLine(){
        AddUserInfomodel.getRowCount();
        AddUserInfomodel.addRow(new String[] {String.valueOf(AddUserInfomodel.getRowCount()+1)});
    }
    private void AddUserInfoAdd() {
        Vector<Vector> a = AddUserInfomodel.getDataVector();
        for (int i = 0; i < a.size(); i++) {
            User Tuser = new User();
            UserAccount account = new UserAccount();
            account.setAccount((String) a.get(i).get(1));
            account.setPassword((String) a.get(i).get(2));
            UserInfo info = new UserInfo();
            info.setAccount((String) a.get(i).get(1));
            info.setName((String) a.get(i).get(3));
            info.setGender((String) a.get(i).get(4));
            if (a.get(i).get(5) != null && !a.get(i).get(5) .equals("")){
                info.setAge((int) Long.parseLong((String) a.get(i).get(5)));
            }
            info.setSchoolid((String) a.get(i).get(6));
            info.setPhone((String) a.get(i).get(7));
            info.setSchool((String) a.get(i).get(8));
            Tuser.setAccount(account);
            Tuser.setUserInfo(info);
            users.add(Tuser);
        }
        if (ncreService.AddUserInfos(users)) {
            AddUserInfomodel.setRowCount(0);
            JOptionPane.showMessageDialog(null, "账号已添加！", "消息提示", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "信息填写有误，请检查！", "消息提示", JOptionPane.WARNING_MESSAGE);
        }

    }
    private void AddUserInfoClear(){
        users = new ArrayList<>();
        AddUserInfomodel.setRowCount(0);
    }
    private void DeleteUserInfoFindButton(){
        DeleteUserInfomodel.setRowCount(0);
        String TAccount = DeleteUserInfoShowAccountJTF.getText();
        if(Objects.equals(TAccount, "")){
            JOptionPane.showMessageDialog(null, "请输入需要查找的账户！","消息提示",JOptionPane.WARNING_MESSAGE);

        }else{
            UserAccount account = ncreService.GetUserAPByAccount(TAccount);
            UserInfo userInfo = ncreService.GetUserInfoByAccount(TAccount);
            if(account == null){
                JOptionPane.showMessageDialog(null, "未查找到该账户信息！","消息提示",JOptionPane.WARNING_MESSAGE);
            }else {
                User Tuser = new User();
                Tuser.setAccount(account);
                Tuser.setUserInfo(userInfo);
                users.add(Tuser);
                DeleteUserInfomodel.addRow(new String[]{
                    "1",account.getAccount(),account.getPassword(),userInfo.getName(),
                        userInfo.getGender(), String.valueOf(userInfo.getAge()),userInfo.getSchoolid(),
                        userInfo.getPhone(),userInfo.getSchool()
                });
            }
        }
    }
    private void DeleteUserInfoDeleteButton(){
        ncreService.DeleteUserInfoAccountByAccount(users.get(0).getAccount());
        JOptionPane.showMessageDialog(null, "删除成功！","消息提示",JOptionPane.WARNING_MESSAGE);
        DeleteUserInfoClearButton();
        users.remove(0);
    }
    private void DeleteUserInfoClearButton(){
        DeleteUserInfoShowAccountJTF.setText("");
        DeleteUserInfomodel.setRowCount(0);
    }
    private void ReviseUserInfoFindButton(){
        ReviseUserInfomodel.setRowCount(0);
        String TAccount = ReviseUserInfoShowAccountJTF.getText();
        if(Objects.equals(TAccount, "")){
            JOptionPane.showMessageDialog(null, "请输入需要查找的账户！","消息提示",JOptionPane.WARNING_MESSAGE);

        }else{
            UserAccount account = ncreService.GetUserAPByAccount(TAccount);
            UserInfo userInfo = ncreService.GetUserInfoByAccount(TAccount);
            if(account == null){
                JOptionPane.showMessageDialog(null, "未查找到该账户信息！","消息提示",JOptionPane.WARNING_MESSAGE);
            }else {
                User Tuser = new User();
                Tuser.setAccount(account);
                Tuser.setUserInfo(userInfo);
                users.add(Tuser);
                ReviseUserInfomodel.addRow(new String[]{
                        "1",account.getAccount(),account.getPassword(),userInfo.getName(),
                        userInfo.getGender(), String.valueOf(userInfo.getAge()),userInfo.getSchoolid(),
                        userInfo.getPhone(),userInfo.getSchool()
                });
            }
        }
    }
    private void ReviseUserInfoReviseButton() {
        Vector<Vector> a = ReviseUserInfomodel.getDataVector();
        User Tuser = new User();
        UserAccount account = new UserAccount();
        account.setAccount((String) a.get(0).get(1));
        account.setPassword((String) a.get(0).get(2));
        UserInfo info = new UserInfo();
        info.setAccount((String) a.get(0).get(1));
        info.setName((String) a.get(0).get(3));
        info.setGender((String) a.get(0).get(4));
        if (a.get(0).get(5) != null && !a.get(0).get(5).equals("")) {
            info.setAge((int) Long.parseLong((String) a.get(0).get(5)));
        }
        info.setSchoolid((String) a.get(0).get(6));
        info.setPhone((String) a.get(0).get(7));
        info.setSchool((String) a.get(0).get(8));
        Tuser.setAccount(account);
        Tuser.setUserInfo(info);
        ncreService.UpdateUserInfo(Tuser);
        JOptionPane.showMessageDialog(null, "信息修改成功！", "消息提示", JOptionPane.WARNING_MESSAGE);


    }
    private void ReviseUserInfoClearButton(){
        ReviseUserInfoShowAccountJTF.setText("");
        ReviseUserInfomodel.setRowCount(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "AddUserInfoJP")){
            this.AddUserInfoJP();
        }
        if(Objects.equals(e.getActionCommand(), "DeleteUserInfoJP")){
            this.DeleteUserInfoJP();
        }
        if(Objects.equals(e.getActionCommand(), "ReviseUserInfoJP")){
            this.ReviseUserInfoJP();
        }
        if(Objects.equals(e.getActionCommand(), "FindUserInfoJP")){
            this.FindUserInfoJP();
        }
        if(Objects.equals(e.getActionCommand(), "AdLogoffButton")){
            this.AdLogoffButton();
        }
        if(Objects.equals(e.getActionCommand(), "AddUserInfoAdd")){
            this.AddUserInfoAdd();
        }
        if(Objects.equals(e.getActionCommand(), "AddUserInfoAddLine")){
            this.AddUserInfoAddLine();
        }
        if(Objects.equals(e.getActionCommand(), "AddUserInfoClear")){
            this.AddUserInfoClear();
        }
        if(Objects.equals(e.getActionCommand(), "DeleteUserInfoFindButton")){
            this.DeleteUserInfoFindButton();
        }
        if(Objects.equals(e.getActionCommand(), "DeleteUserInfoDeleteButton")){
            this.DeleteUserInfoDeleteButton();
        }
        if(Objects.equals(e.getActionCommand(), "DeleteUserInfoClearButton")){
            this.DeleteUserInfoClearButton();
        }
        if(Objects.equals(e.getActionCommand(), "ReviseUserInfoFindButton")){
            this.ReviseUserInfoFindButton();
        }
        if(Objects.equals(e.getActionCommand(), "ReviseUserInfoReviseButton")){
            this.ReviseUserInfoReviseButton();
        }
        if(Objects.equals(e.getActionCommand(), "ReviseUserInfoClearButton")){
            this.ReviseUserInfoClearButton();
        }

    }
}
