package de.pylamo.spellmaker.gui.SpellItems.Condition;

import de.pylamo.spellmaker.gui.SimpleDragObject;
import de.pylamo.spellmaker.gui.SimpleDragObject.TransferableSimpleDragObject;
import de.pylamo.spellmaker.gui.SpellItems.ISpellItem;
import de.pylamo.spellmaker.gui.SpellItems.ImageMover;
import de.pylamo.spellmaker.gui.SpellItems.Parameter.IParameter;
import de.pylamo.spellmaker.gui.SpellItems.Parameter.ParameterSlot;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JLayeredPane;

public class IfItem
  extends ComplexItem
{
  private static final long serialVersionUID = 1L;
  public ConditionStartPanel istp;
  private SidePanel isp = new SidePanel();
  private EndPanel eip = new EndPanel("endif");
  
  public ISpellItem clone()
  {
    IfItem ii = new IfItem(!this.b, this.w);
    if (this.istp.conditionslot.content != null)
    {
      ii.istp.conditionslot.add(this.istp.conditionslot.content.clone());
      ii.istp.conditionslot.content = this.istp.conditionslot.content.clone();
    }
    return ii;
  }
  
  public IfItem(boolean preview, de.pylamo.spellmaker.gui.Window w)
  {
    super(w);
    setLayout(null);
    this.b = (!preview);
    setOpaque(false);
    if (preview)
    {
      this.istp = new ConditionStartPanel("if", true, w);
      createDragSource();
    }
    else
    {
      this.istp = new ConditionStartPanel("if", false, w);
      this.istp.addMouseListener(this);
      this.istp.addMouseMotionListener(this);
      this.isp.addMouseListener(this);
      this.isp.addMouseMotionListener(this);
      this.eip.addMouseListener(this);
      this.eip.addMouseMotionListener(this);
    }
    add(this.istp);
    add(this.isp);
    add(this.eip);
    this.istp.setLocation(0, 0);
    this.istp.setVisible(true);
    revalidate();
  }
  
  public EndPanel getEndPanel()
  {
    return this.eip;
  }
  
  public boolean isInVisiblePart(Point p)
  {
    int x = getX();
    int y = getY();
    if ((p.getX() < x + this.istp.getWidth()) && (p.getY() < y + this.istp.getHeight())) {
      return true;
    }
    if ((p.getX() < x + 25) && (p.getY() < y + this.isp.getY() + this.isp.getHeight()) && (p.getY() > y + this.isp.getY())) {
      return true;
    }
    if ((p.getX() < x + this.eip.getWidth()) && (p.getY() > y + this.eip.getY())) {
      return true;
    }
    return false;
  }
  
  void createDragSource()
  {
    DragSource ds = new DragSource();
    IfItemDragGestureListener sis = new IfItemDragGestureListener(null);
    ds.createDefaultDragGestureRecognizer(this, 1, sis);
    ds.addDragSourceMotionListener(sis);
    ds.addDragSourceListener(new DragSourceListener()
    {
      public void dropActionChanged(DragSourceDragEvent dsde) {}
      
      public void dragOver(DragSourceDragEvent dsde) {}
      
      public void dragExit(DragSourceEvent dse) {}
      
      public void dragEnter(DragSourceDragEvent dsde) {}
      
      public void dragDropEnd(DragSourceDropEvent dsde) {}
    });
  }
  
  public void revalidate()
  {
    int w = 0;
    
    int height = 0;
    ISpellItem isi = this.firstBlockItem;
    while (isi != null)
    {
      height += isi.getHeight();
      isi = isi.getNext();
    }
    if (height == 0) {
      height = 25;
    }
    if (this.isp == null) {
      this.isp = new SidePanel();
    }
    if (this.istp == null) {
      this.istp = new ConditionStartPanel("if", true, this.w);
    }
    if (this.eip == null) {
      this.eip = new EndPanel("endif");
    }
    this.isp.setSize(25, height);
    this.isp.setLocation(0, this.istp.getPreferredSize().height);
    this.istp.setSize(this.istp.getPreferredSize());
    this.eip.setSize(this.eip.getPreferredSize().width + 70, this.eip.getPreferredSize().height);
    this.eip.setLocation(0, this.isp.getY() + this.isp.getHeight());
    int h = this.eip.getY() + this.eip.getHeight();
    for (Component com : getComponents()) {
      if (com.getPreferredSize().width + com.getX() > w) {
        w = com.getPreferredSize().width + com.getX();
      }
    }
    isi = this.firstBlockItem;
    ISpellItem vo = null;
    while (isi != null)
    {
      if (vo != null) {
        isi.setLocation(vo.getX(), vo.getY() + vo.getHeight());
      } else {
        isi.setLocation(getX() + 25, getY() + this.istp.getHeight());
      }
      vo = isi;
      isi = isi.getNext();
    }
    setSize(w, h);
    setPreferredSize(new Dimension(w, h));
    super.revalidate();
    if (this.previous != null) {
      this.previous.revalidate();
    }
  }
  
  public void setLocation(int x, int y)
  {
    super.setLocation(x, y);
    ISpellItem isi = this.firstBlockItem;
    ISpellItem vo = null;
    while (isi != null)
    {
      if (vo != null) {
        isi.setLocation(vo.getX(), vo.getY() + vo.getHeight());
      } else {
        isi.setLocation(getX() + 25, getY() + this.istp.getHeight());
      }
      vo = isi;
      isi = isi.getNext();
    }
  }
  
  public void mousePressed(MouseEvent e)
  {
    super.mousePressed(e);
    if (this.b)
    {
      this.p = e.getPoint();
      ((JLayeredPane)getParent()).moveToFront(this);
      ISpellItem isi = this.firstBlockItem;
      while (isi != null)
      {
        ((JLayeredPane)getParent()).moveToFront(isi);
        isi = isi.getNext();
      }
    }
  }
  
  public void mouseDragged(MouseEvent e)
  {
    super.mouseDragged(e);
    ISpellItem isi = this.firstBlockItem;
    ISpellItem vo = null;
    while (isi != null)
    {
      if (vo != null) {
        isi.setLocation(vo.getX(), vo.getY() + vo.getHeight());
      } else {
        isi.setLocation(getX() + 25, getY() + this.istp.getHeight());
      }
      vo = isi;
      isi = isi.getNext();
    }
  }
  
  public String getItem()
  {
    String lol = "";
    if (this.istp.conditionslot.content != null) {
      lol = this.istp.conditionslot.content.getString();
    }
    String s = "if, " + lol.trim();
    ISpellItem isi = this.firstBlockItem;
    while (isi != null)
    {
      s = s + "\n";
      s = s + isi.getItem();
      isi = isi.getNext();
    }
    s = s + "\nendif";
    return s;
  }
  
  private class IfItemDragGestureListener
    implements DragGestureListener, DragSourceMotionListener
  {
    private IfItemDragGestureListener() {}
    
    public void dragGestureRecognized(DragGestureEvent dge)
    {
      String s = "[IFITEM]";
      SimpleDragObject sdo = new SimpleDragObject(s);
      BufferedImage bi = new BufferedImage(IfItem.this.getWidth(), IfItem.this.getHeight(), 2);
      IfItem.this.paint(bi.getGraphics());
      Cursor cursor = null;
      ImageMover.start(bi, MouseInfo.getPointerInfo().getLocation());
      if (dge.getDragAction() == 1) {
        cursor = DragSource.DefaultCopyDrop;
      }
      dge.startDrag(cursor, new SimpleDragObject.TransferableSimpleDragObject(sdo));
    }
    
    public void dragMouseMoved(DragSourceDragEvent dsde)
    {
      ImageMover.w.setLocation(new Point(dsde.getLocation().x + 2, dsde.getLocation().y + 4));
    }
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\de\pylamo\spellmaker\gui\SpellItems\Condition\IfItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */