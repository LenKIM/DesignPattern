package tablefactory;

import factory.Tray;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table width= \"100%\" border= \"1\">\"<tr>");
        return buffer.toString();
    }
}
