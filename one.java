public interface one {

    int field = 1;

    default void method(){
        System.out.println(field);
    }

}
