package com.mahuriventures.erp.desktop.ui.setting;

import com.mahuriventures.erp.desktop.ui.setting.CustomList.ModuleEntity;
import com.mahuriventures.erp.desktop.ui.setting.CustomList.ModuleRenderer;
import com.mahuriventures.erp.desktop.util.ColorCodeConstants;
import com.mahuriventures.erp.util.Constants;
import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MarketPlace extends JDialog {
    private final String TITLE = Constants.APP_NAME+Constants.VERSION+" Marketplace";

    private JLabel lbl_title;

    private final JPanel topPanel;
    private final JPanel viewPanel;

    private JList<ModuleEntity> entityJList;

    public MarketPlace(JFrame frame){
        super(frame);
        this.lbl_title = new JLabel(TITLE);
        this.lbl_title.setForeground(Color.white);
        this.setLayout(new BorderLayout());

        // initialize a top panel
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.PAGE_AXIS));
        topPanel.add(lbl_title);
        JTextPane m_description = new JTextPane();
        m_description.setEditable(false);
        m_description.setText("Select modules to install. Press Install Now to proceed with installation." +
                "Press the \"more info\" link to learn more about a solution");
        m_description.insertIcon(new ImageIcon(ClassLoader.getSystemResource("images/boxes-brown_25x25.png")));

        topPanel.add(m_description);
        topPanel.setBackground(Color.decode(ColorCodeConstants.PANEL_HEADING_COLOR));
        add(topPanel,BorderLayout.NORTH);

        // initialize a market list

        DefaultListModel<ModuleEntity> moduleList = new DefaultListModel<>();
        moduleList.addElement(new ModuleEntity(1L,"CRM","Customer Relation Management",false));
        moduleList.addElement(new ModuleEntity(2L,"Billing","Thie module allows you to create a billing",false));
        moduleList.addElement(new ModuleEntity(3L,"Website","Create and manage your own website",false));
        moduleList.addElement(new ModuleEntity(4L,"Inventory","Manage all the inventory of your organization",false));

        viewPanel = new JPanel(new BorderLayout());
        entityJList = new JList<>(moduleList);
        entityJList.setCellRenderer(new ModuleRenderer());
        viewPanel.add(new JScrollPane(entityJList),BorderLayout.CENTER);
        add(viewPanel,BorderLayout.CENTER);

        entityJList.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    ModuleEntity entity = entityJList.getSelectedValue();
                    // open a new details window
                    JDialog dialog = (JDialog) topPanel.getParent().getParent().getParent().getParent();
                    ModuleDetails moduleDetails = new ModuleDetails(dialog,entity);
                    moduleDetails.setLocationRelativeTo(dialog);
                    moduleDetails.setVisible(true);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
