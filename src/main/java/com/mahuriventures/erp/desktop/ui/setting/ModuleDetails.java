package com.mahuriventures.erp.desktop.ui.setting;

import com.mahuriventures.erp.desktop.exception.SourceNotFoundException;
import com.mahuriventures.erp.desktop.models.ModuleEntity;
import com.mahuriventures.erp.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class ModuleDetails extends JDialog{
    private  ModuleEntity moduleEntity;

    protected JProgressBar progressBar;

    public ModuleDetails(JDialog jDialog, ModuleEntity entity){
        super(jDialog,entity.getTitle(), ModalityType.DOCUMENT_MODAL);
        setSize((int)(jDialog.getWidth() / 1.2),(int) (jDialog.getHeight()/1.2));

        this.moduleEntity = entity;

        initUI();

    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createTitledBorder("MODULE DETAILS"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        lbl_name = new JLabel("Module Name :");
        panel.add(lbl_name,c);


        name = new JLabel(moduleEntity.getTitle());
        c.gridx = 1;
        c.gridy = 0;
        panel.add(name,c);

        lbl_description = new JLabel("Description :");
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight=10;
        c.gridwidth = 5;
        panel.add(lbl_description,c);

        description = new JLabel("<html>"+ moduleEntity.getDescription()+" sdfjosd josdjfosdjfoisjdfijsdfoijsdof jsdofjoisdjfoisdjfosdjfoisdjf sdjfosdjfoisdjfoisdjfoisdjfoidsjfoijdsof</html>");
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx=1;
        c.gridy = 1;
        c.gridheight=10;
        c.gridwidth = 5;
        panel.add(description,c);


        install = new JButton("Install");
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 20;
        c.gridwidth = 2;
        panel.add(install,c);

        add(panel,BorderLayout.CENTER);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        c.gridx = 1;
        c.gridy = 40;
        panel.add(progressBar,c);


        install.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // download the relevent jar
                install.setEnabled(false);
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new BackgroundWorker().execute();
                    }
                });

            }
        });


    }

    class BackgroundWorker extends SwingWorker<Void,Void>{
        public BackgroundWorker(){
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    progressBar.setValue(getProgress());
                }
            });
        }

        @Override
        protected void done(){
            install.setEnabled(true);
            install.setText("Installed");
        }

        @Override
        protected Void doInBackground() throws Exception {
            try{
                URL url = new URL(moduleEntity.getUrl());
                URLConnection connection = url.openConnection();
                connection.connect();
                int lengthOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream());

                // File Name
                String source = moduleEntity.getUrl();
                String fileName =  source.substring(source.lastIndexOf("/")+1,source.length());

                String saveFile = null;

                //saveFile = new File(".").getCanonicalPath()+"\\file\\"+fileName;
                saveFile = new File(Constants.MODULE_URL).getCanonicalPath()+"/"+fileName;
                System.out.println(saveFile);

                OutputStream output = new FileOutputStream(saveFile);
                byte data[] = new byte[1024];
                int count;

                long total = 0;
                while((count = input.read(data)) !=-1){
                    total += count;
                    setProgress((int)((total * 100) / lengthOfFile));
                    output.write(data,0,count);
                }
                output.flush();
                output.close();
                input.close();

            }catch (Exception ex){
                throw new SourceNotFoundException("Not Found "+moduleEntity.getUrl());
            }
            return null;
        }
    }



    private JLabel lbl_name;
    private JLabel name;
    private JLabel lbl_description;
    private JLabel description;
    private JButton install;


}
