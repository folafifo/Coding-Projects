ArrayList myWidgets;
TextWidget focus;
PFont stdFont;
static final int TEXT_WIDGET=1; 
static final int EVENT_NULL=0;
void setup() {
  stdFont=loadFont("Verdana-12.vlw");
  textFont(stdFont);
  TextWidget textedit=new TextWidget(100, 100, 100, 40, "edit me!", color(255), stdFont, TEXT_WIDGET, 10); 
  TextWidget another=new TextWidget(100, 200, 100, 40, "no me!", color(255), stdFont, TEXT_WIDGET, 10); 
  focus=null;
  myWidgets = new ArrayList();
  // Create two widgets, then add them to the myWidgets list.
  myWidgets.add(textedit); 
  myWidgets.add(another); 
  size(400, 400);
}
void draw() {
  background(200);
  for (int i = 0; i < myWidgets.size(); i++) {
    ((Widget)myWidgets.get(i)).draw();
  }
}
void mousePressed() {
  int event;
  // Ask the widgets on the list if the current mouse value is
  // inside them. If it is, the widget has been pressed.
  // Take the appropriate response to this event.
  for (int i = 0; i < myWidgets.size(); i++) {
    TextWidget theWidget = (TextWidget)myWidgets.get(i);
    event = theWidget.getEvent(mouseX, mouseY);
    if (event== TEXT_WIDGET) {
      println("clicked on a text entry widget!");
      focus= theWidget;
      break;
    } else {
      focus=null;
    }
  }
}
void keyPressed() {
  if (focus != null) {
    focus.append(key);
  }
}
