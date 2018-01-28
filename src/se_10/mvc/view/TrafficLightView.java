package se_10.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

public class TrafficLightView {
	
	public void draw(Graphics g, Color c, int x, int y, int u, int v) {
		g.setColor(c);
		g.fillOval(x, y, u, v);
	}
}
