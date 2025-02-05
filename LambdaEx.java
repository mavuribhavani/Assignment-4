import java.util.*;
interface StringProcessor{
    String process(String str);
}
public class LambdaEx
{
    public static void main(String args[])
    {
        List<String> names=Arrays.asList("Hubby","Viswa","Kumar","Jittu","Ananadam");
        names.sort((s1,s2)->s2.compareTo(s1));
        System.out.println("sorted in reverse order"+names);
        StringProcessor toUpperCaseProcessor=String::toUpperCase;
        System.out.println("Uppercase Strings:");
        names.forEach(name -> System.out.println(toUpperCaseProcessor.process(name)));
        
    }
}
