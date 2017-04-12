import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PromptSave extends JFrame implements ActionListener{
   private boolean status;
   private String action;
   private JButton saveFile;
   private JButton dontSave;
   public PromptSave(String theAction,boolean theStatus){
      action = theAction; // action to take after window is dismissed
      status = theStatus; // whether the file is new or not
      saveFile = new JButton("Save");
      saveFile.addActionListener(this);
      dontSave = new JButton("Don't Save");
      dontSave.addActionListener(this);

      this.setTitle("Save your file?");
      this.add((new JLabel("Changes were made to your file, would you like to save them?")),BorderLayout.NORTH);
      this.add(saveFile,BorderLayout.EAST);
      this.add(dontSave,BorderLayout.WEST);
      this.setSize(250,200);
      this.setDefaultCloseOperation(1);
      this.setVisible(true);
   }
/*
   public void doAction(){
      if(action == "open"){
         Dialogc.takeAction("open");
      }
      else if(action == "new"){
         Dialogc.takeAction("new");
      }
      else if(action == "compile"){
         Dialogc.takeAction("compile");
      }
      else if(action == "quit"){
         Dialogc.takeAction("quit");
      }
   }
*/
   public void actionPerformed(ActionEvent e){
      this.setVisible(false);
      this.dispose();
      if(e.getSource() == saveFile){
         if(status == true){ /* file does not have a name (is new) */
            //prompt for name of file (call save as)
            if(action==null){
               new SaveasFile(null);
System.out.println("JUST SAVE AS");
            }
            else if(action=="compile"){
System.out.println("COMPILE AFTER SAVE AS");
            }
            else if(action=="run"){
System.out.println("RUN AFTER SAVE AS");
            }
            else if(action=="new"){
System.out.println("NEW FILE AFTER SAVE AS");
            }
            else if(action=="quit"){
System.out.println("QUIT AFER SAVE AS");
            }
            else{ // catch-all
               new SaveasFile(null);
System.out.println("CATCH ALL -- PROMPTSAVE");
            }            
         }
         else{
            Dialogc.saveFile();
         }      
      }
      else if(e.getSource() == dontSave){
         Dialogc.modF=false;
         Dialogc.updateStatusBar();
         Dialogc.takeAction(action);
      }
   }

}


