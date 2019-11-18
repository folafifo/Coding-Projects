class TextWidget extends Widget {
  int maxlen;

  TextWidget(int in_x, int in_y, int in_width, int in_height, 
    String in_label, color in_color, PFont in_font, int in_event, int in_max) {
    x=in_x;  
    y=in_y; 
    width = in_width; 
    height= in_height;
    label=in_label; 
    event=in_event; 
    widgetColor=in_color; 
    widgetFont=in_font;
    labelColor=0; 
    maxlen = in_max;
  }

  String getText() {
    return label;
  }

  void append(char s) {
    if ( s == BACKSPACE ) {
      if (!label.equals(""))
        label=label.substring(0, label.length()-1);
    } else if (label.length() < maxlen)
      label=label+str(s);
  }
}
