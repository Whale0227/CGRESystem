package org.ncre.Apps;

import org.ncre.GUI.NCRE;
import org.ncre.config.SpringConfig;
import org.ncre.data.domain.UserAccount;
import org.ncre.service.NCREService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ssfb = new AnnotationConfigApplicationContext(SpringConfig.class);
        NCREService ncreService = ssfb.getBean(NCREService.class);
        NCRE ncre = new NCRE(ncreService);
//        UserAccount userAccount = new UserAccount();
//        userAccount.setAccount("1");
//        userAccount.setPassword("1");
//        ncre.UserMenu(userAccount);
//
          ncre.AdMenu();

    }
}
