package sde;

import java.awt.event.MouseEvent;

interface ToolStrategy {
	void draw(DiagramElement d,MouseEvent e);
	void move(DiagramElement d,MouseEvent dragE,StateDiagramView sView);
	void released(DiagramElement d,MouseEvent e);
}
