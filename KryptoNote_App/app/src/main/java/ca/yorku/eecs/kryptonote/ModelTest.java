package ca.yorku.eecs.kryptonote;

public class ModelTest
{
    public static void main(String args[]){
        try
        {
            CipherModel cp = new CipherModel("1234");
            String s = cp.encrypt("THIS IS A TEST");
            String c = cp.decrypt("UJLWAKVDBBWITV");
            System.out.print(s);


        }
        catch (Exception e){
            // display e.getmessage()
        }
}
}
