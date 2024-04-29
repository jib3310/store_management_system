import java.util.Objects;
import java.util.Scanner;

public class AdminInfo {
    private String name;
    private String id;
    private String fName;
    private String surname;
    private String[] nameArray;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {

        this.name = name;
        name = name.trim(); //remove space avoid error
    }

    public boolean getUserName()
    {
        Scanner scannerN = new Scanner(System.in);
        String tempFname;
        String tempSname;

        System.out.println("enter first name");
        tempFname = scannerN.nextLine();
        System.out.println("enter surname (type - if no surname)");
        tempSname = scannerN.nextLine();

        if (Objects.equals(tempSname, "-"))setName(tempFname);
        else setName(tempFname+ " " +tempSname);
        return true;

    }


    public boolean checkValid()
    {
        if (name.isEmpty()) return false; //means no input

        char[] charArray; //for check valid name
        charArray = name.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetter(c)) if(!Character.isWhitespace(c)) return false; //when not letter and not space
        }

        if (name.contains(" ")) //for name >2 words
        {
            nameArray = name.split(" ");
        }
        return true;
    }

    public boolean setId()
        {
            if (name.contains(" "))  //means have two words
            {
                fName = nameArray[0];
                surname = nameArray[nameArray.length-1];
                id = fName.charAt(0)+(surname);
            }
            else id = "guest";  // means no space one words only
            return true;
        }

    }



