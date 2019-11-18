final int SCREENX = 650;
final int SCREENY = 650;
int noOfAliens = 10;

Alien myAliens[];

void settings() {
  size(SCREENX, SCREENY);
}

void setup() {
  myAliens = new Alien[noOfAliens];
  noStroke();
  init_array(myAliens);
}

void draw() {
  background(255);
  move_array(myAliens);
  draw_array(myAliens);
}
void draw_array(Alien theArray[]) {
  for (int i = 0; i < theArray.length; i++) {
    if (!theArray[i].exploded)
      theArray[i].draw();
    else if (theArray[i].exploded && theArray[i].deadCounter++ <= 30)
      theArray[i].draw();
  }
}
void init_array(Alien theArray[]) {
  for (int i = 0; i < theArray.length; i++)
    theArray[i] = new Alien(int(random(0, SCREENX)), int(random(0, SCREENY)));
}

void move_array(Alien theArray[]) {
  for (int i = 0; i < theArray.length; i++) {
    if (!theArray[i].exploded)
      theArray[i].move();
  }
}
