public class PrinterProxy implements Printable {

    private String name;
    private Printer real;

    public PrinterProxy() {
    }

    public PrinterProxy(String name) { // 생성자
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) { // 이름의 설정
            if(real != null){
                real.setPrinterName(name); //본인 에게도 설정한다.
            }
            this.name = name;
    }

    @Override
    public String getPrinterName() { //이름의 설정
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() { // 본인을 생성
        if(real == null){
            real = new Printer(name);
        }
    }
}
