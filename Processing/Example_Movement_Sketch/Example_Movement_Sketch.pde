boolean movingRight = true;
int x = 0;

void setup() {
  size(400, 400);
}

void draw() {
  background(255);
  ellipse(x, 200, 50, 50);
  
  if (movingRight) x++;
  else x--;
  
  if (x == 0 || x == width) movingRight = !movingRight;
}
/*
if ball is moving right then and balls x-coordinate is greater than computers x cordinate the computer moves right,
if ball is moving right and balls x-coordinates is less than computers x-cordinate the computer moves to left;
if ball is moving left and balls x -cordinate is greater than computers x-cordinate the computer moves to the left 
if ball is moving left and balls x-coordinate is less than computers x-cordinate then ball moves to the right
*/
