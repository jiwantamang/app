package com.mahuriventures.erp.desktop.ui.setting;

import com.mahuriventures.erp.desktop.models.ModuleEntity;
import com.mahuriventures.erp.desktop.service.MarketService;
import com.mahuriventures.erp.desktop.service.impl.MarketServiceImpl;
import com.mahuriventures.erp.desktop.ui.setting.CustomList.ModuleRenderer;
import com.mahuriventures.erp.desktop.util.ColorCodeConstants;
import com.mahuriventures.erp.util.Constants;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class MarketPlace extends JDialog {
    private final String TITLE = Constants.APP_NAME+Constants.VERSION+" Marketplace";
    private JLabel lbl_title;
    private final JPanel topPanel;
    private final JPanel viewPanel;
    private JList<ModuleEntity> entityJList;

    private JProgressBar progressBar;
    private SimulatedActivity activity;

    // service layer

    private MarketService marketService;

    public MarketPlace(JFrame frame){
        super(frame);

        // initialize a Service Layer
        marketService = new MarketServiceImpl();



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




        JPanel panel = new JPanel(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setString("Loading Modules");
        progressBar.setIndeterminate(true);
        progressBar.setSize(panel.getWidth(),panel.getHeight());
        panel.add(progressBar,BorderLayout.CENTER);

        // work with progress bar
        activity = new SimulatedActivity(100);
        activity.execute();
        pack();

        add(panel,BorderLayout.SOUTH);

        viewPanel = new JPanel(new BorderLayout());
        entityJList = new JList<>(marketService.getAllMarketModule());
        entityJList.setCellRenderer(new ModuleRenderer());
        viewPanel.add(new JScrollPane(entityJList),BorderLayout.CENTER);
        add(viewPanel,BorderLayout.CENTER);
        progressBar.setIndeterminate(false);
        activity.done();



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


    class SimulatedActivity extends SwingWorker<Void,Integer>{
        private int current;
        private int target;

        /*
            Constructs the simulated activit ythat increments acounter from 0 to a given target
            @Param the target value of the counter
         */

        public SimulatedActivity(int t){
            current = 0;
            target = t;
        }



        @Override
        protected Void doInBackground() throws Exception {
            try{
                while(current < target){
                    Thread.sleep(100);
                    current ++;
                    publish(current);
                }
            }catch (InterruptedException e){}
            return null;
        }

        public void process(List<Integer> chunks){
            for(Integer chunk: chunks){
                progressBar.setValue(chunk);
            }
        }

        protected void done(){

        }


    }



}
