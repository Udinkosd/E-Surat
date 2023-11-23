package action;

import javax.swing.JTable;
import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionCellRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean blnl, int i, int il){
        Component com = super.getTableCellRendererComponent(jtable, o, bln, blnl, i, il);
        
        PanelAction action = new PanelAction();
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}