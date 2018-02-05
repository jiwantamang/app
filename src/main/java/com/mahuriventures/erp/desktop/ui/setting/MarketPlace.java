package com.mahuriventures.erp.desktop.ui.setting;

import com.mahuriventures.erp.desktop.util.ColorCodeConstants;
import com.mahuriventures.erp.util.Constants;

import javax.swing.*;
import java.awt.*;

public class MarketPlace extends JDialog {
    private final String TITLE = Constants.APP_NAME+Constants.VERSION+" Marketplace";

    private JLabel lbl_title;

    private final JPanel topPanel;

    public MarketPlace(JFrame frame){
        super(frame);
        this.lbl_title = new JLabel(TITLE);
        this.lbl_title.setForeground(Color.white);
        this.setLayout(new BorderLayout());

        // initialize a top panel
        topPanel = new JPanel(new FlowLayout());
        topPanel.add(lbl_title);
        topPanel.setBackground(Color.decode(ColorCodeConstants.PANEL_HEADING_COLOR));
        add(topPanel,BorderLayout.NORTH);

    }


}
