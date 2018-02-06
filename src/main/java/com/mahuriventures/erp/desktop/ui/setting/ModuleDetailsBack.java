package com.mahuriventures.erp.desktop.ui.setting;

import com.mahuriventures.erp.desktop.models.ModuleEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModuleDetailsBack extends JDialog{


    public static final int TEXT_ROWS = 10;
    public static final int TEXT_COLUMNS = 40;

    private JButton startButton;
    private JProgressBar progressBar;
    private JCheckBox checkBox;
    private JTextArea textArea;
    private SimulatedActivity activity;

    public ModuleDetailsBack(JDialog jDialog,ModuleEntity entity){
        super(jDialog,entity.getTitle(), ModalityType.DOCUMENT_MODAL);
        setSize((int)(jDialog.getWidth() / 1.2),(int) (jDialog.getHeight()/1.2));

        textArea = new JTextArea(TEXT_ROWS,TEXT_COLUMNS);

        // setup panel with button and progressbar
        final int MAX = 100;
        JPanel panel = new JPanel();
        startButton = new JButton("Start");
        progressBar = new JProgressBar(0,MAX);
        progressBar.setStringPainted(true);
        panel.add(startButton);
        panel.add(progressBar);

        checkBox = new JCheckBox("indeterminate");
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(checkBox.isSelected());
                progressBar.setStringPainted(!progressBar.isIndeterminate());
            }
        });

        panel.add(checkBox);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);

        // setup the button action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                activity = new SimulatedActivity(MAX);
                activity.execute();
            }
        });
        pack();

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
                textArea.append(chunk +"\n");
                progressBar.setValue(chunk);
            }
        }

        protected void done(){
            startButton.setEnabled(true);
        }


    }


}
