package sde;

import java.awt.event.*;

public class StatediagramController 
{
	StateDiagramView sView;
	DiagramElement deModel;
	toolStrategyContext toolContext;
	StatediagramController(StateDiagramView v, DiagramElement m)
	{
		sView = v;
		deModel = m;
		sView.addStateBtnListener(new stateListioner());
		sView.addTransitionBtnListener(new transitionListioner());
		
	}
	
	class stateListioner implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			toolContext = new toolStrategyContext(new StateStrategy());
			toolContext.ExecuteDrawStrategy(deModel,sView.getGraphics());
		}
		
	}
	class transitionListioner implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			toolContext = new toolStrategyContext(new TransitionStrategy());
			toolContext.ExecuteDrawStrategy(deModel,sView.getGraphics());
		}
		
	}
}
