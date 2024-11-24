import org.omg.CORBA.DynAnyPackage.Invalid;

public class InvalidPassengerId extends RuntimeException{
    public InvalidPassengerId(String msg){
        super(msg);
    }
}
