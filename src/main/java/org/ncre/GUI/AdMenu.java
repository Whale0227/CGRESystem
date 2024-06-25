package org.ncre.GUI;

import org.ncre.service.NCREService;

import javax.swing.*;
import java.awt.*;

public class AdMenu {
    private JPanel AdLoginJP,PictureJP,AdLoginButtonJP,AdMenuAccountJP;
    private JButton AddUserInfoButton,DeleteUserInfoButton,ReviseUserInoButton,FindUserInfoButton;
    private Styles styles;
    private JLabel AdMenuAccountJL1;
    private NCREService ncreService;
    private JLabel Picture;
    private final Icon icon;  // 资源图片

    AdMenu(Styles styles, NCREService ncre){

        AdMenuAccountJL1 = new JLabel("账户：管理员");
        AdMenuAccountJL1.setFont(styles.SmallJLFont);
        AdMenuAccountJL1.setForeground(Color.white);
        AdMenuAccountJP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        AdMenuAccountJP.setBounds(800,40,400,30); // 表头、账号
        AdMenuAccountJP.setBackground(new Color(65,91,128));
        AdMenuAccountJP.add(AdMenuAccountJL1);

        AdMenuAccountJP.setFont(styles.SmallJLFont);

        ncreService = ncre;
        this.styles = styles;
        AdLoginJP = new JPanel(null);
        Picture = new JLabel();
        PictureJP = new JPanel(null);
        AddUserInfoButton = new JButton("添加用户信息");
        DeleteUserInfoButton = new JButton("删除用户信息");
        ReviseUserInoButton = new JButton("修改用户信息");
        FindUserInfoButton = new JButton("查找用户信息");

        AddUserInfoButton.setFont(styles.ButtonFont);
        DeleteUserInfoButton.setFont(styles.ButtonFont);
        ReviseUserInoButton.setFont(styles.ButtonFont);
        FindUserInfoButton.setFont(styles.ButtonFont);

        AdLoginButtonJP = new JPanel();
        PictureJP.setLayout(null);

        AdLoginJP.setBounds(0,0,1200,800);
        PictureJP.setBounds(0,0,1200,70);
        Picture.setBounds(0,0,400,70);
        AdLoginButtonJP.setBounds(0,70,200,730);
        PictureJP.setBackground(Color.white);
        AdLoginJP.setBackground(Color.yellow);
        AdLoginButtonJP.setBackground(Color.red);

        AdLoginButtonJP.add(AddUserInfoButton);
        AdLoginButtonJP.add(DeleteUserInfoButton);
        AdLoginButtonJP.add(ReviseUserInoButton);
        AdLoginButtonJP.add(FindUserInfoButton);

        FlowLayout AdMenuButtonGap=new FlowLayout();
        AdMenuButtonGap.setHgap(100);//水平间距
        AdMenuButtonGap.setVgap(80);//水平间距
        AdLoginButtonJP.setLayout(AdMenuButtonGap);

        icon = new ImageIcon("src\\main\\resources\\Pictures\\NCRE.jpg");
        Picture.setIcon(icon);
        PictureJP.add(Picture);
        AdLoginJP.add(PictureJP);
        AdLoginJP.add(AdLoginButtonJP);
        PictureJP.add(AdMenuAccountJP);

    }

    public JPanel Init(){

        return AdLoginJP;
    }

}
