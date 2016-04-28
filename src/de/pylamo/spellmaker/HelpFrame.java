package de.pylamo.spellmaker;

import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument;

public class HelpFrame
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private final JEditorPane pane = new JEditorPane();
  
  public HelpFrame()
  {
    JScrollPane scroll = new JScrollPane(this.pane);
    this.pane.setDocument(new HTMLDocument());
    setContentPane(scroll);
    setSize(450, 500);
    this.pane.setEditable(false);
  }
  
  public void setContent(String filename)
  {
    try
    {
      this.pane.setPage(HelpFrame.class.getResource(filename));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\de\pylamo\spellmaker\HelpFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */