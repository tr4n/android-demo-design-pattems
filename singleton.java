public class EagerInitializedSingleton {
 
    private static final 
     EagerInitializedSingleton instance = new EagerInitializedSingleton();
 
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}
 
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}

public class StaticBlockSingleton {
 
    private static StaticBlockSingleton instance;
 
    private StaticBlockSingleton(){}
 
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new 
             RuntimeException("Exception occured in creating singleton instance");
        }
    }
 
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}

public class LazyInitializedSingleton {
 
    private static LazyInitializedSingleton instance;
 
    private LazyInitializedSingleton(){}
 
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

public class ThreadSafeSingleton {
 
    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
}

public class BillPughSingleton {
 
    private BillPughSingleton(){}
 
    private static class SingletonHelper{
        private static final BillPughSingleton 
                      INSTANCE = new BillPughSingleton();
    }
 
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}

    public static ThreadSafeSingleton getInstance(){
        if(instance == null){
            synchronized(ThreadSafeSingleton.class){
               instance = new ThreadSafeSingleton();
            }
        }
        return instance;
     }
}
