package nowcoder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CaseRunner {

    public CaseRunner() {

    }

    public void run(Class<?> clazz) {
        Class<?> solutionClass = getSolutionClass(clazz);
        String baseResourcePath = clazz.getPackage().getName().replace(".", "/");
        String name = clazz.getSimpleName();
        String input = name + ".input";
        String output = name + ".output";
        PrintStream stdOut = System.out;
        InputStream stdIn = System.in;
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(baseResourcePath + "/" + input);
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            Method runMethod = solutionClass.getMethod("run");
            Object solution = solutionClass.newInstance();
            runMethod.invoke(solution);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Solution class must have method run", e);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalStateException("Failed to call run method", e);
        }

        System.setIn(stdIn);
        System.setOut(stdOut);

        System.out.println("Result of " + clazz.getSimpleName());
        System.out.println(new String(outputStream.toByteArray()));
    }

    private Class<?> getSolutionClass(Class<?> clazz) {
        for (Class<?> declaredClass : clazz.getDeclaredClasses()) {
            if ("Solution".equals(declaredClass.getSimpleName())) {
                return declaredClass;
            }
        }
        throw new IllegalArgumentException("No class named Solution found in " + clazz.getName());
    }
}
