package org.ncre.GUI;

import org.ncre.data.domain.UserAccount;
import org.ncre.service.NCREService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class NCRE extends JFrame implements ActionListener {
    private Styles styles = new Styles();
    private AdMenu adMenu;
    private Load load;
    private JPanel LoadPanel,AdLoginJP,UserMenuJP;
    private NCREService ncreService;
    private AdLogin adLogin;
    private UserLogin userLogin;

    private UserMenu userMenu;
    private UserAccount userAccount;


    public NCRE(NCREService ncreService){
        userAccount = new UserAccount();
        this.ncreService = ncreService;
        this.setResizable(false);
        this.setSize(styles.MaxWidth,styles.MaxHeight);
        this.setTitle("计算机等级考试报名系统");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        /**
         * 主界面
         */
        load = new Load(styles);
        LoadPanel = new JPanel();
        LoadPanel = load.Init(this);
        /**
         * 管理员登录界面
         */
        adLogin= new AdLogin(styles,ncreService,this);

        /**
         * 管理员登录成功后菜单
         */
        adMenu = new AdMenu(styles,ncreService);
        AdLoginJP = new JPanel();
        AdLoginJP = adMenu.Init();

        /**
         * 用户登录界面
         */
        userLogin= new UserLogin(styles,ncreService,this);

        /**
         * 用户菜单
         */
        userMenu = new UserMenu(styles,ncreService);
        UserMenuJP = new JPanel();
        UserMenuJP = userMenu.Init();


        this.add(LoadPanel);
        this.add(AdLoginJP);
        this.add(UserMenuJP);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void Load(){
        LoadPanel.setVisible(true);
        AdLoginJP.setVisible(false);
        UserMenuJP.setVisible(false);
    }

    public void AdMenu(){
        LoadPanel.setVisible(false);
        AdLoginJP.setVisible(true);
        UserMenuJP.setVisible(false);
    }
    public void UserMenu(UserAccount userAccount){

        LoadPanel.setVisible(false);
        AdLoginJP.setVisible(false);
        userMenu.SetNCRE(this);
        userMenu.Initialize(userAccount);
        UserMenuJP.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "ADLOGIN")){
            // 管理员登录界面
            adLogin.Init();
        }
        if(Objects.equals(e.getActionCommand(), "USERLOGIN")){
            // 用户登录界面
            userLogin.Init();
        }
    }
}
