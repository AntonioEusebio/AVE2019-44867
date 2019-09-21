import java.io.Console;
import java.lang.reflect.Type;

public class App {
    public static void main(String[] args) {
        PrintBaseTypes("Ola");
        PrintBaseTypes(19);
        PrintBaseTypes(new C());
        //PrintBaseTypes(new System.IO.DirectoryInfo("."));

        PrintMembers(new C());
        PrintMethods(new C());
        PrintFields(new C());
    }

    public static void PrintMembers(Object obj) {
        for (var m :
                obj.getClass().getMethods()) {
            System.out.print(m.getName() + " ");
        }
        for (var m :
                obj.getClass().getFields()) {
            System.out.print(m.getName() + " ");
        }
        System.out.println();
    }
    public static void PrintMethods(Object obj) {
        for (var m :
                obj.getClass().getMethods()) {
            System.out.print(m.getName() + " ");
        }
        System.out.println();
    }
    public static void PrintFields(Object obj) {
        for (var m :
                obj.getClass().getFields()) {
            System.out.print(m.getName() + " ");
        }
        System.out.println();
    }

    // Não Fazer => Avaliação em Tempo de Execução
    // static readonly Type typeOfObject = (new Object()).GetType();

    public static void PrintBaseTypes(Object obj)
    {
        Class t = obj.getClass();
        do {
            System.out.print(t.getSimpleName()+ " ");
            PrintInterfaces(t);
            t = t.getSuperclass();
        } while( !t.getSimpleName().equals("Object"));
        System.out.println();
    }
    public static void PrintInterfaces(Class t) {
        Class[] interf = t.getInterfaces();
        for (Class in:interf) {
            System.out.print("(" + in.getSimpleName() + ") ");
        }
    }
}
