public class Printer {

    private String name;

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer의 인스턴스" + name + "를 생성 중");
    }

    public Printer() {
        heavyJob("Printer의 인스턴스를 생성 중");
    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            System.out.println(".");

        }
        System.out.println("완료!");
    }

    public void setPrinterName(String name) {
        this.name = name;
    }

    public String getPrinterName() {
        return name;
    }

    public void print(String string){
        System.out.println("===" + name + "===");
        System.out.println(string);
    }


}
