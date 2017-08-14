

public class CodeBlocks {
    private static String aField="";
    private String bField="";

    static {
        aField +="A";
    }

    public CodeBlocks(){
        aField+="C";
        bField+="C";
    }
    {
        aField += "B";
        bField += "B";
    }
    public void append(){
        aField+="D";
        bField+="D";
    }

    public static void main(String[] args) {
        System.out.println(aField); //A
        CodeBlocks cb = new CodeBlocks();
        cb.append();

        System.out.println(aField); //ABCD
        System.out.println(cb.bField); //BCD
    }
}
