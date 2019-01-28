package com.android;

import com.android.CycleView.Model;
import com.android.CycleView.Prop;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

class AnimationPanel extends JPanel {

  private float mDuration = 20000; // duration in milliseconds
  private float myAnimationPercent;
  private long myLastTime;
  private static final int BUTTON_WIDTH = 123;
  private static final int BUTTON_HEIGHT = 40;
  private String myTitle = "button";
  private JButton myPlayButton;
  private boolean myIsPlaying = false;
  private Timer myPlayTimer = new Timer(14, e -> step());
  private Model myModel;
  private int myAttributeType;
  private Prop myAttribute;
  private float myCurrentValue;
  static final Stroke DASH_STROKE = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1,new float[]{10,10},0);
  AnimationPanel(Model model, JButton play) {
    super(new FlowLayout(FlowLayout.LEFT));
    myModel = model;
    myPlayButton = play;
    myPlayButton.addActionListener(e -> play());
  }

  public void setModel(Model model) {
    myModel = model;
  }

  public void setMode() {
    System.out.println("update attribute_type ");
    myAttribute = Prop.values()[myAttributeType = myModel.mAttrIndex];
  }

  public void play() {
    if (myIsPlaying) {
      myModel.setDot(Float.NaN, 0);
      pause();
      myIsPlaying = false;
      return;
    }
    myPlayButton.setText("pause");
    myIsPlaying = true;
    myPlayTimer.start();
    myAttributeType = myModel.mAttrIndex;
    myAttribute = Prop.values()[myAttributeType];
    System.out.println("prop = " + myAttribute.name());
  }

  int call_count = 0;
  int paint_count = 0;
  long last_update;

  public void step() {
    long time = System.currentTimeMillis();
    myAnimationPercent += (time - myLastTime) / mDuration;
    if (myAnimationPercent > 1.0f) {
      myAnimationPercent = 0;
    }

    myCurrentValue = myModel.getComputedValue(myAnimationPercent);
    myModel.setDot(myAnimationPercent, myCurrentValue);
    call_count++;
    repaint();
    myLastTime = time;
  }

  public void pause() {
    myPlayButton.setText("play");
    myPlayTimer.stop();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    paint_count++;
    long time = System.currentTimeMillis();
    int w = getWidth();
    int h = getHeight();
    float buttonCX = w / 2.0f;
    float buttonCY = h / 2.0f;
    float startX = buttonCX;
    float startY = buttonCY;
    float endX = buttonCX;
    float endY = buttonCY;
    if (myMoveObject != 0) {
      float dx = movement[myMoveObject][0];
      float dy = movement[myMoveObject][1];
      startX = buttonCX - (dx * w)/3.0f;
       startY = buttonCY - (dy * h)/3.0f;
       endX = buttonCX + (dx * w)/3.0f;
       endY = buttonCY + (dy * h)/3.0f;
      buttonCX = startX+ myAnimationPercent *(endX-startX);
      buttonCY = startY+ myAnimationPercent *(endY-startY);

    }
    Graphics2D g2d = (Graphics2D) g.create();
    AffineTransform at;
    Stroke old = g2d.getStroke();
    g2d.setColor(Color.RED);
    g2d.setStroke(DASH_STROKE);
    g2d.drawLine((int)startX,(int)startY,(int)endX,(int)endY);
    g2d.setStroke(old);
    Color background = Color.LIGHT_GRAY;
    Color border = Color.DARK_GRAY;
    Color text = Color.BLACK;
    if (myAttribute != null) {
      switch (myAttribute) {

        case PATH_ROTATE:
          at = new AffineTransform();
          at.rotate(Math.toRadians(myCurrentValue), buttonCX, buttonCY);
          g2d.transform(at);
          break;
        case ALPHA:
          int alpha = Math.max(0, Math.min(255, (int) (myCurrentValue * 255)));
          background = new Color(background.getRed(), background.getGreen(), background.getBlue(),
              alpha);
          border = new Color(border.getRed(), border.getGreen(), border.getBlue(), alpha);
          text = new Color(text.getRed(), text.getGreen(), text.getBlue(), alpha);
          break;
        case ELEVATION:
          break;
        case ROTATION:
          at = new AffineTransform();
          at.rotate(Math.toRadians(myCurrentValue), buttonCX, buttonCY);
          g2d.transform(at);
          break;
        case ROTATION_X:
          break;
        case ROTATION_Y:
          break;
        case SCALE_X:
          at = new AffineTransform();
          at.translate(w / 2.0, buttonCY);
          at.scale(myCurrentValue, 1);
          at.translate(-w / 2.0, -buttonCY);

          g2d.transform(at);
          break;
        case SCALE_Y:
          at = new AffineTransform();
          at.translate(buttonCX, buttonCY);
          at.scale(1, myCurrentValue);
          at.translate(-buttonCX, -buttonCY);
          g2d.transform(at);
          break;
        case TRANSLATION_X:
          at = new AffineTransform();
          at.translate(myCurrentValue, 0);
          g2d.transform(at);
          break;
        case TRANSLATION_Y:
          at = new AffineTransform();
          at.translate(0, myCurrentValue);
          g2d.transform(at);
          break;
        case TRANSLATION_Z:
          break;
        case PROGRESS:
          break;
      }
    }

    int px = (int)(0.5+buttonCX - BUTTON_WIDTH / 2.0f);
    int py = (int)(0.5+buttonCY - BUTTON_HEIGHT / 2.0f);

    g2d.setColor(background);
    g2d.fillRoundRect(px, py, BUTTON_WIDTH, BUTTON_HEIGHT, 5, 5);
    g2d.setColor(border);
    g2d.drawRoundRect(px, py, BUTTON_WIDTH, BUTTON_HEIGHT, 5, 5);
    int sw = g.getFontMetrics().stringWidth(myTitle);
    int fh = g.getFontMetrics().getHeight();
    int fa = g.getFontMetrics().getAscent();
    g2d.setColor(text);
    g2d.drawString(myTitle, px + BUTTON_WIDTH / 2 - sw / 2, py + BUTTON_HEIGHT / 2 + fa - fh / 2);
    if (time - last_update > 1000) {
      System.out.println("1 > " + 1000 * call_count / (float) (time - last_update) + " paint "
          + 1000 * paint_count / (float) (time - last_update));
      last_update = time;
      paint_count = 0;
      call_count = 0;
    }
  }
  static String []MOVE_NAMES = {"Stationary","South to North","West to East","SW to NE","NW to SE", "SE to NW", "NE to SW"};
  static String []DURATION = {"0.1s","0.5s","1.0s","2.0s", "5s", "10s","20s"};
  static int []DURATION_VAL = {100,500,1000,2000, 5000, 10000,20000};

  static  int [][] movement = {
      {0,0},
      {0,-1},
      {1,0},
      {1,-1},
      {1,1},
      {-1,-1},
      {-1,1},
  };
  int myMoveObject = 0;
  public void setMovement(int move) {
    myMoveObject = move;
    repaint();
  }

  public void setDurationIndex(int selectedIndex) {
    mDuration = DURATION_VAL[selectedIndex];
  }
}
