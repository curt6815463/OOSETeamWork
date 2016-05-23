package sde;


import java.awt.event.MouseEvent;






public class StateStrategy implements ToolStrategy{

	boolean isContain;
	int startX;
	int startY;
	public void draw(DiagramElement d,MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		for (DiagramElement de : ((StateDiagram)d).des)
		{
			
			if(de.s.contains(e.getX(),e.getY()))
			{
				isContain = true;
			}
		}
		if(!isContain)
		{
			State s = new State(e.getX(),e.getY());
			d.add(s);
		}
		isContain = false;
	}

	
	public void move(DiagramElement d, MouseEvent dragE,StateDiagramView sView) {
		int dx = dragE.getX() - startX;
		int dy = dragE.getY() - startY;
		for (DiagramElement e : ((StateDiagram)d).des)
		{
			if (e.s.contains(startX,startY))
			{							
				e.loc.x += dx;
				e.loc.y += dy;
				sView.update();
			}
		}
		startX += dx;
		startY += dy;
	}


	@Override
	public void released(DiagramElement d,MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
