package lecture13;

public class JavaHome {

    private String address;
    private LivingRoom livingRoom;

    public JavaHome(String address, LivingRoom livingRoom) {
        this.address = address;
        this.livingRoom = livingRoom;
    }

    // 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어 참조를 해지하지 못하는 경우 메모리 누수가 생길 가능성이 있고 이를 디버깅하기 어렵다.
    // 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이있다.
    // 내부 클래스를 만들 때는 static으로 만드는 것을 권장한다.
    public class LivingRoom {

        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        public String getAddress() {
            // 바깥 클래스를 직접 참조하여 사용할 수 있다.
            return JavaHome.this.address;
        }
    }

//    public static class LivingRoom {
//
//        private double area;
//
//        public LivingRoom(double area) {
//            this.area = area;
//        }
//
//        public String getAddress() {
//            // 바깥 클래스를 직접 참조하여 사용할 수 있다.
//            return JavaHome.this.address;
//        }
//    }
}
