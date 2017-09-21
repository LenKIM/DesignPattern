//
//public class TicketMaker2 {
//
//    int id;
//
//    private final static int InstanceSize = 3;
//
//    TicketMaker2[] instance = new TicketMaker2[]{
//            new TicketMaker2(0),
//            new TicketMaker2(1),
//            new TicketMaker2(2),
//    };
//
//    private TicketMaker2(int id) {
//        this.id = id;
//    }
//
//    public static TicketMaker2[] getInstance(int id) {
//        return instance[id];
//    }
//}


//public class Practice {
//
//    public class TicketMaker {
//        private int ticket = 1000;
//
//        public int getNextTicketNumber() {
//            return ticket++;
//        }
//    }
//
//    //    바꿔보면
//    public class TicketMaker2 {
//        private int ticket = 1000;
//
//        private TicketMaker2 instance = new TicketMaker2();
//
//        private TicketMaker2() {
//            this.ticket = ticket;
//        }
//
//        public TicketMaker2 getInstance() {
//            System.out.println(ticket++);
//            return instance;
//        }
//    }
//}

