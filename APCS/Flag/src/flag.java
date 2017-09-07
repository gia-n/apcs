import java.awt.*;
import javax.swing.JFrame;

public class flag extends JFrame {
//original star created
int [ ] x1 = {75, 72, 63, 69, 68, 75, 82, 81, 87, 79};
int [ ] y1 = {109, 117, 118, 124, 132, 128, 132, 124, 118, 117};
//star pared down to r = 1 
private double [ ] xg = {0.0/23.0, -7.0/23.0, -23.0/23.0, -12.0/23.0, -14.0/23.0, 0.0/23.0, 14.0/23.0, 12.0/23.0, 23.0/23.0, 7.0/23.0};
private double [ ] yg = {-25.0/23.0, -10.0/23.0, -8.0/23.0, 4.0/23.0, 20.0/23.0, 12.0/23.0, 20.0/23.0, 4.0/23.0, -8.0/23.0, -10.0/23.0};

public flag () {
init();
}

public void init() {
setSize(1000,900);
setBackground(Color.lightGray);
repaint();
}

//Parts of Flag
public void paint(Graphics g) {
// get dimensions of screen
int height = this.getHeight();
int width = this.getWidth();

//dimensions of flag

double flagHeight = height/2;
double flagWidth = (int)(flagHeight *1.9);
// set background that scales with window
g.setColor(Color.white);
g.fillRect(0, 0, width, height);
////Flag Red Background
g.setColor(new Color(191, 13, 62));
g.fillRect(50, 100, (int)flagWidth, (int) flagHeight); //this.getHeight()/2)
////w: 760, h = 400
//
////White Rectangles 
//
g.setColor(Color.white);
for (int i = 0; i < 6; i++){
	// red gap is the first area at the top where the white should not cover the red
double redgap = 100 + (int) flagHeight * 0.0769 ;
double stripeWidth = flagHeight*0.0769;
g.fillRect(50, (int)redgap + i*2*(int)stripeWidth, (int)flagWidth, (int)stripeWidth);
}
//
////Flag blue union
g.setColor(new Color(4, 30, 66));
double unionWidth = flagHeight*0.76;
double unionHeight = flagHeight*0.5385;
g.fillRect(50,100, (int)unionWidth, (int)unionHeight);



//dimensions and positioning of the stars
double radius_1 = (int)(flagHeight *0.0308) ;
//double starcenter_y_1 = 121.6;
double yspace = flagHeight * (0.054);
double starcenter_y_1 = (100 + yspace);
//double starcenter_x_1 = 75.2;
double xspace = flagHeight * (0.063);
double starcenter_x_1 = (50 + xspace) ;
//rows of 6 stars 
int l = 0;
int z = 0;
for (int k = 0; k<5; k++) {
	for (int i = 0; i < 6; i++) {
		stars(radius_1, starcenter_x_1+l, starcenter_y_1+z);
		g.setColor(Color.white);
			//i decided to add colors to the stars but if you remove the next color sections (if statements) then they will print white like normal
			//pink
			if (k == 0) {
				g.setColor(new Color(255, 51, 153));
			}
			//orange
			if (k == 1) {
				g.setColor(new Color(255, 127, 0));
			}
			//green
			if (k == 2) {
				g.setColor(new Color(0, 255, 0));
			}
			//dark blue
			if (k == 3) {
				g.setColor(new Color(0, 0, 255));
			}
			// violet
			if (k == 4) {
				g.setColor(new Color(148, 0, 211));
			}
			
		g.fillPolygon(x1, y1, 10);

		l += (xspace * 2);
		
	}
	z += (yspace *2);
	l = 0;
}


//dimensions and positioning of second portion of stars
double radius_2 = (int)(flagHeight *0.0308);
double yspace2 = flagHeight * (0.054 *2);
double starcenter_y_2 = (100 + yspace2);
double xspace2 = flagHeight * (0.063 * 2);
double starcenter_x_2 = (50 + xspace2) ;
// rows of 5 stars
l = 0;
z = 0;
for (int k = 0; k<4; k++) {
	for (int i = 0; i < 5; i++) {
		stars(radius_2, starcenter_x_2+l, starcenter_y_2+z);
		g.setColor(Color.white);
		//same note for this color section
		//red
		if (k == 0) {
			g.setColor(new Color(255, 0 , 0));
		}
		//yellow
		if (k == 1) {
			g.setColor(new Color(255, 255, 0));
		}
		//light blue
		if (k == 2) {
			g.setColor(new Color(0, 204, 255));
		}
		//indigo
		if (k == 3) {
			g.setColor(new Color(75, 0, 180));
		}
		
		g.fillPolygon(x1, y1, 10);
		l += (xspace * 2);
	}
	z += (yspace *2);
	l = 0;
}
}

//star method for creating shape to be used above
public void stars(double radius, double starcenter_x, double starcenter_y) {
for (int i = 0; i < 10; i++) {
x1[i] = (int)(xg[i] * radius);
y1[i] = (int)(yg[i] * radius);
}
for (int i = 0; i < 10; i++) {
x1[i] = (int)(x1[i] + starcenter_x);
y1[i] = (int)(y1[i] + starcenter_y);
}
}
}