package org.ncre.GUI;

import org.ncre.service.NCREService;

import javax.swing.*;

public class AdLoginMenu {
    private JPanel AdLoginJP;
    private Styles styles;
    private NCREService ncreService;

    AdLoginMenu(Styles styles, NCREService ncre){
        ncreService = ncre;
        this.styles = styles;
        AdLoginJP = new JPanel();
        AdLoginJP.setLayout(null);
    }

    public JPanel Init(){




        return AdLoginJP;
    }

}
