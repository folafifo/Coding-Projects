int i;
int q;
int j;
void setup(){
size(500,500);
noStroke();
fill(0,204,4);
i =0;
q=0;
j=0;



}
void draw(){
background(255);
rect(i, 20, 100, 100); 
if(i++>=499) i=0;
rect(20, q, 100, 100); 
if(q++>=499) q=0;
rect(j, j, 100, 100); 
if(j++>=499) j=0;


}
