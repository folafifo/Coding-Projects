class Computer 
{
  float xpos; 
  int ypos = 20;
  color paddlecolor = color(0, 204, 4);
  int noOfLives =3;
  Computer()
  {
    xpos=SCREENX/2;
    ypos=PADDLEHEIGHT + MARGIN;
  }

  void move(Ball theBall)
  {
    if (xpos>SCREENX-PADDLEWIDTH)
      xpos = SCREENX;

    if (xpos < 0)
      xpos = 0;

    xpos = theBall.positionX() - ((1.05)*(PADDLEWIDTH));
  }

  void draw()
  {
    fill(paddlecolor);
    rect(xpos, ypos, PADDLEWIDTH, PADDLEHEIGHT);
  }
}
