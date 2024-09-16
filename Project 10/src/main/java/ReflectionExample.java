import java.lang.reflect.*;
import java.util.logging.Logger;
import java.util.Arrays;

class SampleClass {
    private static final Logger LOGGER = Logger.getLogger(SampleClass.class.getName());
    private final String message;

    public SampleClass(String message) {
        this.message = message;
    }

    public void printMessage() {
        LOGGER.info("Message: " + message);
    }
}

public class ReflectionExample {
    private static final Logger LOGGER = Logger.getLogger(ReflectionExample.class.getName());

    public static void main(String[] args) throws Exception {
        Class<SampleClass> clazz = SampleClass.class;

        // Fields
        for (Field field : clazz.getDeclaredFields()) {
            LOGGER.info("Field: " + field.getName() + ", Type: " + field.getType() + ", Modifiers: " + Modifier.toString(field.getModifiers()));
        }

        // Constructors
        for (Constructor<?> constructor : clazz.getConstructors()) {
            LOGGER.info("Constructor: " + constructor.getName() + ", Parameters: " + Arrays.toString(constructor.getParameterTypes()));
        }

        // Methods
        for (Method method : clazz.getMethods()) {
            LOGGER.info("Method: " + method.getName() + ", Return Type: " + method.getReturnType() + ", Parameters: " + Arrays.toString(method.getParameterTypes()));
        }

        // Create Object and Call Method
        Constructor<SampleClass> constructor = clazz.getConstructor(String.class);
        SampleClass sampleObject = constructor.newInstance("Hello, Reflection!");
        Method method = clazz.getMethod("printMessage");
        method.invoke(sampleObject);
    }
}