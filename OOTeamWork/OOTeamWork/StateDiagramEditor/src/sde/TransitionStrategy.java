package sde;



import java.awt.event.MouseEvent;

public class TransitionStrategy implements ToolStrategy{
	boolean isContain = false;
	DiagramElement temp1;
	DiagramElement temp2;
	@Override
	public void draw(DiagramElement d,MouseEvent e) {
		
		
		for (DiagramElement de : ((StateDiagram)d).des)
		{
			
			if(de.s.contains(e.getX(),e.getY()))
			{
				temp1 = de;
				isContain = true;
			}
		}
	}

	@Override
	public void move(DiagramElement d, MouseEvent dragE,StateDiagramView sView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void released(DiagramElement d,MouseEvent e) {
		boolean contain = false;
		for (DiagramElement de : ((StateDiagram)d).des)
		{
				
			if(de.s.contains(e.getX(), e.getY()))
			{	
				temp2 = de;
				contain = true;
			}
		}
		
		if(isContain && contain)
		{
			Transition t = new Transition(temp1.loc,temp2.loc);
			d.add(t);
		}
		isContain = false;		
	}

	
}
