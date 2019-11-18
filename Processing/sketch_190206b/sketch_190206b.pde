PImage myimage;
int x;
int y;
void setup() {
size(400, 400);
x =100;
y= 100;
myimage= loadImage("spacer.GIF"); }
void draw(){ background(255);
image(myimage, x++, y++); }
